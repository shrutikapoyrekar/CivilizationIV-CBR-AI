/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iu.civ.research;


import iu.edu.civ.unit.Unit;
import java.util.ArrayList;


class AdvancedMechNode extends TreeNode {

    public AdvancedMechNode(ArrayList <Unit> aU) {
        super(aU, "AdvMech");
        turnsToComplete = FIFTHLEVELTURNS;
    }

    @Override
    public void researchComplete() {
        this.setResearched(true);
        //availableUnits.add(Unit);
    }
    
    public String getInfo(){
        return ("<html>Unlocks: AWACS, CRUISE_MISSILE, STEALTH_BOMBER, <br>"
                + "STEALTH_FIGHTER, SUBMARINE, CARRIER, HELICOPTER, <br>"
                + "AEGIS_CRUISER, DESTROYER</html>");
    }

}
