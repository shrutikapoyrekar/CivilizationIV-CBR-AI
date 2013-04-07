/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iu.civ.research;


import iu.edu.civ.unit.Unit;
import java.util.ArrayList;


class SeafaringNode extends TreeNode {

    public SeafaringNode(ArrayList <Unit> aU) {
        super(aU, "Seafaring");
        turnsToComplete = FIRSTLEVELTURNS;
    }

    @Override
    public void researchComplete() {
        this.setResearched(true);
    }

    public String getInfo(){
        return ("<html>Unlocks: CARAVEL, TRIREME, <br>"
                + "FRIGATE, GALLEON</html>");
    }

}
