package iu.edu.civ.improvement;

import iu.edu.civ.Technology;
import iu.edu.civ.Terrain;

import java.util.Map;

public class Plantation extends Improvement {
	Plantation(){
		super("Plantation", 0, 0, 0, 8, "Calendar");
	}

	@Override
	public boolean canBeBuilt(Terrain t) {
		if (t==null) return false;
		else if (t.equals("Dye") || t.equals("Incense")) return true;
		else return false;
	}

	@Override
	public int getCommerce(String resource) {
		if (resource == null) return this.commerce;
		else if (resource.equals("Dye")) return this.commerce +4;
		else if (resource.equals("Incense")) return this.commerce +5;
		else return this.commerce;
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
