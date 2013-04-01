package iu.edu.civ;

import java.util.Map;

public class Watermill extends Improvement {
	Watermill(){
		super("Watermill", 0, 1, 0, 5, "Machinery");
	}
	
	@Override
	public boolean canBeBuilt(Terrain t) {
		if (t==null) return false;
		else if (t.getBaseTerrain() != null && (t.getBaseTerrain().getName().equals("Grassland") || t.getBaseTerrain().getName().equals("Plains"))) return true;
		else return false;
	}

	@Override
	public int getCommerce(String resource) {
		return this.commerce;
	}

	@Override
	public int getCommerce(Map<String, Technology> t, String r) {
		if (t==null) return getCommerce(r);
		else if (t.containsKey("Electricity")) return getCommerce(r)+2;
		else return getCommerce(r);
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
		if (t==null) return getProduct(r);
		else if (t.containsKey("ReplaceableParts")) return getProduct(r)+1;
		else return getProduct(r);
	}

}
