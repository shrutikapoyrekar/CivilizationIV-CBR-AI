package iu.edu.civ.improvement;

import iu.edu.civ.Technology;
import iu.edu.civ.Terrain;

import java.util.Map;

public class Pasture extends Improvement {
	Pasture(){
		super("Pasture", 0, 0, 0, 5, "AnimalHusbandary");
	}
	@Override
	public boolean canBeBuilt(Terrain t) {
		if (t==null) return false;
		else if (t.getResource()!=null &&(t.getResource().getName().equals("Hourse") || t.getResource().getName().equals("Sheep"))) return true;
		else return false;
	}

	@Override
	public int getCommerce(String resource) {
		if (resource == null) return this.commerce;
		else if (resource.equals("Hourse")) return this.commerce + 1;
		else if (resource.equals("Sheep")) return this.commerce + 1;
		else return this.commerce;
	}

	@Override
	public int getCommerce(Map<String, Technology> t, String r) {
		return getCommerce(r);
	}

	@Override
	public int getFood(String resource) {
		if (resource == null) return this.food;
		else if (resource.equals("Sheep")) return this.food +2;
		else return this.food;
	}

	@Override
	public int getFood(Map<String, Technology> t, String r) {
		return getFood(r);
	}

	@Override
	public int getProduct(String resource) {
		if (resource == null) return this.product;
		else if (resource.equals("Hourse")) return this.product + 2;
		else return this.product;
	}

	@Override
	public int getProduct(Map<String, Technology> t, String r) {
		return getProduct(r);
	}

}
