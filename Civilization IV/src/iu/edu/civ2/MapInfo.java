/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.edu.civ2;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author scaa890809
 */
public class MapInfo
{

    /**
     * Name of the map.
     */
    public String name;
    /**
     * Description of the map.
     */
    public String description;
    /**
     * The maximum number of players that the map allows
     */
    public int numberOfPlayers;
    /**
     * An 'minimap' preview of the map
     */
    public BufferedImage preview;
    /**
     * The filename the map is contained in.
     */
    public String fileName;
    /**
     * The complete filename including path in which the map is contained.
     */
    public String completeFileName;
    /**
     * A string representing the size of the map, ex 35x49 is a map
     * that is 35 wide and 49 tall.
     */
    public String size;

    public ArrayList<MapLocation> spawnLocations;

    /**
     * Empty Constructor
     */
    public MapInfo()
    {
        this.spawnLocations = new ArrayList<MapLocation>();
    }

    /**
     * Parameterized Constructor
     * @param name Name of the map
     * @param Description Description of the map
     * @param numPlayers Maximum number of players
     * @param file Filename (including path) of the map.
     */
    public MapInfo(String name, String Description, int numPlayers, String file)
    {
        this.name = name;
        this.description = Description;
        this.numberOfPlayers = numPlayers;

        this.fileName = file;
    }

    /**
     * Returns the name of the Map
     * @return name of the map.
     */
    public String toString() {
        return name;
    }

}

