package iu.edu.civ;

import java.util.List;
import java.util.Set;

//import iu.edu.civ2.MapLocation;

public abstract class Unit {
	//private MapLocation location;
	private String name;
	private double movement;
	private double health;
	private String requireTech;
	private String requireResource;
	private Terrain terrain;
	private int cost;
	private Set<String> actions; 
	
	public Set<String> getActions(){return actions;}
	public void setActions(Set<String> l){actions = l;}
        /*
	public MapLocation getLocation() {
		return location;
	}
	public void setLocation(MapLocation location) {
		this.location = location;
	}
        * */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMovement() {
		return movement;
	}
	public void setMovement(double movement) {
		this.movement = movement;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public String getRequireTech() {
		return requireTech;
	}
	public void setRequireTech(String requireTech) {
		this.requireTech = requireTech;
	}
	public String getRequireResource() {
		return requireResource;
	}
	public void setRequireResource(String requireResource) {
		this.requireResource = requireResource;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Terrain getTerrain() {
		return terrain;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public abstract double getDefenseBonus(Unit u);
	public abstract void heal();
	public abstract Object act(String actName, List<Object> param);
}
