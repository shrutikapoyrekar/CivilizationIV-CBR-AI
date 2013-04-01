package iu.edu.civ;

import java.util.List;

public abstract class MilitaryUnit extends Unit {
	private double strength;
	private String unitType;
	private double cityDefense;
	private double hillDefense;
	private boolean canBombard;
	private int exp;
	private int nextLvl;
	private List<String> promotions;
	private List<String> possiblePromotions;
	private double defenseBonus=0;
	
	
	public List<String> getPossiblePromotions() {
		return possiblePromotions;
	}
	public void setPossiblePromotions(List<String> possiblePromotions) {
		this.possiblePromotions = possiblePromotions;
	}
	public double getDefenseBonus(){return defenseBonus;}
	public void setDefenseBonus(double db){defenseBonus = db;} 
	public double getStrength() {
		return strength;
	}
	public void setStrength(double strength) {
		this.strength = strength;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public double getCityDefense() {
		return cityDefense;
	}
	public void setCityDefense(double cityDefense) {
		this.cityDefense = cityDefense;
	}
	public double getHillDefense() {
		return hillDefense;
	}
	public void setHillDefense(double hillDefense) {
		this.hillDefense = hillDefense;
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
	
	public abstract double getAttackBonus(Unit u);	
	protected abstract void promote(String s); 
	@Override
	public Object act(String actName, List<Object> param) {
		if(actName.equals("attack")){
			Object o = param.get(0);
			if (o instanceof MilitaryUnit){
				MilitaryUnit u = (MilitaryUnit) param.get(0);
				return new java.util.Random().nextDouble()*2<(this.strength*(1+this.getAttackBonus(u))/(1+u.getDefenseBonus(u))/u.getStrength());
			}else if (o instanceof Unit)
				return true;
			else{
				//TODO
				
			}
		}else if (actName.equals("bombard")){
			//TODO 
			return null;
		}else if (actName.equals("promote")){
			String s = param.get(0).toString();
			promote(s);
		}else if (actName.equals("defend")){
			defenseBonus = defenseBonus>=0.5?0.5:defenseBonus+0.1;
			return null;
		}
		return null;
	}

}
