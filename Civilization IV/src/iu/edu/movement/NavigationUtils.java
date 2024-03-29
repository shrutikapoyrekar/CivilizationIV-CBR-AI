/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.edu.movement;

import iu.edu.Simulator.*;
import iu.edu.civ.unit.Unit;
import iu.edu.civ2.*;
import java.util.ArrayList;

/**
 *
 * @author scaa890809
 */
public class NavigationUtils {
    private World world;
    private ArrayList closed = new ArrayList();
    private SortedList open = new SortedList();
   
    private Map gameMap;
    private TerrainManager terrainManager;
    
    private Node[][] nodes;
    private ManhattanHeuristic heuristic;
    
    public NavigationUtils(World world, TerrainManager tM) {
        this.heuristic = new ManhattanHeuristic();
        this.world = world;        
        this.gameMap = world.getMap();
        this.terrainManager = tM;
        
        int mapWidth = gameMap.getMapWidth();
        int mapHeight = gameMap.getMapHeight();
        
        // Create array of pathfinding nodes
        nodes = new Node[mapWidth][mapHeight];
        for(int x = 0; x < mapWidth; x++) {
            for(int y = 0; y < mapHeight; y++) {
                nodes[x][y] = new Node(x, y);
            }
        }
        
    }
  
    /**
     * Find the shortest path to given destination on map while taking into account terrain cost and terrain restrictions.
     * @param unit unit to be moved
     * @param currentLocation current location of the unit to be moved
     * @param moveToLocation destination location
     * @return the shortest path to the destination
     */
    public Path findPath(Unit unit, MapLocation currentLocation, MapLocation moveToLocation) {
        nodes[currentLocation.x][currentLocation.y].cost = 0;
        
        closed.clear(); // closed nodes (already been searched)
        open.clear(); // open nodes (available to be searched)
        
        open.add(nodes[currentLocation.x][currentLocation.y]);
        
        nodes[moveToLocation.x][moveToLocation.y].parent = null;
        
        // while we haven't found our destination
        while(open.size() != 0) {
            
            // Get the most likely node to be our destination based on the heuristic
            Node current = getFirstInOpen();
            if(current == nodes[moveToLocation.x][moveToLocation.y]) {
                break;
            }
            
            removeFromOpen(current);
            addToClosed(current);
            
            // find al neighbouring nodes while taking into account map wrapping
            ArrayList<Integer> x = getAroundX(current.x);
            ArrayList<Integer> y = getAroundY(current.y);
            
            // Iterate through and evaluate which one is the best "next step"
            for(int xValue : x) {
                for(int yValue : y) {
                    
                    // This is a brute force ignore of all diagonal tiles around the current square while taking into consideration wrapped maps if necessary.
                    if(((xValue + 1 > gameMap.getMapWidth() - 1 ? 0 : xValue + 1) == current.x && ((yValue == current.y - 1) || yValue == current.y + 1))
                        || ((xValue - 1 < 0 ? gameMap.getMapWidth() - 1 : xValue - 1) == current.x && ((yValue == current.y - 1) || yValue == current.y + 1)))
                        continue;
                        
                    // Ignore current node
                    if(xValue == currentLocation.x && yValue == currentLocation.y)
                        continue;
                    
                    int xp = xValue;
                    int yp = yValue;
                   
                   ////////////////////////////////////////////////////////////
                        
                        // Get neighbour tile's movement cost.
                        float nextStepCost = current.cost + terrainManager.getTerrainInfo(new MapLocation(xp, yp)).getMovementCost();
                        Node neighbour = nodes[xp][yp];
                        gameMap.pathFinderVisited(xp, yp);
                        
                        // A better path may have been found. Re-evaluate this node.
                        if(nextStepCost < neighbour.cost) {
                            if(inOpenList(neighbour)) {
                                removeFromOpen(neighbour);
                            }
                            if(inClosedList(neighbour)) {
                                removeFromClosed(neighbour);
                            }
                        }
                        
                        // Add neighbour node as a possible next step
                        if(!(inOpenList(neighbour)) && !(inClosedList(neighbour))) {
                            neighbour.cost = nextStepCost;
                            neighbour.heuristicCost = heuristic.getCost(xp, yp, moveToLocation.x, moveToLocation.y, gameMap.getMapWidth(), gameMap.getMapHeight());
                            neighbour.setParent(current);
                            addToOpen(neighbour);
                        }
                    
                    
                }
            }
        }
        
        // No way was found to our destination, so return null
        if(nodes[moveToLocation.x][moveToLocation.y].parent == null) {
            return null;
        }

        // Otherwise, we found a way to our destination. Construct a path to it and return.
        Path path = new Path();
        Node target = nodes[moveToLocation.x][moveToLocation.y];
        while(target != nodes[currentLocation.x][currentLocation.y]) {
            path.prependStep(target.x, target.y);
            target = target.parent;
        }

        path.prependStep(currentLocation.x, currentLocation.y);

        return path;
    }

    private Node getFirstInOpen() {
        return (Node)open.getFirst();
    }
    
    private void addToOpen(Node node) {
        open.add(node);
    }
    
    private boolean inOpenList(Node node) {
        return open.contains(node);
    }
    
    private void removeFromOpen(Node node) {
        open.remove(node);
    }
    
    private void addToClosed(Node node) {
        closed.add(node);
    }
    
    private boolean inClosedList(Node node) {
        return closed.contains(node);
    }
    
    private void removeFromClosed(Node node) {
        closed.remove(node);
    }
    
    
    
        
    
    
    
    // Get the x co-ordinates of the nodes to the right and left of the current node.
    // This takes into account that the map wraps.
    private ArrayList getAroundX(int xLocation) {
        ArrayList aroundX = new ArrayList();
        
        /* Ternary expressions to evaluate tiles to the left and right of the current tile
         * while keeping in mind maps that can wrap/not wrap.
         */
        int leftX = gameMap.wraps() ? (((xLocation - 1) < 0) ? gameMap.getMapWidth() - 1 : (xLocation - 1)) 
                : (((xLocation - 1) < 0) ? 0 : (xLocation - 1));
        int rightX = gameMap.wraps() ? (((xLocation + 1) > gameMap.getMapWidth() - 1) ? 0 : xLocation + 1) 
                : (((xLocation + 1) > gameMap.getMapWidth() - 1) ? gameMap.getMapWidth() - 1 : xLocation + 1);
        
        aroundX.add(leftX);
        aroundX.add(xLocation);
        aroundX.add(rightX);
        
        return aroundX;
    }
   
    // Get the y co-ordinates of the nodes directly above and below the current node. (If they exist)
    private ArrayList getAroundY(int yLocation) {
        ArrayList aroundY = new ArrayList();
        
        int upY = ((yLocation - 1) < 0) ? -1 : (yLocation - 1);
        int downY = ((yLocation + 1) > gameMap.getMapHeight() - 1) ? -1 : yLocation + 1;
        
        if(upY != -1)
            aroundY.add(upY);
        
        aroundY.add(yLocation);
        
        if(downY != -1)
            aroundY.add(downY);
        
        return aroundY;
    }    
}
