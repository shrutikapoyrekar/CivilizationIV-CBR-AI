package iu.edu.civ;

import java.util.Map;

public class Fort extends Improvement {
	Fort(){
		super("Fort", 0, 0, 0, 0, "Mathimatics",0.25);
	}

	@Override
	public boolean canBeBuilt(Terrain t) {
		if (t==null) return false;
		else return true;
	}

	@Override
	public int getCommerce(String resource) {
		return this.commerce;
	}

	@Override
	public int getCommerce(Map<String, Technology> t, String r) {
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

}
