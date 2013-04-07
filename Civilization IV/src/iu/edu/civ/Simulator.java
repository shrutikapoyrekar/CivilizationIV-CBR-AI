package iu.edu.civ;

import iu.edu.civ.unit.Longbowman;
import iu.edu.civ.unit.Unit;

public class Simulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Unit u = new Longbowman();
		System.out.println(u.getCost());
	}

}
