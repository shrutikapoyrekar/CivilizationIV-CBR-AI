package iu.edu.civ;

import java.util.Map;

public class Hamlet extends Improvement {
	private int turn = 0;
	Hamlet(){
		super("Hamlet", 0, 0, 2, 15, "");
	}
	@Override
	public boolean canBeBuilt(Terrain t) {
		return false;
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
		if (turn<=20){
			turn++;
			return this;
		}
		return new Village();
	}
}
