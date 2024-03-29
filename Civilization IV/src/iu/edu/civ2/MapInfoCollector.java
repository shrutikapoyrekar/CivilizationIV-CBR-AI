/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.edu.civ2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author scaa890809
 */
public class MapInfoCollector
{
    /**
     * Looks at the maps that are currently available and returns an <code>
     * ArrayList</code> of <code>MapInfo</code>s containing information about the map.
     * @return An <code>ArrayList</code> containing information about each map.
     */
    public static ArrayList<MapInfo> getMapInfos()
    {
        ArrayList<MapInfo> result = new ArrayList<MapInfo>();
        File mapsDirectory = new File("resources/maps");
        String[] files = mapsDirectory.list();
        
        for(String i : files)
        {
            if (i.endsWith(".map"))
            {
                //System.out.println(mapsDirectory.getPath() + "/" + i);
                MapInfo info = getMapInfoFromFile(mapsDirectory.getPath() + "/" + i);
                if(info != null) result.add(info);
            }
        }
        return result;
    }

    public static ArrayList<MapLocation> getSpawnLocations(String fileName)
    {
        return getMapInfoFromFile(fileName).spawnLocations;
    }

    private static MapInfo getMapInfoFromFile(String fileName)
    {
        MapInfo result = new MapInfo();
        try
        {
            BufferedReader mapFileReader = new BufferedReader(new FileReader(new File(fileName)));
            //We need to find: Name, Description, Size (w and h), Number of players
            String line = mapFileReader.readLine();
            while(line != null)
            {
                String[] values = line.split("=");
                if(values.length > 1)
                {
                    if(values[0].equals("name")) result.name = values[1];
                    else if(values[0].equals("description")) result.description = values[1];
                    else if(values[0].equals("width")) result.size = values[1] + "x" + (result.size!=null?result.size:"");
                    else if(values[0].equals("height")) result.size += values[1];
                }
                line = mapFileReader.readLine();
                if(line.startsWith("r0")) break;
            }

            while(!line.startsWith("t001") && line.startsWith("r"))
            {
                String[] values = line.split("=");
                int x=Integer.parseInt(values[1]);
                line = mapFileReader.readLine();
                values = line.split("=");
                int y = Integer.parseInt(values[1]);
                result.spawnLocations.add(new MapLocation(x,y));
                line = mapFileReader.readLine();
            }
            result.numberOfPlayers=result.spawnLocations.size();
            result.fileName = fileName.substring(fileName.lastIndexOf("/")+1);
            result.completeFileName = fileName;
            mapFileReader.close();
            return result;
        }
        catch (IOException e)
        {
            return null;
        }
        catch (Exception f)
        {
            return null;
        }
    }
}

