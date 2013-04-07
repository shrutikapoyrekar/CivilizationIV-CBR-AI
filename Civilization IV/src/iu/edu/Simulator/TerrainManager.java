/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.edu.Simulator;

import iu.edu.civ.*;
import iu.edu.civ2.*;
import java.io.*;
import java.util.EnumMap;
import java.util.logging.Logger;

/**
 *
 * @author scaa890809
 */
public class TerrainManager implements Serializable {
    //private EnumMap<TerrainType, TerrainInfo> terrainInfoMap;
    //private EnumMap<TerrainBonusType, TerrainBonusInfo> bonusInfoMap;
    private Terrain terrain;
    private World world;
    
    transient BufferedReader reader;
    
    public TerrainManager(World world) 
    {
        
        this.world = world;
        loadTerrainInfo();
        loadBonusInfo();
    }

    public Terrain getTerrainInfo(MapLocation mapLocation) 
    {
        Tile tile = world.getTile(mapLocation);
        return gatherInfo(tile);
    }

    

    private Terrain gatherInfo(Tile t)
    {
        return null;
        
    }

    private void loadTerrainInfo() 
    {
        
    }
    
    
    private void loadBonusInfo()
    {
        
    }

    
    
}

