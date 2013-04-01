package iu.edu.civ;

import java.util.Map;

public class Workshop extends Improvement {
	Workshop(){
		super("Workshop", -1, 1, 0, 5, "MetalCasting");
	}
	
	@Override
	public boolean canBeBuilt(Terrain t) {
		if (t==null) return false;
		else if (t.getBaseTerrain() !=null && (t.getBaseTerrain().getName().equals("Grassland") || t.getBaseTerrain().getName().equals("Plains"))) return true;
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
		else{
			int p = getProduct(r);
			if (t.containsKey("Guild")) p++;
			if (t.containsKey("Chemistry")) p++;
			return p;
		}
	}

}
