/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iu.civ.research;

import iu.edu.civ.unit.Unit;
import java.util.ArrayList;


class WarriorCodeNode extends TreeNode {

    public WarriorCodeNode(ArrayList <Unit> aU) {
        super(aU, "WarriorCode");
        turnsToComplete = FIRSTLEVELTURNS;
    }

    @Override
    public void researchComplete() {
        this.setResearched(true);
        

    }

    public String getInfo(){
        return ("Unlocks: ARCHERS, ELEPHANT, HORSEMAN");
    }

}
