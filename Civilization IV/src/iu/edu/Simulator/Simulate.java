/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.edu.Simulator;

import iu.edu.civ.unit.*;
import iu.edu.civ.unit.Unit;
import iu.edu.civ2.Player;

/**
 *
 * @author Shrutika
 */
public class Simulate {
    public static void main(String[] args) 
    {
		Player one = new Player();
                Unit u = new Axeman();
                one.addUnit((Axeman) u);
                System.out.println(one.getUnitCreateQueue().get(0).getName());
                
	}
}
