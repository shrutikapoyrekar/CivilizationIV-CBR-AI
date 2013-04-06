package iu.edu.civ.improvement;

import iu.edu.civ.Technology;
import iu.edu.civ.Terrain;

import java.util.Map;

public class Mine extends Improvement {
	public Mine(){
		super("Mine", 0, 2, 0, 10, "Mining");
	}
	
	@Override
	public boolean canBeBuilt(Terrain t) {
		if (t==null) return false;
		else if (t.getBaseTerrain().isHill()) return true;
		else return false;
	}

	@Override
	public int getCommerce(String resource) {
		if (resource == null) return commerce;
		else if (resource.equals("Gold")) return commerce+6;
		else return commerce;
	}

	@Override
	public int getCommerce(Map<String, Technology> t, String r) {
		return getCommerce(r);
	}

	@Override
	public int getFood(String resource) {
		return food;
	}

	@Override
	public int getFood(Map<String, Technology> t, String r) {
		return food;
	}

	@Override
	public int getProduct(String resource) {
		if (resource==null) return product;
		else if (resource.equals("Copper") || resource.equals("Iron")) return product+3;
		else if (resource.equals("Gold")) return product+1;
		else return product;
	}	

	@Override
	public int getProduct(Map<String, Technology> t, String r) {
		if (t==null) return getProduct(r);
		else if(t.get("Railroad")!=null) return getProduct(r)+1;
		else return getProduct(r);
	}

}
