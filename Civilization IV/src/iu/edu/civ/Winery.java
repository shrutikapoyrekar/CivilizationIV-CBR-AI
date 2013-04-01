package iu.edu.civ;

import java.util.Map;

public class Winery extends Improvement {
	Winery(){
		super("Winery", 0, 0, 0, 10, "Monarchy");
	}
	@Override
	public boolean canBeBuilt(Terrain t) {
		if (t==null) return false;
		else if (t.getResource() != null && t.getResource().getName().equals("Wine")) return true;
		else return false;
	}

	@Override
	public int getCommerce(String resource) {
		if (resource == null) return this.commerce;
		else if (resource.equals("Wine")) return this.commerce+2;
		else return this.commerce;
	}

	@Override
	public int getCommerce(Map<String, Technology> t, String r) {
		return getCommerce(r);
	}

	@Override
	public int getFood(String resource) {
		if (resource==null) return this.food;
		else if (resource.equals("Wine")) return this.food+1;
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
