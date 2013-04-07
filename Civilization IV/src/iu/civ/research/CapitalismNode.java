/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iu.civ.research;

import iu.edu.civ.unit.Unit;
import java.util.ArrayList;

/**
 * 100% increase in gold production
 * @author Justin
 */
class CapitalismNode extends TreeNode {

    public CapitalismNode(ArrayList <Unit> aU) {
        super(aU, "Capitalism");
        turnsToComplete = FIFTHLEVELTURNS;
    }

    @Override
    public void researchComplete() {
        this.setResearched(true);
    }

    public String getInfo(){
        return ("Unlocks: FANATIC, SPY");
    }

}
