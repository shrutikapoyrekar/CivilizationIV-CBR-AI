/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.edu.Structure;

/**
 *
 * @author Shrutika
 */
public interface GameObserver 
{
     public void worldChangedAt(Position pos);
    /** invoked every time some change occurs on a position
     * in the world - a unit disappears or appears, a
     * city appears, a city changes player color, or any
     * other event that will affect the CBR
     */
     
     public void turnEnds(Player nextPlayer, int age);
    /** invoked just after the game's end of turn is called
     * to signal the new "player in turn" and world age state.
     */

    
}
