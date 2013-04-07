/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.edu.civ2;

import iu.civ.research.ResearchTree;
import iu.edu.civ.unit.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Shrutika Poyrekar
 */
public class Player implements Serializable 
{
    private int id;
    private String name;
    private int gold;
    private int science;
    private MapLocation capitalLocation;
    private MapLocation location;
    private ArrayList<Unit> unitCreateQueue;
    // We need this for combat to avoid the ConcurrentModificationException
    private ArrayList<Unit> unitRemoveQueue;
    public boolean unlocked = false;
    private Random random;
    private ArrayList<Unit> units;
    private ResearchTree researchtree;

    public Player() 
    {
        units = new ArrayList<Unit>();
        unitCreateQueue = new ArrayList<Unit>();
        unitRemoveQueue = new ArrayList<Unit>();
        random = new Random();
    }
     
    public int getGold() {
        return gold;
    }

    
    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void setUnits(ArrayList<Unit> units) 
    {        
        this.units = units;
    }

    public void addCity(City city) {
        cities.add(city);
    }
    
   
    public ArrayList<Unit> getUnitCreateQueue() 
    {
        return unitCreateQueue;
    }
    
    
    public void setCurrentViewCenter(MapLocation location){
        this.location = location;
    }
    public MapLocation getCurrentViewCenter(){
        return location;
    }
    
    public void collectGold(int gold) {
        this.gold += gold;
    }

    public void collectScience(int science) {
        this.science += science;
    }

    public void resetScience() {
        this.science = 0;
    }
    
    public int getScience() {
        return this.science;
    }
    
    
    /*
     * Over here I am adding all the Units which the owner can own
     * the list of all units the player owns will be in unitCreateQueue which is a string
     */
    
     public void addUnit(HourseArcher hs)
    {
        Unit a = hs;
        a = new HourseArcher();
        unitCreateQueue.add(a);
    }
    
    public void addUnit(Chariot hs)
    {
        Unit a = hs;
        a = new Chariot();
        unitCreateQueue.add(a);
    }
    
    public void addUnit(Archer hs)
    {
        Unit a = hs;
        a = new Archer();
        unitCreateQueue.add(a);
    }
    
    
     public void addUnit(Axeman hs)
    {
        Unit a = hs;
        a = new Axeman();
        unitCreateQueue.add(a);
    }
    
    
     public void addUnit(Cannon hs)
    {
        Unit a = hs;
        a = new Cannon();
        unitCreateQueue.add(a);
    }
    
    
     public void addUnit(Catapult hs)
    {
        Unit a = hs;
        a = new Catapult();
        unitCreateQueue.add(a);
    }
    
    
     public void addUnit(Knight hs)
    {
        Unit a = hs;
        a = new Knight();
        unitCreateQueue.add(a);
    }
    
    
     public void addUnit(Longbowman hs)
    {
        Unit a = hs;
        a = new Longbowman();
        unitCreateQueue.add(a);
    }
    
    
     public void addUnit(Maceman hs)
    {
        Unit a = hs;
        a = new Maceman();
        unitCreateQueue.add(a);
    }
    
    
     public void addUnit(Pikeman hs)
    {
        Unit a = hs;
        a = new Pikeman();
        unitCreateQueue.add(a);
    }
    
    
     public void addUnit(Spearman hs)
    {
        Unit a = hs;
        a = new Spearman();
        unitCreateQueue.add(a);
    }
     
     
      public void addUnit(Warrior hs)
    {
        Unit a = hs;
        a = new Warrior();
        unitCreateQueue.add(a);
    }

    public void setCapitallocation(MapLocation mapLoc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addToRemoveQueue(MilitaryUnit attackingUnit) 
    {
        Unit unit = attackingUnit;
        unitRemoveQueue.add(unit);
    }

    public void removeUnit(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Unit> getRemoveQueue() {
        return unitRemoveQueue;
    }

    public ResearchTree getResearchTree() {
        return researchtree;
    }
    
}
