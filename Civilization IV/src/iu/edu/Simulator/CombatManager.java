/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.edu.Simulator;

import iu.edu.civ.unit.*;
import iu.edu.civ2.MapLocation;
import iu.edu.civ2.World;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Shrutika
 */


public class CombatManager { 
    
    private static final boolean DEBUG = false;
    
    private World world;
    private Random randomGenerator;    
    private static final int COMBATCONSTANT = 8;
    private TerrainManager terrainManager;
    
    
    public CombatManager(World world, TerrainManager terrainManager){
        this.world = world;
        this.terrainManager = terrainManager;
        randomGenerator = new Random();
    }
    
    public void collision(MilitaryUnit attackingUnit, MapLocation enemyUnitLocation) {
        MilitaryUnit defendingUnit = (MilitaryUnit) getPrimaryDefender(world.getUnitList(enemyUnitLocation));
        int auRandomNumber, duRandomNumber;
        float defensiveModifier;
        
        
        if (attackingUnit.getDefenseBonus() == 0 && defendingUnit.getDefenseBonus() == 0) {
            //TODO: What happens if a unit who can't attack hits a unit that can't defend? SCIENCE!
        }  else if (attackingUnit.getAttackBonus(attackingUnit) == 0) {
            attackingUnit.setHealth(0);
        } else if (defendingUnit.getDefenseBonus() == 0) {
            defendingUnit.setHealth(0);
        }
        
        //Each loop consists of one round, and all the rounds make up a battle to the death
        while (attackingUnit.getHealth() > 0 && defendingUnit.getHealth() > 0) {
            defensiveModifier = calculateModifier(defendingUnit);
            
            auRandomNumber = randomGenerator.nextInt((int)(attackingUnit.getAttackBonus(attackingUnit) * COMBATCONSTANT));
            duRandomNumber = randomGenerator.nextInt((int)(((defendingUnit.getDefenseBonus())) * defensiveModifier
                    * COMBATCONSTANT));
            
            //Ties go to the defender
            if (auRandomNumber > duRandomNumber) {
                defendingUnit.wasAttacked(attackingUnit.getBaseStrength());
            } else 
            {
                attackingUnit.wasAttacked(defendingUnit.getBaseStrength());
            }
            
            if (DEBUG) {
                int i = 0;
                System.out.println("Round " + i++);
                System.out.println("AU HEALTH: " + attackingUnit.getHealth() + " random#: " + auRandomNumber);
                System.out.println("DU HEALTH: " + defendingUnit.getHealth() + " random#: " + duRandomNumber);
            }
        }
        
        if (attackingUnit.getHealth() <= 0) {
//           removeUnit(attackingUnit);
            attackingUnit.getOwner().addToRemoveQueue(attackingUnit);
           attackingUnit = null;
        } else {
            removeDefendingUnits(defendingUnit);
        }
    } 
    
    /**
     * The primary defender from the defensive units. The primary defender is the
     * defender with the highest baseDefense, and is chosen as the hero to represent
     * the defending army.
     * @param defendingUnitList The list of defending units from which the primary defender
     *                          is chosen.
     * @return A Unit object that references the primary defender
     */
    private MilitaryUnit getPrimaryDefender(ArrayList<Unit> defendingUnitList) {
        MilitaryUnit primaryDefender = (MilitaryUnit) defendingUnitList.get(0);
        for (Unit unit : defendingUnitList) {
            MilitaryUnit a=(MilitaryUnit) unit;
            if (a.getDefenseBonus() > primaryDefender.getDefenseBonus()) {
                primaryDefender = a;
            }
        }
        return primaryDefender;
    }
    
    /**
     * Calculated the bonuses a defending unit acquires based on terrain and if
     * they are fortified
     * @param defendingUnit The defendingUnit that is getting the modifier bonuses
     * @return 
     */
    private float calculateModifier(MilitaryUnit defendingUnit) {
        return (float) terrainManager.getTerrainInfo(defendingUnit.getMapLocation()).getDefenseBonus();
    }

    /**
     * Removes a unit from the game. Removes it from the world, the owner, and
     * the city if possible.
     * @param unit The unit to be removed from the game.
     */
    private void removeUnit(Unit unit) {
        world.removeUnit(unit);
        unit.getOwner().removeUnit(unit);
        
        
    }
    
    /**
     * Removes the defending units on the tile if they were not on a city, and
     * only the defending unit that fought if they were on a city
     * @param defendingUnit The primary defending unit that lost the battle
     */
    private void removeDefendingUnits(Unit defendingUnit) {
        
        
        
        while(!world.getUnitList(defendingUnit.getMapLocation()).isEmpty()) {
            removeUnit(world.getUnitList(defendingUnit.getMapLocation()).get(0));
        }
    }
}
