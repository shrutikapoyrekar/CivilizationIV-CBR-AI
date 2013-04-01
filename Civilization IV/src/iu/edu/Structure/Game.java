/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.edu.Structure;

import iu.edu.civ.Unit;

/**
 *
 * @author Shrutika
 */
public interface Game 
{
    
    /*
     * Describing all the methods I will use as follows
     */
    
    
    public Tile getTileAt( Position p );
    /** return a specific tile.
     * It will return the time present at Position p
     */
    
    public Unit getUnitAt( Position p );
    /** Each position can have one or more Units 
     * so Over here I decided to return the upper most Unit in the given position
     * if no unit is present it will return null
     */
    
    public City getCityAt( Position p );
    /** will return the city at position p 
     * if no city will return null
     */
    
    public Player getPlayerInTurn();
    /** return the turn of player
     */
    
    public Player getWinner();
    /** return the winner
     * if no winner null
     */
    
    public int getAge();
    /** age of the world
     * negative = BC
     * positive = AD
     */
    

    // === Mutator methods ======================================
    public boolean moveUnit( Position from, Position to );
    /**use this method to move an unit from one tile to another
     * if its preoccupied by enemy then = war
     * lost unit shud be removed from the game
     * 
     * now if
     * if a successful move
     * results in the unit entering the position of a city then this
     * city becomes owned by the owner of the moving unit.
     * 
     * retrun true if move possible (i.e no mountains and all
     * else false
     */
    
    
    public void endOfTurn();
    /** tell player finished next shud play now
     * if all players finished in the round
     * then do end of round
     * restore all units move counts
     * produce food and production in all cities
     * produce units in all cities (if enough production)
     * increase population size in all cities (if enough food)
     *  increase the world age.
     */
    
    public void changeWorkForceFocusInCityAt( Position p, String balance );
    /** change the work force's focus in a city, i.e. what
     * kind of production there will be emphasis on in the city.
     *
     */
    
    public void changeProductionInCityAt( Position p, String unitType );
    /** change the type of unit a city will produce next. 
     * 
     */
    
    
    public void performUnitActionAt( Position p );
    /** perform the action associated with the unit at position p.
     * 
     */
    
     

}
