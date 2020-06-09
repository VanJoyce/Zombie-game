package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class North extends Direction{

	public North(Actor actor, GameMap map) {
		super(actor, map);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Location> getLocationInDirection() {
		// TODO Auto-generated method stub
		List<Location> allLocation=new ArrayList<>();
		int [][] coordinate=new int[][] {{0,-1},{-1,-1},{-1,0},{-1,1},{-2,-2},{-2,-1},{-2,0},{-2,1},{-2,2}};
		
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
	}

	@Override
	public String name() {
		String string="North";
		return string;
	}

	public String execute() {}
}
