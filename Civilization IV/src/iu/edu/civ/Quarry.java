package iu.edu.civ;

import java.util.Map;

public class Quarry extends Improvement {
	Quarry(){
		super("Quarry", 0, 0, 0, 5, "Masonry");
	}
	
	@Override
	public boolean canBeBuilt(Terrain t) {
		if (t!=null && t.getResource()!= null && (t.getResource().getName().equals("Marble") || t.getResource().getName().equals("Stone"))) return true;
		else return false;
	}

	@Override
	public int getCommerce(String resource) {
		if (resource==null) {
			return this.commerce;
		}else if(resource.equals("Marble")){
			return this.commerce+2;
		}else return this.commerce;
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
		return this.food;
	}

	@Override
	public int getProduct(String resource) {
		if (resource == null) return this.product;
		else if (resource.equals("Marble")) return this.product+1;
		else if (resource.equals("Stone")) return this.product+2;
		else return this.product;
	}

	@Override
	public int getProduct(Map<String, Technology> t, String r) {
		return getProduct(r);
	}

}
