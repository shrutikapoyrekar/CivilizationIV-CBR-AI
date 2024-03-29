/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.edu.civ2;

import java.io.Serializable;

/**
 *
 * @author Shrutika Poyrekar
 */
public class Map implements Serializable
{
    private int tileSize;
    private int mapWidth;
    private int mapHeight;
    private Tile[][] tileSet;
    private boolean[][] visited;

    
    public Map()
    {
        
    }

    public Map(Tile[][] tiles)
    {
        this.mapWidth = tiles.length;
        this.mapHeight = mapWidth > 0?tiles[0].length:0;
        this.tileSet = tiles;
        visited = new boolean[mapWidth][mapHeight];
    }
    
    public int getTileSize()
    {
        return tileSize;
    }
    
    public int getMapWidth()
    {
        return mapWidth;
    }

    public int getMapHeight()
    {
        return mapHeight;
    }

    public Tile tileAt(MapLocation location) throws IllegalArgumentException
    {
        return this.tileAt(location.x, location.y);
    }

    public Tile tileAt(int x, int y)
    {
        //We can wrap das map
        return this.tileSet[((x%mapWidth)+mapWidth)%mapWidth][((y%mapHeight)+mapHeight)%mapHeight];
    }
    
    public void pathFinderVisited(int x, int y) 
    {
        visited[x][y] = true;
    }
    
    public boolean visited(int x, int y) 
    {
        return visited[x][y];
    }
    
    public void clearVisited() 
    {
        for(int i = 0; i < mapWidth; i++)
            for(int j = 0; j < mapHeight; j++)
                visited[i][j] = false;
    }

    public boolean wraps() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

