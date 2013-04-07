/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.edu.Simulator;


import iu.edu.civ.unit.*;
import iu.edu.civ2.*;
import iu.edu.civ.*;
import iu.edu.movement.NavigationUtils;
import iu.edu.movement.Path;
import iu.edu.movement.Path.Step;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Shrutika
 */
public class GameEngine implements Serializable 
{
    
    public static final boolean DEBUGCITY = false;
    
    private World world;
    private Unit unitManager;
    private TerrainManager terrainManager;
    private Map maps;
    
    //private transient CityManager cityManager;
    private transient NavigationUtils navUtils;
    private transient CombatManager combatManager;
    //private transient MapView mapView;
    //private transient CivFrame disposeMe;
    
    private int turnCount = 0;
    private int turnCycle = 0;
    private int numberPlayers;
    private Random randomGenerator = new Random();
    
    private Player currentPlayer;
    private MapLocation[] spawnLocations;
            
    private Unit currentlySelectedUnit;
    //private City currentlySelectedCity;
    private ArrayList<Player> GPlayers = new ArrayList(8);
    
    private char selectedAction; // Last selected action
    
    private ArrayList<Integer> inputArray = new ArrayList<Integer>();
    private int[] specialCode = new int[10];

    //Getter for world (used by the mapView and miniMapView)
    public World getWorld()
    {
        return world;
    }

    public Player getCurPlayer()
    {
        return currentPlayer;
    }

