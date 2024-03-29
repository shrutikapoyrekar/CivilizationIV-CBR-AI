/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.civ.research;


import iu.edu.civ.unit.Unit;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * TreeNode abstract that every research TreeNode will implement. Contains the
 * completed() method, the isAvailable()  
 * @author Justin
 */
public abstract class TreeNode implements Serializable {
    public static final int FIRSTLEVELTURNS = 50;
    public static final int SECONDLEVELTURNS = 250;
    public static final int THIRDLEVELTURNS = 750;
    public static final int FOURTHLEVELTURNS = 1600;
    public static final int FIFTHLEVELTURNS = 3000;
    public static final int SIXTHLEVELTURNS = 5150;
    
    private boolean isResearched = false;
    public ArrayList<TreeNode> children;
    protected ArrayList<Unit> availableUnits;
    protected String name;
    
    public int turnsToComplete;
    
    public TreeNode(ArrayList <Unit> aU, String nm) {
        children = new ArrayList<TreeNode>();
        availableUnits = aU;
        name = nm;
    }
    
    public TreeNode() {
        children = new ArrayList<TreeNode>();
    }
    
    public abstract void researchComplete();
    
    @Override
    public String toString() {
        return name;
    }

    public abstract String getInfo();
        
    //Checks if the children are researched or not.
    public boolean isAvailable() {
        if (children.isEmpty()) {
            return true;
        }
        
        for (TreeNode child : children) {
            if (!child.isResearched()) {
                return false;
            }
        }
        return true;
    }  
    
    public ArrayList<TreeNode> getChildren() {
        return children;
    }
    
    public boolean isResearched() {
        return isResearched;
    }
    
    public void setResearched(boolean b) {
        isResearched = b;
    }    
    
    public void addChild(TreeNode e) {
        children.add(e);
    }
    
    public void addChildren(TreeNode ... params) {
        for (TreeNode e : params) {
            addChild(e);
        }
    }
}
