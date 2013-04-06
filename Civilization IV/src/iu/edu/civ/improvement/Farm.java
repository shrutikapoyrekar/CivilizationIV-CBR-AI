package iu.edu.civ.improvement;

import iu.edu.civ.Technology;
import iu.edu.civ.Terrain;

import java.util.Map;

public class Farm extends Improvement {
	public Farm(){
		super("Farm",1,0,0,5,"Agriculture");
	}
	
	@Override
	public int getCommerce(String resource) {
		return commerce;
	}

	@Override
	public int getCommerce(Map<String, Technology> t, String r) {
		return commerce;
	}

	@Override
	public int getFood(String r) {
		if (r == null)
			return food;
		else if (r.equals("Corn")){
			return food+2;
		}else if(r.equals("Rice")){
			return food+1;
		}else
			return food;
	}

	@Override
	public int getFood(Map<String, Technology> t, String r) {
		if (t==null) return getFood(r);
		else if(t.get("Biology")!=null) return getFood(r)+1;
		else return getFood(r);
	}

	@Override
	public int getProduct(String resource) {
		return product;
	}

	@Override
	public int getProduct(Map<String, Technology> t, String r) {
		return product;
	}

	@Override
	public boolean canBeBuilt(Terrain t) {
		if (t == null) return false;
		else if (t.getBaseTerrain().getName().equals("Grassland") || t.getBaseTerrain().getName().equals("Plains")){
			return true;
		}else return false;
	}

}
