package iu.edu.civ;

public class BaseTerrain {
	private String name;
	private int food, product, commerce;
	private boolean canBuildCity;
	private double defenseBonus;
	private double improvementPenalty;
	private boolean hill;
	
	public boolean isHill() 
        {
		return hill;
	}

	private BaseTerrain(String name, int food, int product, int commerce, boolean canBuildCity, double db,double ip,boolean h){
		this.name = name;
		this.food = food;
		this.product = product;
		this.commerce = commerce;
		this.canBuildCity = canBuildCity;
		this.defenseBonus = db;
		this.improvementPenalty = ip;
		this.hill = h;
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

	public boolean isCanBuildCity() {
		return canBuildCity;
	}

	public double getDefenseBonus() {
		return defenseBonus;
	}

	public double getImprovementPenalty() {
		return improvementPenalty;
	}

	public String getName() {
		return name;
	}

	public static BaseTerrain getCoast(){
		return new BaseTerrain("Coast",1,0,2,false,0.1,0, false);
	}
	public static BaseTerrain getGrassland(boolean isHill){
		return new BaseTerrain("Grassland",2,0,0,true,0,0,isHill);
	}
	public static BaseTerrain getIce(){
		return new BaseTerrain("Ice",0,0,0,true,0,0.5, false);
	}
	public static BaseTerrain getOcean(){
		return new BaseTerrain("Ocean",1,0,1,false,0,0,false);
	}
	public static BaseTerrain getPlains(boolean isHill){
		return new BaseTerrain("Plains",1,1,0,true,0,0,isHill);
	}
	public static BaseTerrain getDesert(boolean isHill){
		return new BaseTerrain("Desert",0,0,0,true,0,0.25,isHill);
	}
}
