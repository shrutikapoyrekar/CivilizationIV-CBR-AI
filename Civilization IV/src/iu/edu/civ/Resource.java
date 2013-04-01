package iu.edu.civ;

public abstract class Resource {
	String requirement;
	String name;
	int food,product,commerse;
	int healthBonus;
	int happinessBonus;
	
	protected Resource(){}
	protected Resource(String r, String n,int f,int p,int c,int h, int hb){
		requirement = r;
		name = n;
		healthBonus = h;
		happinessBonus = hb;
		food = f;
		product = p;
		commerse = c;
	}
	
	public String getRequirement(){return requirement;}
	public String getName() {
		return name;
	}
	
	public int getHealthBonus() {
		return healthBonus;
	}
	public int getHappinessBonus() {
		return happinessBonus;
	}
	public abstract boolean isEnabledBy(Improvement i);
	public String getRevealedBy(){return requirement;};
	
	public final static Resource getHourse(){return new Hourse();}
	public final static Resource getSheep(){return new Sheep();}
	public final static Resource getGold(){return new Gold();}
	public final static Resource getCopper(){return new Copper();}
	public final static Resource getIron(){return new Iron();}
	public final static Resource getFish(){return new Fish();}
	public final static Resource getWhale(){return new Whale();}
	public final static Resource getWine(){return new Wine();}
	public final static Resource getStone(){return new Stone();}
	public final static Resource getMarble(){return new Marble();}
	public final static Resource getDye(){return new Dye();}
	public final static Resource getIncense(){return new Incense();}
	public final static Resource getFur(){return new Fur();}
	public final static Resource getIvory(){return new Ivory();}
}

class Hourse extends Resource{
	Hourse(){
		super("AnimalHusbandry", "Hourse",0,1,0, 0, 0);
	}

	@Override
	public boolean isEnabledBy(Improvement i) {
		if (i==null) return false;
		else if (i.getName().equals("Pasture")) return true;
		else return false;
	}
	
}

class Sheep extends Resource{
	Sheep(){
		super(null, "Sheep",1,0,0, 1, 0);
	}
	@Override
	public boolean isEnabledBy(Improvement i) {
		if (i==null) return false;
		else if (i.getName().equals("Pasture")) return true;
		else return false;
	}
	
}

class Gold extends Resource{
	Gold(){
		super(null, "Gold", 0,0,1,0, 1);
	}
	@Override
	public boolean isEnabledBy(Improvement i) {
		if (i==null) return false;
		else if (i.getName().equals("Mine")) return true;
		else return false;
	}
	
}

class Copper extends Resource{
	Copper(){
		super("BronzeWorking", "Copper",0,1,0, 0, 0);
	}
	@Override
	public boolean isEnabledBy(Improvement i) {
		if (i==null) return false;
		else if (i.getName().equals("Mine")) return true;
		else return false;
	}
	
}

class Iron extends Resource{
	Iron(){
		super("IronWorking", "Copper",0,1,0, 0, 0);
	}
	@Override
	public boolean isEnabledBy(Improvement i) {
		if (i==null) return false;
		else if (i.getName().equals("Mine")) return true;
		else return false;
	}
	
}
class Fish extends Resource{
	Fish(){
		super(null, "Fish",1,0,0, 1, 0);
	}
	@Override
	public boolean isEnabledBy(Improvement i) {
		if (i==null) return false;
		else if (i.getName().equals("FishingBoats")) return true;
		else return false;
	}
	
}

class Whale extends Resource{
	Whale(){
		super(null, "Whale",1,0,0, 1, 0);
	}
	@Override
	public boolean isEnabledBy(Improvement i) {
		if (i==null) return false;
		else if (i.getName().equals("WhalingBoats")) return true;
		else return false;
	}
	
}

class Wine extends Resource{
	Wine(){
		super("Monarchy", "Wine",0,0,1, 0, 1);
	}
	@Override
	public boolean isEnabledBy(Improvement i) {
		if (i==null) return false;
		else if (i.getName().equals("Winery")) return true;
		else return false;
	}
	
}


class Stone extends Resource{
	Stone(){
		super(null, "Stone",0,1,0, 0, 0);
	}
	@Override
	public boolean isEnabledBy(Improvement i) {
		if (i==null) return false;
		else if (i.getName().equals("Quarry")) return true;
		else return false;
	}
	
}

class Marble extends Resource{
	Marble(){
		super(null, "Marble",0,1,0, 0, 0);
	}
	@Override
	public boolean isEnabledBy(Improvement i) {
		if (i==null) return false;
		else if (i.getName().equals("Quarry")) return true;
		else return false;
	}
	
}

class Dye extends Resource{
	Dye(){
		super(null, "Dye",0,0,1, 0, 1);
	}
	@Override
	public boolean isEnabledBy(Improvement i) {
		if (i==null) return false;
		else if (i.getName().equals("Plantation")) return true;
		else return false;
	}
	
}

class Incense extends Resource{
	Incense(){
		super(null, "Incense",0,0,1, 0, 1);
	}
	@Override
	public boolean isEnabledBy(Improvement i) {
		if (i==null) return false;
		else if (i.getName().equals("Plantation")) return true;
		else return false;
	}
	
}


class Fur extends Resource{
	Fur(){
		super(null, "Fur",0,0,1, 0, 1);
	}
	@Override
	public boolean isEnabledBy(Improvement i) {
		if (i==null) return false;
		else if (i.getName().equals("Camp")) return true;
		else return false;
	}
	
}
class Ivory extends Resource{
	Ivory(){
		super(null, "Ivory",0,0,1, 0, 1);
	}
	@Override
	public boolean isEnabledBy(Improvement i) {
		if (i==null) return false;
		else if (i.getName().equals("CAmp")) return true;
		else return false;
	}
	
}

