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
public class MapLocation implements Serializable
{
    public int x;
    public int y;
    

    public MapLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public MapLocation (MapLocation mapLocation) 
    {
        this.x = mapLocation.x;
        this.y = mapLocation.y;
    }
    
    @Override
    public String toString() 
    {
        return this.x + ":" + this.y;
    }
    
    public boolean compare(MapLocation mapLocation) 
    {
        if (this.x == mapLocation.x && this.y == mapLocation.y)
            return true;
        
        return false;
    }
}
