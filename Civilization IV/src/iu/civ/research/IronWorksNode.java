/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iu.civ.research;

import iu.edu.civ.unit.Unit;
import java.util.ArrayList;


class IronWorksNode extends TreeNode {

    public IronWorksNode(ArrayList <Unit> aU) {
        super(aU, "IronWorks");
        turnsToComplete = SECONDLEVELTURNS;
    }

    @Override
    public void researchComplete() {
        this.setResearched(true);
    }

    public String getInfo(){
        return ("<html>Unlocks: CATAPULT, LEGION, PHALANX, <br>"
                + "PIKEMAN CHARIOT, IRONCLAD</html>");
    }

}
