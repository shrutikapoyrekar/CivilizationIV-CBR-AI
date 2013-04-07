package iu.edu.civ.unit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HourseArcher extends MilitaryUnit {
	static{
		baseStrength = 6;
		cost = 75;
		upgradeList = new ArrayList<MilitaryUnit>();
		upgradeList.add(new Knight());
		requireTech = new ArrayList<String>();
		requireTech.add("HoursebackRiding");
		requireTech.add("Archery");
		requireResource = "Hourse";
	}
	public HourseArcher(){
		super(0, new ArrayList<String>());
		this.name="HourseArcher";
		this.unitType = "Mounted";
		this.baseMovement = 2;
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("Flanking I");
	}
	public HourseArcher(int exp){
		super(exp, new ArrayList<String>());
		this.name="HourseArcher";
		this.baseMovement = 2;
		this.unitType = "Mounted";
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("Flanking I");
	}
	public HourseArcher(int exp, List<String> prom){
		super(exp, new ArrayList<String>());
		this.name="HourseArcher";
		this.unitType = "Mounted";
		this.baseMovement = 2;
		Iterator<String> i = prom.iterator();
		this.possiblePromotions = new ArrayList<String>();
		this.possiblePromotions.add("Combat I");
		this.possiblePromotions.add("Flanking I");
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
			possiblePromotions.add("Pinch");
			possiblePromotions.add("Shock");
			possiblePromotions.add("Medic I");
		}else if (s.equals("Combat II")){
			possiblePromotions.add("Formation");
			possiblePromotions.add("Amphibious");
		}else if (s.equals("Medic I")){
			possiblePromotions.add("March");
		}else if (s.equals("Flanking I")){
			possiblePromotions.add("Sentry");
		}else if (s.equals("Flanking II")){
			possiblePromotions.add("Mobility");
		}else if (s.equals("Combat III")){
			possiblePromotions.add("Blitz");
		}
	}
	
	@Override
	public MilitaryUnit upgrade(String s) {
		if(s.equals("Knight")) return new Knight(exp,promotions);
		return null;
	}
}
