package iu.edu.civ.unit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Axeman extends MilitaryUnit {
	static{
		baseStrength = 5;
		cost = 52;
		upgradeList = new ArrayList<MilitaryUnit>();
		upgradeList.add(new Maceman());
		requireResource = "Copper";
		requireTech = new ArrayList<String>();
		requireTech.add("Broze Working");
	}
	public Axeman(){
		super(0, new ArrayList<String>());
		this.name = "Axeman";
		this.baseMovement = 1;
		this.unitType = "Melee";
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("City Raider I");
		this.possiblePromotions.add("Woodsman I");
	}
	public Axeman(int exp){
		super(exp, new ArrayList<String>());
		this.name = "Axeman";
		this.baseMovement = 1;
		this.unitType = "Melee";
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("City Raider I");
		this.possiblePromotions.add("Woodsman I");
	}
	public Axeman(int exp, List<String> prom){
		super(exp, new ArrayList<String>());
		this.name = "Axeman";
		this.unitType = "Melee";
		this.baseMovement = 1;
		Iterator<String> i = prom.iterator();
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("City Raider I");
		this.possiblePromotions.add("Woodsman I");
		for (;i.hasNext();){
			this.promote(i.next(),false);
		}
	}

	@Override
	public double getDefenseBonus(MilitaryUnit u) {
		double i = super.getDefenseBonus(u);
		if(u!=null && u.getUnitType().equals("Melee")) i+= 0.5;
		return i;
	}
	
	public double getAttackBonus(MilitaryUnit u){
		double i = super.getAttackBonus(u);
		if(u!=null && u.getUnitType().equals("Melee")) i+= 0.5;
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
		if(s.equals("Maceman")) return new Maceman(exp,promotions);
		return null;
	}

}
