package iu.edu.civ.unit;

import java.util.List;
import java.util.Set;

import iu.edu.civ.Terrain;
import iu.edu.civ2.MapLocation;
import iu.edu.civ2.Player;
import iu.edu.movement.Path;

public abstract class Unit 
{
	protected MapLocation location;
	protected String name;
	protected double movement;
	protected double health;
	protected static List<String> requireTech;
	protected static String requireResource;
	protected Terrain terrain;
	protected static int cost;
	protected Set<String> actions; 
	protected Player player;
	public Set<String> getActions(){return actions;}
	public void setActions(Set<String> l){actions = l;}
	public MapLocation getLocation() {
		return location;
	}
	public void setLocation(MapLocation location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMovement() {
		return movement;
	}
	public void setMovement(double movement) {
		this.movement = movement;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public static List<String> getRequireTech_static() {
		return requireTech;
	}
	public List<String> getRequireTech(){
		return requireTech;
	}
	public static String getRequireResource_static() {
		return requireResource;
	}
	public String getRequireResource(){
		return requireResource;
	}
	public static int getCost_static() {
		return cost;
	}
	public int getCost(){
		return cost;
	}
	public Terrain getTerrain() {
		return terrain;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public abstract Object act(String actName, List<Object> param);

    public MapLocation getMapLocation() 
    {
        return location;
    }

    public void setMoveList(Path moveList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Player getOwner() {
        return player;
    }

    public Path getPath() {
        return path;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isTransport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public enum State {
        IDLE,
        MOVING,
        MOVE_BLOCKED,
        IRRIGATING,
        FARMING,
        MINING,
        BUILDING_ROAD,
    };
        
    protected State state;
    protected Path path;

}
