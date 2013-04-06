package iu.edu.civ.improvement;

import iu.edu.civ.Technology;
import iu.edu.civ.Terrain;

import java.util.Map;

public class Camp extends Improvement {
	Camp(){
		super("Camp", 0, 0, 0, 5, "Hunting");
	}
	
	@Override
	public boolean canBeBuilt(Terrain t) {
		if (t==null) return false;
		else if (t.getResource() != null && (t.getResource().getName().equals("Fur") || t.getResource().getName().equals("Ivory"))) return true;
		return false;
	}

	@Override
	public int getCommerce(String resource) {
		if (resource==null) return this.commerce;
		else if (resource.equals("Fur")) return this.commerce+3;
		else if (resource.equals("Ivory")) return this.commerce+1;
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
		if (resource==null) return this.product;
		else if (resource.equals("Ivory")) return this.product+1;
		else return this.product;
	}

	@Override
	public int getProduct(Map<String, Technology> t, String r) {
		return getProduct(r);
	}

}
