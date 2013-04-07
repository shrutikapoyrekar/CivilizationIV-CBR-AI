/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iu.civ.research;


import iu.edu.civ.unit.Unit;
import java.util.ArrayList;


class ArtOfWarNode extends TreeNode {

    public ArtOfWarNode(ArrayList <Unit> aU) {
        super(aU, "ArtOfWar");
        turnsToComplete = THIRDLEVELTURNS;
    }
    @Override
    public void researchComplete() {
        this.setResearched(true);
        
    }

    public String getInfo(){
        return ("<html>Unlocks: CANNON, MUSKETEER, <br>"
                + "RIFLEMAN, DRAGOON, ENGINEER</html>");
    }

}
