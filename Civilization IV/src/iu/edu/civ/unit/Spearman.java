package iu.edu.civ.unit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Spearman extends MilitaryUnit {
	static{
		baseStrength = 2;
		cost = 52;
		upgradeList = new ArrayList<MilitaryUnit>();
		upgradeList.add(new Pikeman());
		requireResource = "Copper";
		requireTech = new ArrayList<String>();
		requireTech.add("Hunting");
	}
	public Spearman(){
		super(0, new ArrayList<String>());
		this.baseMovement = 1;
		this.name = "Spearman";
		this.unitType = "Melee";
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("City Raider I");
		this.possiblePromotions.add("Woodsman I");
	}
	public Spearman(int exp){
		super(exp, new ArrayList<String>());
		this.name = "Spearman";
		this.baseMovement = 1;
		this.unitType = "Melee";
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("City Raider I");
		this.possiblePromotions.add("Woodsman I");
	}
	public Spearman(int exp, List<String> prom){
		super(exp, new ArrayList<String>());
		this.baseMovement = 1;
		this.name = "Spearman";
		this.unitType = "Melee";
		Iterator<String> i = prom.iterator();
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("City Raider I");
		this.possiblePromotions.add("Woodsman I");
		for (;i.hasNext();){
			this.promote(i.next(),false);
		}
	}
	
	public double getDefenseBonus(MilitaryUnit u) {
		double i = super.getDefenseBonus(u);
		if(u!=null && u.getUnitType().equals("Mounted")) i+= 1;
		return i;
	}
	
	public double getAttackBonus(MilitaryUnit u){
		double i = super.getAttackBonus(u);
		if(u!=null && u.getUnitType().equals("Mounted")) i+= 1;
		return i;
	}
	
	protected void promote(String s,boolean costExp){
		super.promote(s, costExp);
		if(s.equals("Combat I")){
			possiblePromotions.add("Cover");
			possiblePromotions.add("Shock");
			possiblePromotions.add("Medic I");
		}else if (s.equals("Combat II")){
			possiblePromotions.add("Formation");
			possiblePromotions.add("Charge");
			possiblePromotions.add("Amphibious");
		}else if (s.equals("Medic I")){
			possiblePromotions.add("March");
		}
	}
	
	@Override
	public MilitaryUnit upgrade(String s) {
		if(s.equals("Pikeman")) return new Pikeman(exp,promotions);
		return null;
	}

}