    public GameEngine(int NumberPlayers, String filepath, ArrayList Players, Boolean defaultSpawnLocations)
    {
        try
        {
            GPlayers = Players;
            numberPlayers = NumberPlayers;
            world = World.createWorld(filepath);
            //unitManager = new Unit(world);
            terrainManager = new TerrainManager(world);
            
            maps = world.getMap();

            if(defaultSpawnLocations == true){
                ArrayList<MapLocation> spawns = MapInfoCollector.getSpawnLocations(filepath);
                spawnLocations = new MapLocation[NumberPlayers];
                //Go through the location and grab an appropraite number of random ones.
                for(int i = 0; i < numberPlayers; i++)
                {
                    int index = randomGenerator.nextInt(spawns.size());
                    spawnLocations[i] = spawns.get(index);
                    spawns.remove(index);
                }
                for(int i = 0; i < numberPlayers; i++){
                    currentPlayer = GPlayers.get(i);
                    MapLocation mapLoc = spawnLocations[i];
                    MapLocation mapLocX = new MapLocation(mapLoc.x+1,mapLoc.y);
                    MapLocation mapLocY = new MapLocation(mapLoc.x,mapLoc.y+1);
                    if("Ocean".equals(world.getTile(mapLocX).getBaseTerrainType())) mapLocX = new MapLocation(mapLoc.x-1,mapLoc.y);
                    if("Ocean".equals(world.getTile(mapLocY).getBaseTerrainType())) mapLocY = new MapLocation(mapLoc.x,mapLoc.y-1);
                    
                    currentPlayer.setCapitallocation(mapLoc);
                    Warrior w = new Warrior();
                    Archer a=new Archer();
                    createUnit(w, new MapLocation(mapLocX));
                    createUnit(a, new MapLocation(mapLocY));
                }
            }
            if(defaultSpawnLocations == false){
                for(int i = 0; i < numberPlayers; i++){
                    currentPlayer = GPlayers.get(i);
                    MapLocation mapLoc = new MapLocation(randomGenerator.nextInt(maps.getMapWidth()-2),randomGenerator.nextInt(maps.getMapHeight()-2));
                    MapLocation mapLocX = new MapLocation(mapLoc.x+1,mapLoc.y);
                    MapLocation mapLocY = new MapLocation(mapLoc.x,mapLoc.y+1);

                    while("Ocean".equals(world.getTile(mapLoc).getBaseTerrainType()) || "Ocean".equals(world.getTile(mapLocX).getBaseTerrainType()) || "Ocean".equals(world.getTile(mapLocX).getBaseTerrainType())
                            || isEnemyObstacle(mapLoc) == true || isEnemyObstacle(mapLocX) == true || isEnemyObstacle(mapLocY) == true){
                        mapLoc = new MapLocation(randomGenerator.nextInt(maps.getMapWidth()-2),randomGenerator.nextInt(maps.getMapHeight()-2));
                        mapLocX = new MapLocation(mapLoc.x+1,mapLoc.y);
                        mapLocY = new MapLocation(mapLoc.x,mapLoc.y+1);
                    }
                    //createCity("Capital", GPlayers.get(i).getBuildingStyle(), mapLoc);
                    currentPlayer.setCapitallocation(mapLoc);
                    Warrior w = new Warrior();
                    Archer a=new Archer();
                    createUnit(w, new MapLocation(mapLocX));
                    createUnit(a, new MapLocation(mapLocY));
                }
            }
            
            
            currentPlayer = GPlayers.get(0);
            
           // SpriteUtils.getInstance().setWorld(world);
            navUtils = new NavigationUtils(world, terrainManager);
            combatManager = new CombatManager(world, terrainManager);
            selectedAction = ' ';
            
            updateResearchTree(currentPlayer);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    public void addUnit(Archer unit) {
        world.addUnit(unit);
        currentPlayer.addUnit(unit);


    }
public void addUnit(Axeman unit) {
        world.addUnit(unit);
        currentPlayer.addUnit(unit);
        
        
    }
public void addUnit(Cannon unit) {
        world.addUnit(unit);
        currentPlayer.addUnit(unit);
        
       
    }
public void addUnit(Catapult unit) {
        world.addUnit(unit);
        currentPlayer.addUnit(unit);
        
    }
public void addUnit(Chariot unit) {
        world.addUnit(unit);
        currentPlayer.addUnit(unit);
        
    }
public void addUnit(HourseArcher unit) {
        world.addUnit(unit);
        currentPlayer.addUnit(unit);
        
    }
public void addUnit(Knight unit) {
        world.addUnit(unit);
        currentPlayer.addUnit(unit);
       
    }
public void addUnit(Longbowman unit) {
        world.addUnit(unit);
        currentPlayer.addUnit(unit);
        
    }
public void addUnit(Maceman unit) {
        world.addUnit(unit);
        currentPlayer.addUnit(unit);
        
    }
public void addUnit(Pikeman unit) {
        world.addUnit(unit);
        currentPlayer.addUnit(unit);
        
    }
public void addUnit(Spearman unit) {
        world.addUnit(unit);
        currentPlayer.addUnit(unit);
        
    }
public void addUnit(Warrior unit) {
        world.addUnit(unit);
        currentPlayer.addUnit(unit);
        
        
    }
    
    /**
     * This method permanently removes a unit from the game.
     * Removes a unit from the world, a city if it exists, and the unit's owner.
     * @param unit The unit to be removed from the game
     */
    public void removeUnit(Unit unit) {
        world.removeUnit(unit);
   
    }
    
   
    
    public int getYear(){
        return Math.abs(2000 - turnCount*40);
    }

    public int getTurn(){
        return turnCount;
    }

    
   
    public void setUnitDestination(MapLocation desiredLocation) {

        if (currentlySelectedUnit == null){
            return;
        }
           
        MapLocation previousLocation = currentlySelectedUnit.getMapLocation();
        
        // If we're trying to move to our current location, deselect the current unit.
        if(previousLocation.compare(desiredLocation)){
            currentlySelectedUnit = null;
            System.out.println(desiredLocation.x +" "+desiredLocation.y);
            return;
        }
   
        
        // Clear visited 2D array so that the pathfinding algorithm can find the shortest path.
        world.getMap().clearVisited();
        
        // Get the shortest path from previousLocation to desiredLocation and set currentlySelectedUnit's movement queue accordingly.
        Path moveList = navUtils.findPath(currentlySelectedUnit, previousLocation, desiredLocation);
        currentlySelectedUnit.setMoveList(moveList);
        updateUnitLocation(currentlySelectedUnit);
        removeUnitQueue();
    }
    
    
    /**
     * Checks if there is an enemy obstacle (City or Unit) at the given
     * mapLocation
     * @param mapLocation The mapLocation being checked
     * @return true if there is an enemy obstacle, false otherwise
     */
    private boolean isEnemyObstacle(MapLocation mapLocation) {
        if (isEnemyUnit(mapLocation)) {
            return true;
        }   
        return false;
    }
    
    /**
     * Determines if the units at a given MapLocation are enemies.
     * @param mapLocation The mapLocation of the tile being checked
     * @return true if the unit belongs to the currentPlayer, false otherwise.
     */
    private boolean isEnemyUnit(MapLocation mapLocation) {
        ArrayList<Unit> units;
        units = world.getUnitList(mapLocation);
        if (units.isEmpty()) {
            return false;
        } else if (world.getUnitList(mapLocation).get(0).getOwner().equals(currentPlayer)) {
            return false;
        } else {
            return true;
        }
   }     
 
   
  
    
   public Unit getCurrentlySelectedUnit() {
        return currentlySelectedUnit;
   }
   
   
    
   public MapLocation getCurrentlySelectedUnitTile() {
        if(currentlySelectedUnit == null) return null;
        return currentlySelectedUnit.getMapLocation();
   }
   

   
   public NavigationUtils getNavigationUtils() {
       return this.navUtils;
   }

   
    private void updateUnitLocation(Unit unit) {
        MapLocation desiredLocation = unit.getMapLocation();
        
        // Are we still allowed to move this turn?
        int movementAvailable = (int) unit.getMovement();
        
        // If we have a unit that doesn't have a movement path (ie. isn't moving, or set to move)
        if(unit.getPath() == null || unit.getState() == Unit.State.MOVE_BLOCKED) {
            return;
        }
        
        // Movement occurs here
        while(unit.getPath().getLength() != 0) {
            unit.setState(Unit.State.MOVING);
            
            // Get the MapLocation corresponding to the next step in our movement queue
            Step step = unit.getPath().getStep(0);
            desiredLocation = new MapLocation(step.getX(), step.getY());
            
            int terrainCost = (int) terrainManager.getTerrainInfo(desiredLocation).getMovementCost();
                    
            
            if(unit.getMapLocation().compare(desiredLocation)) {
            // If we're trying to move to the square we're already on, do nothing
                unit.getPath().removeCurrentStep();
                continue;
            }
            
            // If we don't have enough remaining movement to move here this turn, don't move.
            if(movementAvailable - terrainCost < 0 
                    && !(movementAvailable == unit.getMovement() && movementAvailable < terrainCost))
            {
                break;  
            }
            
            // Otherwise, remove the current step from our movement list, and move.
            unit.getPath().removeCurrentStep();
            
            movementAvailable -= terrainCost;
            
            // Check for enemy units
            if(isEnemyUnit(desiredLocation)) {
                combatManager.collision((MilitaryUnit) unit, desiredLocation);
                movementAvailable = 0;
                if (world.getUnitList(desiredLocation).isEmpty()) {
                    moveUnit(unit, desiredLocation);
                }
                
                //Better way to draw a fight needed
               // mapView.paintMap();
                
                //Unit is dead bro
                if (unit == null) {
                    return;
                } 
            }else if(world.getUnitList(desiredLocation).isEmpty()==false && world.getUnitList(desiredLocation).get(0).isTransport() == true ){
                    ArrayList<Unit> unitList = world.getUnitList(desiredLocation);
                    
                    unit.getOwner().addToRemoveQueue((MilitaryUnit) unit);
            }else{
                moveUnit(unit, desiredLocation);
            }
        }

        // Game engine flags for drawing our unit decorations properly
        if(movementAvailable <= 0)
            unit.setState(Unit.State.MOVE_BLOCKED); // This will still have a "G" decoration, but it also signifies we can't move any more this turn.         
    }
    
    /**
     * Takes care of the logic of moving a unit from its current tile to the
     * desiredLocation it wants to move. It removes the unit from it's
     * location in the world and if it was in a city, and adds it to the new
     * location in the world.
     * @param unit The unit that is being moved
     * @param desiredLocation The location the unit wants to be moved to.
     */
    private void moveUnit(Unit unit, MapLocation desiredLocation) {
        world.removeUnit(unit);       
        //If the unit was on a city, remove it from that city as well.
        if (isCity(unit.getMapLocation())) {
        //   
        }
        MapLocation previousLocation = new MapLocation(unit.getMapLocation());
        unit.setLocation(desiredLocation);
        world.addUnit(unit);
        

       
    }
    
    /**
     * Loop through the current player's list of units and update their locations if necessary.
     * @param currentPlayer The current player whose units are to be iterated over.
     */
    private void updateUnits(Player currentPlayer) {
        if(!(currentPlayer.getUnits().isEmpty())) {
            /*
             * If you end up here with a weird error, then you're probably
             * modifying the current player's unit list further down.
            */
            for(Unit unit : currentPlayer.getUnits()) {
                if(unit.getPath() != null && unit.getPath().getLength() >= 1) {
                    // Tell the engine that the current unit is moving (so that we can draw a nice G icon on it)
                    unit.setState(Unit.State.MOVING);
                } else {
                    // Tell the engine the unit is no longer moving (remove all decorations on it)
                    unit.setState(Unit.State.IDLE);
                }
                updateUnitLocation(unit);
            }
            removeUnitQueue();
        }
    }
    
    /**
     * Creates a city from a settler unit.
     
    public void createCityFromSettler() {
        
        // If we don't have a settler selected, you can't do this bro
        if(!(getCurrentlySelectedUnit().getUnitType() == UnitType.SETTLERS))
            return;
       if (world.getCity(getCurrentlySelectedUnitTile()) != null) {
           JOptionPane.showMessageDialog(mapView, "Can't build a city on a city");
           return;
       }
        // Promp the user for the new city's name        
        String newCityName = JOptionPane.showInputDialog("Enter a new city name.", null);
        if(newCityName != null) {
            removeUnit(currentlySelectedUnit);
            createCity(newCityName, currentPlayer.getBuildingStyle(), getCurrentlySelectedUnitTile());
            mapView.drawTile(getCurrentlySelectedUnitTile());
            currentlySelectedUnit = null;
        }
    }
    
    /**
     * Returns a basic unit object with a UnitType's information within. This is
     * only used to determine the number of turns a unit will take so far.
     * @param unitType The type of unit to get unit info about
     * @return A Unit object with the specified UnitType's information.
     */
    

    /**
     * Prepares the currently selected unit for movement, if it exists. By prepare,
     * it means it sets the current command to 'g'
     */
    public void readyUnitForMovement() {
        if (getCurrentlySelectedUnit() == null) {
            return;
        }
    }
    
    public void holdUnitForMovement() {
        if (getCurrentlySelectedUnit() == null) {
            return;
        }
        
        getCurrentlySelectedUnit().setMoveList(null);
        getCurrentlySelectedUnit().setState(Unit.State.IDLE);
        
    }      
    public void nextTurn() {    
        //set location of current player before moving to the next player
        
        turnCycle = turnCycle + 1;
        if(turnCycle == numberPlayers){
            turnCount = turnCount + 1;
            turnCycle = 0;
        }
        currentPlayer = GPlayers.get(turnCycle);
        MapLocation location;
        updateUnits(currentPlayer);
        
        //get the location of the new player and then center the location
        location = currentPlayer.getCurrentViewCenter();
        
        //Create all the units queued up to be created this turn
        
        currentPlayer.getUnitCreateQueue().clear();
        updateResearchTree(currentPlayer);
        currentlySelectedUnit = null;

    }

  
    public void setCurrentlySelectedUnit(Unit currentlySelectedUnit) {
        this.currentlySelectedUnit = currentlySelectedUnit;
    }


  

    private void updateResearchTree(Player currentPlayer) {
        currentPlayer.getResearchTree().nextTurn(currentPlayer.getScience(), currentPlayer.getName());
    }

    

    public Terrain getTerrainInfo(MapLocation e)
    {
        return terrainManager.getTerrainInfo(e);
    }
    
    public void addToInputArray(int i) {
        if (currentPlayer.unlocked) {
            return;
        }
        if (inputArray.size() >= 10) {
            inputArray.remove(0);
        }
        inputArray.add(i);
        
        if (isKonamiCode()) {
            //currentPlayer.getResearchTree().unlockUnits();
            
        }
    }
    
    private boolean isKonamiCode() {
        try {
            for (int i = 0; i < specialCode.length; i++) {
                if (inputArray.get(i) != specialCode[i]) {
                    return false;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }
    
  

    private void removeUnitQueue() {
        for (Unit unit : currentPlayer.getRemoveQueue()) {
            removeUnit(unit);
        }
        currentPlayer.getRemoveQueue().clear();
        
    }    

    private void checkForWinner() {
        if(GPlayers.size() == 1) {
            System.out.println(currentPlayer);
            System.exit(0);
        }
    }

    
    private void createUnit(Warrior w, MapLocation mapLocation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void createUnit(Archer a, MapLocation mapLocation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean isCity(MapLocation mapLocation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

