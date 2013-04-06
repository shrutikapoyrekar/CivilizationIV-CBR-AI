package iu.edu.civ.unit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Archer extends MilitaryUnit {
	static{
		baseStrength = 3;
		cost = 37;
		upgradeList = new ArrayList<MilitaryUnit>();
		upgradeList.add(new Longbowman());
		requireTech = new ArrayList<String>();
		requireTech.add("Archery");
	}
	public Archer(){
		super(0, new ArrayList<String>());
		this.name="Archer";
		this.unitType = "Archery";
		this.baseMovement = 1;
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("City Garrison I");
		this.possiblePromotions.add("Guerilla I");
		this.possiblePromotions.add("Drill I");
	}
	public Archer(int exp){
		super(exp, new ArrayList<String>());
		this.name="Archer";
		this.baseMovement = 1;
		this.unitType = "Archery";
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("City Garrison I");
		this.possiblePromotions.add("Guerilla I");
		this.possiblePromotions.add("Drill I");
	}
	public Archer(int exp, List<String> prom){
		super(exp, new ArrayList<String>());
		this.name="Archer";
		this.unitType = "Archery";
		this.baseMovement = 1;
		Iterator<String> i = prom.iterator();
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("City Garrison I");
		this.possiblePromotions.add("Guerilla I");
		this.possiblePromotions.add("Drill I");
		for (;i.hasNext();){
			this.promote(i.next(),false);
		}
	}
	@Override
	public double getDefenseBonus(MilitaryUnit u) {
		double i = super.getDefenseBonus(u);
		if(this.getTerrain()!=null && this.getTerrain().getCity()!=null) i += 0.5;
		if(this.getTerrain()!=null && this.getTerrain().getBaseTerrain()!=null && this.getTerrain().getBaseTerrain().isHill()) i += 0.25;
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
			possiblePromotions.add("Amphibious");
		}else if (s.equals("Medic I")){
			possiblePromotions.add("March");
		}
	}
	
	@Override
	public MilitaryUnit upgrade(String s) {
		if(s.equals("Longbowman")) return new Longbowman(exp,promotions);
		return null;
	}
}
