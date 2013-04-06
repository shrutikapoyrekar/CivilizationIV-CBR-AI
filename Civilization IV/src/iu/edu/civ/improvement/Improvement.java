package iu.edu.civ.improvement;

import iu.edu.civ.Technology;
import iu.edu.civ.Terrain;

import java.util.Map;

public abstract class Improvement {
	String name;
	int food, product, commerce;
	int pillage;
	String requirement;
	double defenseBonus;
	
	public Improvement(){}
	public Improvement(String n, int f, int p, int c,int pi, String r){
		name = n;
		food = f;
		product = p;
		commerce = c;
		pillage = pi;
		requirement = r;
		defenseBonus = 0;
	}
	public Improvement(String n, int f, int p, int c,int pi, String r,double d){
		name = n;
		food = f;
		product = p;
		commerce = c;
		pillage = pi;
		requirement = r;
		defenseBonus = d;
	}
	
	public String getName(){return name;}
	
	public int getFood(){
		return food;
	}
	public abstract int getFood(String resource);
	public abstract int getFood(Map<String,Technology> t, String r);
	
	public int getProduct(){
		return product;
	}
	public abstract int getProduct(String resource);
	public abstract int getProduct(Map<String,Technology> t, String r);
	
	public Improvement nextTurn(){return this;}
	
	public int getCommerce(){
		return commerce;
	}
	public abstract int getCommerce(String resource);
	public abstract int getCommerce(Map<String,Technology> t, String r);
	
	public int getPillage(){
		return pillage;
	}
	public abstract boolean canBeBuilt(Terrain t);
	public String getRequirement(){
		return requirement;
	}
}
