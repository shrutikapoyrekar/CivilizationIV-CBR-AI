/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.edu.civ2;

import iu.edu.civ.unit.Unit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public class World implements Serializable
{
    
    private Player[] players;
    private int year;
    private Map gameMap;   
    private HashMap<String, ArrayList<Unit>> unitMap;
        
    public World(Map map)
    {
        this.year = 0;
        gameMap = map;
        unitMap = new HashMap<String, ArrayList<Unit>>();
        initUnitMap();
    }
    
    //Initialize the unitMap to have empty arrays at all MapLocations.
    private void initUnitMap() 
    {
        MapLocation initLocation = new MapLocation(0,0);
        for (initLocation.y = 0; initLocation.y < gameMap.getMapHeight(); initLocation.y++) 
        {
            for (initLocation.x = 0; initLocation.x < gameMap.getMapWidth(); initLocation.x++) 
            {
                unitMap.put(initLocation.toString(), new ArrayList<Unit>());
            }
        }
    }

    // Returns the specific tile located at a certain x and y coordinate.
    public Tile getTile(MapLocation mapLocation)
    {
        return gameMap.tileAt(mapLocation);
    }

    public Tile getTile(int x, int y)
    {
        return gameMap.tileAt(x, y);
    }

    //Used by the mapView and miniMapView
    public Map getMap()
    {
        return gameMap;
    }  
    
    public ArrayList<Unit> getUnitList(MapLocation mapLocation){
        return unitMap.get(mapLocation.toString());
    }
    
    public void removeUnit(Unit unit) 
    {
        unitMap.get(unit.getMapLocation().toString()).remove(unit);
    }
    
    public void addUnit(Unit unit) 
    {
        // not able to add ???
        
        
    }
    
    public static World createWorld(String filepath)
    {
        return null;
        //return new World(MapGenerator.constructMap(filepath));

        /*
        int width = 21;
        int height = 19;
        Tile[][] tileSet = new Tile[width][height];
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                tileSet[x][y] = new Tile(x,y,TerrainType.GRASSLAND, TerrainBonusType.NONE, false, false, false);
            }
        }

        tileSet[1][1].setTerrainType(TerrainType.DESERT);
        tileSet[1][3].setTerrainType(TerrainType.FOREST);
        tileSet[1][5].setTerrainType(TerrainType.GLACIER);
        tileSet[1][7].setTerrainType(TerrainType.TUNDRA);
        tileSet[1][9].setTerrainType(TerrainType.HILLS);
        tileSet[1][11].setTerrainType(TerrainType.JUNGLE);
        tileSet[1][13].setTerrainType(TerrainType.MOUNTAINS);
        tileSet[1][15].setTerrainType(TerrainType.OCEAN);
        tileSet[1][17].setTerrainType(TerrainType.SWAMP);

        //Uncomment the first to have a hole in the middle
        //tileSet[4][4].setTerrainType(TerrainType.DESERT);
        tileSet[3][3].setTerrainType(TerrainType.DESERT);
        tileSet[5][5].setTerrainType(TerrainType.DESERT);
        tileSet[3][5].setTerrainType(TerrainType.DESERT);
        tileSet[5][3].setTerrainType(TerrainType.DESERT);
        tileSet[2][4].setTerrainType(TerrainType.DESERT);
        tileSet[3][4].setTerrainType(TerrainType.DESERT);
        tileSet[5][4].setTerrainType(TerrainType.DESERT);
        tileSet[6][4].setTerrainType(TerrainType.DESERT);
        tileSet[4][2].setTerrainType(TerrainType.DESERT);
        tileSet[4][3].setTerrainType(TerrainType.DESERT);
        tileSet[4][5].setTerrainType(TerrainType.DESERT);
        tileSet[4][6].setTerrainType(TerrainType.DESERT);

        //Uncomment the first to have a hole in the middle
        //tileSet[4][10].setTerrainType(TerrainType.GLACIER);
        tileSet[3][9].setTerrainType(TerrainType.GLACIER);
        tileSet[5][11].setTerrainType(TerrainType.GLACIER);
        tileSet[3][11].setTerrainType(TerrainType.GLACIER);
        tileSet[5][9].setTerrainType(TerrainType.GLACIER);
        tileSet[2][10].setTerrainType(TerrainType.GLACIER);
        tileSet[3][10].setTerrainType(TerrainType.GLACIER);
        tileSet[5][10].setTerrainType(TerrainType.GLACIER);
        tileSet[6][10].setTerrainType(TerrainType.GLACIER);
        tileSet[4][8].setTerrainType(TerrainType.GLACIER);
        tileSet[4][9].setTerrainType(TerrainType.GLACIER);
        tileSet[4][11].setTerrainType(TerrainType.GLACIER);
        tileSet[4][12].setTerrainType(TerrainType.GLACIER);

        //Uncomment the first to have a hole in the middle
        //tileSet[10][4].setTerrainType(TerrainType.OCEAN);
        tileSet[9][3].setTerrainType(TerrainType.OCEAN);
        tileSet[11][5].setTerrainType(TerrainType.OCEAN);
        tileSet[9][5].setTerrainType(TerrainType.OCEAN);
        tileSet[11][3].setTerrainType(TerrainType.OCEAN);
        tileSet[8][4].setTerrainType(TerrainType.OCEAN);
        tileSet[9][4].setTerrainType(TerrainType.OCEAN);
        tileSet[11][4].setTerrainType(TerrainType.OCEAN);
        tileSet[12][4].setTerrainType(TerrainType.OCEAN);
        tileSet[10][2].setTerrainType(TerrainType.OCEAN);
        tileSet[10][3].setTerrainType(TerrainType.OCEAN);
        tileSet[10][5].setTerrainType(TerrainType.OCEAN);
        tileSet[10][6].setTerrainType(TerrainType.OCEAN);

        //Uncomment the first to have a hole in the middle
        //tileSet[10][10].setTerrainType(TerrainType.JUNGLE);
        tileSet[9][9].setTerrainType(TerrainType.JUNGLE);
        tileSet[11][11].setTerrainType(TerrainType.JUNGLE);
        tileSet[9][11].setTerrainType(TerrainType.JUNGLE);
        tileSet[11][9].setTerrainType(TerrainType.JUNGLE);
        tileSet[8][10].setTerrainType(TerrainType.JUNGLE);
        tileSet[9][10].setTerrainType(TerrainType.JUNGLE);
        tileSet[11][10].setTerrainType(TerrainType.JUNGLE);
        tileSet[12][10].setTerrainType(TerrainType.JUNGLE);
        tileSet[10][8].setTerrainType(TerrainType.JUNGLE);
        tileSet[10][9].setTerrainType(TerrainType.JUNGLE);
        tileSet[10][11].setTerrainType(TerrainType.JUNGLE);
        tileSet[10][12].setTerrainType(TerrainType.JUNGLE);

        //Uncomment the first to have a hole in the middle
        //tileSet[16][4].setTerrainType(TerrainType.PLAINS);
        tileSet[6][6].setTerrainType(TerrainType.PLAINS);
        tileSet[8][8].setTerrainType(TerrainType.PLAINS);
        tileSet[6][8].setTerrainType(TerrainType.PLAINS);
        tileSet[8][6].setTerrainType(TerrainType.PLAINS);
        tileSet[5][7].setTerrainType(TerrainType.PLAINS);
        tileSet[6][7].setTerrainType(TerrainType.PLAINS);
        tileSet[8][7].setTerrainType(TerrainType.PLAINS);
        tileSet[9][7].setTerrainType(TerrainType.PLAINS);
        tileSet[7][5].setTerrainType(TerrainType.PLAINS);
        tileSet[7][6].setTerrainType(TerrainType.PLAINS);
        tileSet[7][8].setTerrainType(TerrainType.PLAINS);
        tileSet[7][9].setTerrainType(TerrainType.PLAINS);

        //tileSet[16][10].setTerrainType(TerrainType.SWAMP);
        tileSet[12][6].setTerrainType(TerrainType.SWAMP);
        tileSet[14][8].setTerrainType(TerrainType.SWAMP);
        tileSet[12][8].setTerrainType(TerrainType.SWAMP);
        tileSet[14][6].setTerrainType(TerrainType.SWAMP);
        tileSet[11][7].setTerrainType(TerrainType.SWAMP);
        tileSet[12][7].setTerrainType(TerrainType.SWAMP);
        tileSet[14][7].setTerrainType(TerrainType.SWAMP);
        tileSet[15][7].setTerrainType(TerrainType.SWAMP);
        tileSet[13][5].setTerrainType(TerrainType.SWAMP);
        tileSet[13][6].setTerrainType(TerrainType.SWAMP);
        tileSet[13][8].setTerrainType(TerrainType.SWAMP);
        tileSet[13][9].setTerrainType(TerrainType.SWAMP);

        tileSet[16][4].setTerrainType(TerrainType.TUNDRA);
        tileSet[15][3].setTerrainType(TerrainType.TUNDRA);
        tileSet[17][5].setTerrainType(TerrainType.TUNDRA);
        tileSet[15][5].setTerrainType(TerrainType.TUNDRA);
        tileSet[17][3].setTerrainType(TerrainType.TUNDRA);
        tileSet[14][4].setTerrainType(TerrainType.TUNDRA);
        tileSet[15][4].setTerrainType(TerrainType.TUNDRA);
        tileSet[17][4].setTerrainType(TerrainType.TUNDRA);
        tileSet[18][4].setTerrainType(TerrainType.TUNDRA);
        tileSet[16][2].setTerrainType(TerrainType.TUNDRA);
        tileSet[16][3].setTerrainType(TerrainType.TUNDRA);
        tileSet[16][5].setTerrainType(TerrainType.TUNDRA);
        tileSet[16][6].setTerrainType(TerrainType.TUNDRA);

        tileSet[7][1].setTerrainType(TerrainType.DESERT);
        tileSet[7][2].setTerrainType(TerrainType.DESERT);
        tileSet[7][3].setTerrainType(TerrainType.DESERT);
        tileSet[6][2].setTerrainType(TerrainType.DESERT);
        tileSet[8][2].setTerrainType(TerrainType.DESERT);

        tileSet[13][1].setTerrainType(TerrainType.OCEAN);
        tileSet[13][2].setTerrainType(TerrainType.OCEAN);
        tileSet[13][3].setTerrainType(TerrainType.OCEAN);
        tileSet[12][2].setTerrainType(TerrainType.OCEAN);
        tileSet[14][2].setTerrainType(TerrainType.OCEAN);

        tileSet[19][1].setTerrainType(TerrainType.TUNDRA);
        tileSet[19][2].setTerrainType(TerrainType.TUNDRA);
        tileSet[19][3].setTerrainType(TerrainType.TUNDRA);
        tileSet[18][2].setTerrainType(TerrainType.TUNDRA);
        tileSet[20][2].setTerrainType(TerrainType.TUNDRA);

        tileSet[7][11].setTerrainType(TerrainType.JUNGLE);
        tileSet[7][12].setTerrainType(TerrainType.JUNGLE);
        tileSet[7][13].setTerrainType(TerrainType.JUNGLE);
        tileSet[6][12].setTerrainType(TerrainType.JUNGLE);
        tileSet[8][12].setTerrainType(TerrainType.JUNGLE);

        tileSet[19][5].setTerrainType(TerrainType.GLACIER);
        tileSet[19][6].setTerrainType(TerrainType.GLACIER);
        tileSet[19][7].setTerrainType(TerrainType.GLACIER);
        tileSet[18][6].setTerrainType(TerrainType.GLACIER);
        tileSet[20][6].setTerrainType(TerrainType.GLACIER);

        tileSet[17][7].setTerrainType(TerrainType.PLAINS);
        tileSet[17][8].setTerrainType(TerrainType.PLAINS);
        tileSet[17][9].setTerrainType(TerrainType.PLAINS);
        tileSet[16][8].setTerrainType(TerrainType.PLAINS);
        tileSet[18][8].setTerrainType(TerrainType.PLAINS);

        tileSet[15][9].setTerrainType(TerrainType.SWAMP);
        tileSet[15][10].setTerrainType(TerrainType.SWAMP);
        tileSet[15][11].setTerrainType(TerrainType.SWAMP);
        tileSet[14][10].setTerrainType(TerrainType.SWAMP);
        tileSet[16][10].setTerrainType(TerrainType.SWAMP);

        //Wrap Test
        tileSet[20][18].setTerrainType(TerrainType.GLACIER);
        tileSet[0][18].setTerrainType(TerrainType.GLACIER);

        //Wrap with edge Test
        tileSet[20][16].setTerrainType(TerrainType.GLACIER);
        tileSet[0][16].setTerrainType(TerrainType.GLACIER);


        tileSet[12][12].setTerrainType(TerrainType.MOUNTAINS);
        tileSet[13][12].setTerrainType(TerrainType.MOUNTAINS);
        tileSet[14][12].setTerrainType(TerrainType.MOUNTAINS);

        tileSet[17][12].setTerrainType(TerrainType.HILLS);
        tileSet[18][12].setTerrainType(TerrainType.HILLS);
        tileSet[19][12].setTerrainType(TerrainType.HILLS);

        tileSet[17][10].setTerrainType(TerrainType.FOREST);
        tileSet[18][10].setTerrainType(TerrainType.FOREST);
        tileSet[19][10].setTerrainType(TerrainType.FOREST);
        
        return new World(new Map(tileSet));
         
         */
    }

    public Object getCity(MapLocation mapLocation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
// yet to implement