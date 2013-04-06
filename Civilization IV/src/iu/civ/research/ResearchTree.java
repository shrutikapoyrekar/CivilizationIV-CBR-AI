/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iu.civ.research;

import iu.edu.civ.unit.Unit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 * The ResearchTree is the tech path of the player. A research tree contains
 * TreeNodes, each of which is a unique class. A Node cannot be completed unless
 * its children are already completed, denoted by some boolean flag isResearched.
 * 
 * When a TreeNode is completed, a method complete() is called from the TreeNode.
 * The Player's available units that he can build changes depending on what was
 * researched. Available units can be represented by a String list that we give
 * to the UI possibly.
 * 
 * @author Justin
 */
public class ResearchTree implements Serializable {
    private static final double RESEARCHCONSTANT = 1;
    private static final int RESEARCH_NODE_WIDTH = 150;
    private static final int RESEARCH_NODE_HEIGHT = 50;
    private static final boolean DEBUG = false;

    public TreeNode root;
    public ArrayList<TreeNode> bfsQueue;
    public ArrayList <Unit> availableUnits = new ArrayList();
    private boolean unlocked = false;
    
    public TreeNode active;
    
    public ResearchTree() {
        init();
        bfsQueueCreation();
        testQueue();
    }

    private void init() {
        //Initialize all the nodes
        root = new RootNode();
        TreeNode nuclear = new NuclearNode(availableUnits);
        TreeNode capitalism = new CapitalismNode(availableUnits);
        TreeNode advancedMech = new AdvancedMechNode(availableUnits); 
        TreeNode modernWarefare = new ModernWarefareNode(availableUnits);        
        TreeNode politics = new PoliticsNode(availableUnits);        
        TreeNode artOfWar = new ArtOfWarNode(availableUnits);
        TreeNode flight = new FlightNode(availableUnits);        
        TreeNode honour = new HonourNode(availableUnits);                 
        TreeNode ironWorks = new IronWorksNode(availableUnits);
        TreeNode warriorCode = new WarriorCodeNode(availableUnits);
        TreeNode math = new MathNode(availableUnits);
        TreeNode seafaring = new SeafaringNode(availableUnits);               
        
        //Add children to proper nodes
        root.addChildren(nuclear, capitalism);
        nuclear.addChildren(politics, advancedMech);
        capitalism.addChild(politics);
        advancedMech.addChildren(modernWarefare, flight);
        modernWarefare.addChildren(artOfWar);
        politics.addChild(honour);
        artOfWar.addChildren(honour, ironWorks);
        flight.addChildren(ironWorks, seafaring);
        honour.addChild(warriorCode);
        ironWorks.addChildren(warriorCode, math);
        
        
        // Set defaut research
        active = warriorCode;
        
        // Add default starting units to available unit list
        //settlers warriors etc
    }
    
    public void nextTurn(int science, String name) {
        active.turnsToComplete -= ((science + 1) * RESEARCHCONSTANT);
        if(active.turnsToComplete <= 0) {
            if (!active.isResearched()) {
                JOptionPane.showMessageDialog(null, name + "'s research has completed! Please pick a new research item from the research tree menu.");
                active.researchComplete();            
            }
        }
        if (DEBUG) {
            System.out.println(name + " : " + active.turnsToComplete + " : " + ((science + 1)* RESEARCHCONSTANT));
        }
    }

    /**
     * Creates a breadth first search queue of the research tree for searching
     * purposes, since searching via the root is difficult when there are two
     * top level nodes. Nodes without edges will not be added.
    */
    private void bfsQueueCreation() {
        bfsQueue = new ArrayList<TreeNode>();
        ArrayList<TreeNode> currentLevel = new ArrayList<TreeNode>();
        HashMap<TreeNode, TreeNode> blacklist = new HashMap<TreeNode, TreeNode>();
        
        ArrayList<TreeNode> currentChildren = new ArrayList(root.getChildren());
        
        do {
            currentLevel.clear();
            for (TreeNode child : currentChildren) {
                if (blacklist.get(child) == null) {
                    blacklist.put(child, child);
                    for (TreeNode kid : child.getChildren()) {
                        currentLevel.add(kid);
                    }
                    bfsQueue.add(child);
                }
            }
            currentChildren.clear();
            for (TreeNode child : currentLevel) {
                currentChildren.add(child);
            }
        } while (!currentLevel.isEmpty());
        // Continue adding to the queue until there are no more children that
        // are not in our blacklist
    }
    
    //Quick test to see the output of the bfsQueue
    public void testQueue() {
        if (DEBUG) {
            for (TreeNode e : bfsQueue) {
                System.out.println(e.toString());
            }
        }
    }
    
    public Object[] getAvailableUnits() {       
        return availableUnits.toArray();
    }
    
    public void unlockUnits() {
        if (unlocked) return;
        //add unlocked
        unlocked = true;
    }
    
    public String getActiveResearch() {
        if (active.isResearched()) {
            return "NONE";
        } else {
            return active.toString();
        }
    }
}


