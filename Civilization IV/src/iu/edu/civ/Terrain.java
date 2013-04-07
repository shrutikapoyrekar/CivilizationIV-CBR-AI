package iu.edu.civ;

import iu.edu.civ.improvement.Improvement;

class City{}
public class Terrain 
{
	BaseTerrain baseTerrain;
	TerrainFeature terrainFeature;
	Improvement improvement;
	Resource resource;
	boolean road;
	City city;
	
	public City getCity(){return city;}
	public void setCity(City c){city = c;}
	
	public Terrain(BaseTerrain bt, TerrainFeature tf){
		this.baseTerrain = bt;
		this.terrainFeature = tf;
		this.improvement = null;
		this.road = false;
		this.city = null;
	}
	
	public Terrain(BaseTerrain bt, TerrainFeature tf, Improvement im, Resource r){
		this.baseTerrain = bt;
		this.terrainFeature = tf;
		this.improvement = im;
		this.resource = r;
		road = false;
		city = null;
	}
	
	public double getDefenseBonus(){
		return 0;
	}

	public BaseTerrain getBaseTerrain() {
		return baseTerrain;
	}

	public void setBaseTerrain(BaseTerrain baseTerrain) {
		this.baseTerrain = baseTerrain;
	}

	public TerrainFeature getTerrainFeature() {
		return terrainFeature;
	}

	public void setTerrainFeature(TerrainFeature terrainFeature) {
		this.terrainFeature = terrainFeature;
	}

	public Improvement getImprovement() {
		return improvement;
	}

	public void setImprovement(Improvement improvement) {
		this.improvement = improvement;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public boolean isRoad() {
		return road;
	}

	public void setRoad(boolean road) {
		this.road = road;
	}

    public float getMovementCost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
