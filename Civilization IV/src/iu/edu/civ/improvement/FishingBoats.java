package iu.edu.civ.improvement;

import iu.edu.civ.Technology;
import iu.edu.civ.Terrain;

import java.util.Map;

public class FishingBoats extends Improvement {
	FishingBoats(){
		super("FishingBoats", 0, 0, 0, 5, "Fishing");
	}
	@Override
	public boolean canBeBuilt(Terrain t) {
		if (t==null) return false;
		else if (t.getResource()!=null && t.getResource().getName().equals("Fish")) return true;
		else return false;
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
		if (resource==null) return this.food;
		else if (resource.equals("Fish")) return this.food +3;
		else return this.food;
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
