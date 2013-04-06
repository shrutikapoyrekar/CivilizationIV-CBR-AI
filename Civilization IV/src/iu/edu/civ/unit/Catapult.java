package iu.edu.civ.unit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Catapult extends MilitaryUnit {
	static{
		baseStrength = 5;
		cost = 60;
		upgradeList = new ArrayList<MilitaryUnit>();
		upgradeList.add(new Cannon());
		requireTech = new ArrayList<String>();
		requireTech.add("Construction");
	}
	public Catapult(){
		super(0, new ArrayList<String>());
		this.name="Catapult";
		this.unitType = "Siege";
		this.baseMovement = 1;
		this.canBombard = true;
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("City Raider I");
		this.possiblePromotions.add("Barrage I");
		this.possiblePromotions.add("Drill I");
	}
	public Catapult(int exp){
		super(exp, new ArrayList<String>());
		this.name="Catapult";
		this.baseMovement = 1;
		this.canBombard = true;
		this.unitType = "Siege";
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("City Raider I");
		this.possiblePromotions.add("Barrage I");
		this.possiblePromotions.add("Drill I");
	}
	public Catapult(int exp, List<String> prom){
		super(exp, new ArrayList<String>());
		this.name="Catapult";
		this.canBombard = true;
		this.unitType = "Siege";
		this.baseMovement = 1;
		Iterator<String> i = prom.iterator();
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("City Raider I");
		this.possiblePromotions.add("Barrage I");
		this.possiblePromotions.add("Drill I");
		for (;i.hasNext();){
			this.promote(i.next(),false);
		}
	}
	@Override
	public double getDefenseBonus(MilitaryUnit u) {
		double i = super.getDefenseBonus(u);
		if (this.getTerrain()!=null) i -= this.getTerrain().getDefenseBonus();
		return i;
	}
	
	protected void promote(String s,boolean costExp){
		super.promote(s, costExp);
		if(s.equals("Combat I")){
			possiblePromotions.add("Shock");
			possiblePromotions.add("Medic I");
		}else if (s.equals("Combat II")){
			possiblePromotions.add("Ambush");
			possiblePromotions.add("Amphibious");
		}else if (s.equals("Medic I")){
			possiblePromotions.add("March");
		}else if (s.equals("Flanking I")){
			possiblePromotions.add("Sentry");
		}else if (s.equals("Flanking II")){
			possiblePromotions.add("Mobility");
		}else if (s.equals("Combat III")){
			possiblePromotions.add("Blitz");
		}else if (s.equals("City Raider I") || s.equals("Barrage I")){
			possiblePromotions.add("Accuracy");
		}
	}
	
	@Override
	public MilitaryUnit upgrade(String s) {
		if(s.equals("Cannon")) return new Cannon(exp,promotions);
		return null;
	}
}
