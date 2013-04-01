package iu.edu.civ;

import java.util.Map;

public class Cottage extends Improvement {
	private int turn = 0;
	Cottage(){
		super("Cottage", 0, 0, 1, 10, "Pottery");
	}
	@Override
	public boolean canBeBuilt(Terrain t) {
		if (t==null) return false;
		if (t.getBaseTerrain() !=null && t.getBaseTerrain().isHill()) return false;
		return true;
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
		return getProduct(r);
	}

	public Improvement nextTurn(){
		if (turn<=10){
			turn++;
			return this;
		}
		return new Hamlet();
	}
}
