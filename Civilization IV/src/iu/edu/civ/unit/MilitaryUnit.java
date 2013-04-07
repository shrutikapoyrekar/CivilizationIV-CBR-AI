package iu.edu.civ.unit;

import java.util.List;

public abstract class MilitaryUnit extends Unit {
	protected String unitType;
	protected boolean canBombard=false;
	protected int exp=0;
	protected int level = 1;
	protected static int[] exps={2,5,10,17,26,37,50,65,};
	protected int nextLvl=5;
	protected List<String> promotions=null;
	protected List<String> possiblePromotions=null;
	protected double defenseBonus=0;
	protected static int baseStrength=0;
	protected int baseMovement = 0;
	protected static List<MilitaryUnit> upgradeList;
	
	public MilitaryUnit(){}
	public MilitaryUnit(int exp){this.exp = exp;}
	public MilitaryUnit(int exp, List<String> promotions){this.exp = exp; this.promotions = promotions;}
	
	public int getBaseMovement() {
		return baseMovement;
	}
	public static List<MilitaryUnit> getUpgradeList_static() {
		return upgradeList;
	}
	public List<MilitaryUnit> getUpgradeList(){
		return upgradeList;
	}
	public static int getBaseStrength_static() {
		return baseStrength;
	}
	public int getBaseStrength(){
		return baseStrength;
	}
	public static void setBaseStrength(int baseStrength) {
		MilitaryUnit.baseStrength = baseStrength;
	}
	public List<String> getPossiblePromotions() {
		return possiblePromotions;
	}
	public void setPossiblePromotions(List<String> possiblePromotions) {
		this.possiblePromotions = possiblePromotions;
	}
	//TODO
	public double getDefenseBonus(){return defenseBonus;}
	public void setDefenseBonus(double db){defenseBonus = db;} 
	public double getStrength() {
		return baseStrength * this.health / 100;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public boolean isCanBombard() {
		return canBombard;
	}
	public void setCanBombard(boolean canBombard) {
		this.canBombard = canBombard;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getNextLvl() {
		return nextLvl;
	}
	public void setNextLvl(int nextLvl) {
		this.nextLvl = nextLvl;
	}
	public List<String> getPromotions() {
		return promotions;
	}
	public void setPromotions(List<String> promotions) {
		this.promotions = promotions;
	}
		

	public double getDefenseBonus(MilitaryUnit u){
		double i =0;

		if (this.promotions.contains("Combat I")) i += 0.1;
		if (this.promotions.contains("Combat II")) i += 0.1;
		if (this.promotions.contains("Combat III")) i += 0.1;
		if (this.promotions.contains("Combat IV")) i += 0.1;
		if (this.promotions.contains("Combat V")) i += 0.1;
		if (this.promotions.contains("City Garrison I") && this.getTerrain()!=null && this.getTerrain().getCity()!= null) i += 0.2;
		if (this.promotions.contains("City Garrison II") && this.getTerrain()!=null && this.getTerrain().getCity()!= null) i += 0.25;
		if (this.promotions.contains("City Garrison III") && this.getTerrain()!=null && this.getTerrain().getCity()!= null) i += 0.3;
		if (this.promotions.contains("Guerilla I") && this.getTerrain()!=null && this.getTerrain().getBaseTerrain()!= null && this.getTerrain().getBaseTerrain().isHill()) i += .2;
		if (this.promotions.contains("Guerilla II") && this.getTerrain()!=null && this.getTerrain().getBaseTerrain()!= null && this.getTerrain().getBaseTerrain().isHill()) i += .3;
		if (this.promotions.contains("Woodsman I") && this.getTerrain()!=null && this.getTerrain().getTerrainFeature()!= null && (this.getTerrain().getTerrainFeature().getName().equals("Jungle") || this.getTerrain().getTerrainFeature().getName().equals("Forest"))) i += .2;
		if (this.promotions.contains("Woodsman II") && this.getTerrain()!=null && this.getTerrain().getTerrainFeature()!= null && (this.getTerrain().getTerrainFeature().getName().equals("Jungle") || this.getTerrain().getTerrainFeature().getName().equals("Forest"))) i += .3;
		if (u==null) return i;
		if (this.promotions.contains("City Garrison III") && u!=null && u.getUnitType().equals("Melee")) i += 0.1;
		if (this.promotions.contains("Cover") && u.getUnitType().equals("Archery")) i += 0.25;
		if (this.promotions.contains("Shock") && u.getUnitType().equals("Melee")) i += 0.25;
		if (this.promotions.contains("Formation") && u.getUnitType().equals("Mounted")) i += 0.25;
		if (this.promotions.contains("Charge") && u.getUnitType().equals("Siege")) i += 0.25;
		if (this.promotions.contains("Ambush") && u.getUnitType().equals("Armored")) i += 0.25;
		if (this.promotions.contains("Pinch") && u.getUnitType().equals("Gunpowder")) i += 0.25;
		if (this.promotions.contains("Drill IV") && u.getUnitType().equals("Mounted")) i += 0.1;
		return i;
	}
	
	public double getAttackBonus(MilitaryUnit u){
		double i = 0;
		if (this.promotions.contains("Combat I")) i += 0.1;
		if (this.promotions.contains("Combat II")) i += 0.1;
		if (this.promotions.contains("Combat III")) i += 0.1;
		if (this.promotions.contains("Combat IV")) i += 0.1;
		if (this.promotions.contains("Combat V")) i += 0.1;
		if (u==null) return i;
		if (this.promotions.contains("Cover") && u.getUnitType().equals("Archery")) i += 0.25;
		if (this.promotions.contains("Shock") && u.getUnitType().equals("Melee")) i += 0.25;
		if (this.promotions.contains("Formation") && u.getUnitType().equals("Mounted")) i += 0.25;
		if (this.promotions.contains("Charge") && u.getUnitType().equals("Siege")) i += 0.25;
		if (this.promotions.contains("Ambush") && u.getUnitType().equals("Armored")) i += 0.25;
		if (this.promotions.contains("Pinch") && u.getUnitType().equals("Gunpowder")) i += 0.25;
		if (this.promotions.contains("City Raider I") && u.getTerrain().getCity() != null) i += 0.2;
		if (this.promotions.contains("City Raider II") && u.getTerrain().getCity() != null) i += 0.25;
		if (this.promotions.contains("City Raider III") && u.getTerrain().getCity() != null) i += 0.3;
		if (this.promotions.contains("City Raider III") && u.getUnitType().equals("Gunpowder")) i += 0.1;
		if (this.promotions.contains("Drill IV") && u.getUnitType().equals("Mounted")) i += 0.1;
		if (this.promotions.contains("City Garisson III") && u.getUnitType().equals("Melee")) i += 0.1;
		if (this.promotions.contains("Barrage II") && u.getUnitType().equals("Melee")) i += 0.1;
		if (this.promotions.contains("Barrage III") && u.getUnitType().equals("Gunpowder")) i += 0.1;
		return i;
	};	
	protected void promote(String s,boolean costExp){
		if (!this.possiblePromotions.contains(s)) return;
		if(costExp && exp > nextLvl){
			nextLvl = exps[++level];
			this.health = health+25>100?100:health+25;
			this.promotions.add(s);
			this.possiblePromotions.remove(s);
		}else if (!costExp){
			this.promotions.add(s);
			this.possiblePromotions.remove(s);
		}else
			return;
		if (s.equals("Combat I")) possiblePromotions.add("Combat II");
		if (s.equals("Combat II")) possiblePromotions.add("Combat III");
		if (s.equals("Combat III")) possiblePromotions.add("Combat IV");
		if (s.equals("Combat IV")) possiblePromotions.add("Combat V");
	
		if (s.equals("Guerilla I")) possiblePromotions.add("Guerilla II");
		if (s.equals("Barrage I")) possiblePromotions.add("Barrage II");
		if (s.equals("Barrage II")) possiblePromotions.add("Barrage III");
		if (s.equals("City Garrison I")) possiblePromotions.add("City Garrison II");
		if (s.equals("City Garrison II")) possiblePromotions.add("City Garrison III");
		if (s.equals("City Raider I")) possiblePromotions.add("City Raider II");
		if (s.equals("City Raider II")) possiblePromotions.add("City Raider III");
		if (s.equals("Drill I")) possiblePromotions.add("Drill II");
		if (s.equals("Drill II")) possiblePromotions.add("Drill III");
		if (s.equals("Drill III")) possiblePromotions.add("Drill IV");
		if (s.equals("Flanking I")) possiblePromotions.add("Flanking II");
		if (s.equals("Medic I")) possiblePromotions.add("Medic II");
		if (s.equals("Navigation I")) possiblePromotions.add("Navigation II");
		if (s.equals("Woodsman I")) possiblePromotions.add("Woodsman II");
	} 
	public abstract MilitaryUnit upgrade(String s);
	@Override
	public Object act(String actName, List<Object> param) {
		if(actName.equals("attack")){
			Object o = param.get(0);
			if (o instanceof MilitaryUnit){
				MilitaryUnit u = (MilitaryUnit) param.get(0);
				//TODO set health & strength
				double i = new java.util.Random().nextDouble()*2;
				return i<(this.getStrength()*(1+this.getAttackBonus(u))/(1+u.getDefenseBonus(u))/u.getStrength());
			}else if (o instanceof Unit)
				return true;
			else{
				//TODO
				
			}
			
			if (!this.promotions.contains("Blitz")) this.movement = 0;
			else this.movement -= 0.5;
		}else if (actName.equals("bombard")){
			//TODO 
			return null;
		}else if (actName.equals("promote")){
			String s = param.get(0).toString();
			Object o = param.get(1);
			if (o==null)
				promote(s,true);
			else
				promote(s,(Boolean)o);
		}else if (actName.equals("defend")){
			defenseBonus = defenseBonus>=0.5?0.5:defenseBonus+0.1;
			return null;
		}else if (actName.equals("heal")){
			this.health += 25;
			if (health > 100) health = 100;
		}
		return null;
	}
	public int getLevel() {
		return level;
	}

    public void wasAttacked(int baseStrength) 
    {
        health = health-baseStrength;
    }

}
