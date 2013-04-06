/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iu.civ.research;

import iu.edu.civ.unit.Unit;
import java.util.ArrayList;


class NuclearNode extends TreeNode {

    public NuclearNode(ArrayList <Unit> aU) {
        super(aU, "Nuclear");
        turnsToComplete = SIXTHLEVELTURNS;
    }

    @Override
    public void researchComplete() {
        this.setResearched(true);
    }

    public String getInfo(){
        return ("Unlocks: ");
    }

}
