/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iu.civ.research;

import iu.edu.civ.unit.Unit;
import java.util.ArrayList;


class HonourNode extends TreeNode {

    public HonourNode(ArrayList <Unit> aU) {
        super(aU, "Honour");
        turnsToComplete = SECONDLEVELTURNS;
    }

    @Override
    public void researchComplete() {
        this.setResearched(true);
    }

    public String getInfo(){
        return ("Unlocks: CRUSADERS, KNIGHT, CAVALRY");
    }

}
