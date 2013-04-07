package iu.edu.civ.improvement;

import iu.edu.civ.Technology;
import iu.edu.civ.Terrain;

import java.util.Map;

public class Village extends Improvement {
	private int turn=0;
	Village(){
		super("Village", 0, 0, 3, 20, "");
	}
	@Override
	public boolean canBeBuilt(Terrain t) {
		return false;
	}

	@Override
	public int getCommerce(String resource) {
		return this.commerce;
	}

	@Override
	public int getCommerce(Map<String, Technology> t, String r) {
		if (t==null) return getCommerce(r);
		else if (t.containsKey("PrintingPress")) return getCommerce(r)+1;
		return getCommerce(r);
	}

	@Override
	public int getFood(String resource) {
		return this.food;
	}

	@Override
	public int getFood(Map<String, Technology> t, String r) {
		return getFood(r);
	}

	@Override
	public int getProduct(String resource) {
		return this.product;
	}

	@Override
	public int getProduct(Map<String, Technology> t, String r) {
		return getProduct(r);
	}
	
	public Improvement nextTurn(){
		if (turn < 40){
			turn++;
			return this;
		}
		return new Town();
	}
}
