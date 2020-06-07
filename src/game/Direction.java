package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public abstract class Direction {
	
	protected Actor actor;
	protected GameMap map;
	protected List<Location> coordinates = new ArrayList<Location>();
	
	public Direction(Actor actor,GameMap map) {
		this.actor=actor;
		this.map=map;
	}
	
	public abstract String name();
	public abstract List<Location> getLocationInDirection();

}