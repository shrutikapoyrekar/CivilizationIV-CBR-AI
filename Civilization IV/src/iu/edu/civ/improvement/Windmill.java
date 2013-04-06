package iu.edu.civ.improvement;

import iu.edu.civ.Technology;
import iu.edu.civ.Terrain;

import java.util.Map;

public class Windmill extends Improvement {

	Windmill(){
		super("Windmill", 1, 0, 1, 5, "Machinery");
	}
	@Override
	public boolean canBeBuilt(Terrain t) {
		if (t==null) return false;
		else if (t.getBaseTerrain().isHill()) return true;
		else return false;
	}

	@Override
	public int getCommerce(String resource) {
		return this.commerce;
	}

	@Override
	public int getCommerce(Map<String, Technology> t, String r) {
		if (t==null) return getCommerce(r);
		else if (t.containsKey("Electricity")) return getCommerce(r)+1;
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
