/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.edu.civ2;

//import iu.edu.enums.TerrainBonusType;
import iu.edu.civ.BaseTerrain;
import iu.edu.civ.Terrain;
import iu.edu.civ.TerrainFeature;
//import iu.edu.civ.Resource;
//import iu.edu.enums.TerrainType;
import java.io.Serializable;

/**
 *
 * @author Shrutika Poyrekar
 */


public class Tile implements Serializable
{
    //private BaseTerrain terrainType;
    private MapLocation mapLocation;
    private Terrain terrain; // Need to make changes ????
    //private TerrainBonusType bonusType;
    private boolean hasRoad;
    private boolean hasMine;
    private boolean hasIrrigation;
    private boolean riverFlow;

    public Tile(int x, int y, Terrain terrain , boolean road, boolean mine, boolean irrig, boolean rivflow)
    {
        this.mapLocation = new MapLocation(x,y);
        this.terrain = terrain;
       
        this.hasRoad = road;
        this.hasMine = mine;
        this.hasIrrigation = irrig;
        this.riverFlow = rivflow;
    }

    

    public boolean isRoadBuilt() {
        return hasRoad;
    }
    
    public boolean isMineBuilt() {
        return hasMine;
    }
    
    public boolean isIrrigationBuilt() {
        return hasIrrigation;
    }
    
    public String getTerrainFeature() 
    {
        return terrain.getTerrainFeature().getName();
    }

    public void setTerrainFeature (TerrainFeature tfeature) {
        this.terrain.setTerrainFeature(tfeature);
    }

    public MapLocation getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(MapLocation mapLocation) {
        this.mapLocation = mapLocation;
    }

    public void setBaseTerrainType(BaseTerrain type) {
        this.terrain.setBaseTerrain(type);
    }
    
    public String getBaseTerrainType() 
    {
        return terrain.getBaseTerrain().getName();
    }

    public void setRiver(boolean riv)
    {
        this.riverFlow = riv;
    }

    public boolean riverPresent()
    {
        return this.riverFlow;
    }
}

