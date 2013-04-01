package iu.edu.civ;

import java.util.Map;

public class Town extends Improvement {
	Town(){
		super("Town", 0, 0, 4, 25, "");
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

}
