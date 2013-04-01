package iu.edu.civ;

public class TerrainFeature {
	private String name;
	private int food, product, commerce;
	private double movementCost;
	private double defenseBonus;
	private double healthBonus;
	private double diseasePenalty;
	private boolean passable;
	
	private TerrainFeature(String name, int food, int product, int commerce, 
			double movementCost, double defenseBonus, double healthBonus, double dp, boolean passable){
		this.name= name;
		this.food = food;
		this.product = product;
		this.commerce = commerce;
		this.movementCost = movementCost;
		this.defenseBonus = defenseBonus;
		this.healthBonus = healthBonus;
		this.defenseBonus = dp;
		this.passable = passable;
	}
	
	public static TerrainFeature getForest(){
		return new TerrainFeature("Forest",0,1,0,2,0.5,0.5,0,true);
	}	
	public static TerrainFeature getJungle(){
		return new TerrainFeature("Jungle",-1,0,0,2,0.5,0,0.25,true);
	}	
	public static TerrainFeature getIce(){
		return new TerrainFeature("Ice",0,0,0,0,0,0,0,false);
	}

	public String getName() {
		return name;
	}

	public int getFood() {
		return food;
	}

	public int getProduct() {
		return product;
	}

	public int getCommerce() {
		return commerce;
	}

	public double getMovementCost() {
		return movementCost;
	}

	public double getDefenseBonus() {
		return defenseBonus;
	}

	public double getHealthBonus() {
		return healthBonus;
	}

	public double getDiseasePenalty() {
		return diseasePenalty;
	}

	public boolean isPassable() {
		return passable;
	}
}
