/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iu.civ.research;


import iu.edu.civ.unit.Unit;
import java.util.ArrayList;


class PoliticsNode extends TreeNode {

    public PoliticsNode(ArrayList <Unit> aU) {
        super(aU, "Politics");
        turnsToComplete = THIRDLEVELTURNS;
    }

    @Override
    public void researchComplete() {
        this.setResearched(true);
        
    }

    public String getInfo(){
        return ("Unlocks: DIPLOMAT, PARTISAN, FREIGHT, TRANSPORT");
    }

}
