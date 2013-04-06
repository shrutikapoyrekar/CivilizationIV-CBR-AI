/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iu.civ.research;

import iu.edu.civ.unit.Unit;


import java.util.ArrayList;


class ModernWarefareNode extends TreeNode {

    public ModernWarefareNode(ArrayList <Unit> aU) {
        super(aU, "ModernWarefare");
        turnsToComplete = FOURTHLEVELTURNS;
    }

    @Override
    public void researchComplete() {
        this.setResearched(true);
    }

    public String getInfo(){
        return ("Unlocks: ");
    }

}
