package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class Direction {
	
	protected Actor actor;
	protected GameMap map;
	//protected List<Location> coordinates = new ArrayList<Location>();
	
	public Direction(Actor actor,GameMap map,String name) {
		this.actor=actor;
		this.map=map;
	}
	
	public String name() {return null;};
	
	public List<Location> getLocationInDirection(int[][] coordinate){
		List<Location> allLocation=new ArrayList<>();
		Location location= map.locationOf(actor);
		int x=location.x();
		int y=location.y();
		
		for(int i=0;i<coordinate.length;i++) {
			int[] sublist=coordinate[i];
			int xFromSublist=sublist[0];
			int yFromSublist=sublist[1];
			
			int xCoordinate=x+xFromSublist;
			int yCoordinate=y+yFromSublist;
			
			if(map.getXRange().contains(xCoordinate) && map.getYRange().contains(yCoordinate)) {
				allLocation.add(new Location(map,xCoordinate,yCoordinate));
			}
		}	
		return Collections.unmodifiableList(allLocation);
		
	};

}