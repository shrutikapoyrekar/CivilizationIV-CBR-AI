package iu.edu.civ.unit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Warrior extends MilitaryUnit {
	static{
		baseStrength = 2;
		cost = 22;
		upgradeList = new ArrayList<MilitaryUnit>();
		upgradeList.add(new Axeman());
		upgradeList.add(new Spearman());
	}
	public Warrior(){
		super(0, new ArrayList<String>());
		this.name="Warrier";
		this.baseMovement = 1;
		this.unitType = "Melee";
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("City Raider I");
		this.possiblePromotions.add("Woodsman I");
	}
	public Warrior(int exp){
		super(exp, new ArrayList<String>());
		this.name="Warrier";
		this.unitType = "Melee";
		this.baseMovement = 1;
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("City Raider I");
		this.possiblePromotions.add("Woodsman I");
	}
	public Warrior(int exp, List<String> prom){
		super(exp, new ArrayList<String>());
		this.name="Warrier";
		this.baseMovement = 1;
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
	@Override
	public double getDefenseBonus(MilitaryUnit u) {
		double i = super.getDefenseBonus(u);
		if(this.getTerrain()!=null && this.getTerrain().getCity()!=null) i += 0.25;
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
		if(s.equals("Axeman")) return new Axeman(exp,promotions);
		else if (s.equals("Spearman")) return new Spearman(exp,promotions);
		return null;
	}

}
