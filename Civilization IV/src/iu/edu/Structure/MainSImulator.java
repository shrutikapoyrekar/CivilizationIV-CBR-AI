/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.edu.Structure;

/**
 *
 * @author Shrutika
 */
public interface MainSImulator 
{
    /*
     * Creates an Aging strategy for the game to use
     */
    public AgingStrategy createAgingStrategy();

    /*
     * Creates a Winner strategy for the game to use
     */
    public Winner createWinnerStrategy();

    
    /*
     * Creates an Attack strategy for the game to use
     */
    public AttackStrategy createAttackStrategy();

    /*
     * Creates an Unit Action strategy for the game to use
     */
    public UnitActionStrategy createUnitActionStrategy();
}
