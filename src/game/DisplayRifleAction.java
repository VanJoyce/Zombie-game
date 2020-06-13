package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Menu;
import edu.monash.fit2099.engine.Weapon;

public class DisplayRifleAction extends Action{
	
	Menu submenu = new Menu();
	Display display;
	Actions shootDirections = new Actions();
	protected Weapon rifle;
	
	private String targetName; 
	private int maxRange;
	private HashSet<Location> visitedLocations = new HashSet<Location>();
	
	
	public DisplayRifleAction(Display display, Weapon rangedWeapon) {
		// TODO Auto-generated constructor stub
		this.display = display;
		this.rifle=rifle;
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" fires the rifle";
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		Location here=map.locationOf(actor);
		visitedLocations.clear();
		ArrayList<Location> now = new ArrayList<Location>();
		
		now.add(here);
		
		ArrayList<ArrayList<Location>> layer = new ArrayList<ArrayList<Location>>();
		layer.add(now);

		for (int i = 0; i<maxRange; i++) {
			layer = getNextLayer(actor, layer);
			Location there = search(layer);
			if (there != null && there.getActor()!=null ) {		
				//want to attack and aim
				shootDirections.add(new RiffleAction(there.getActor()));
			}
		}
		
		Action action=submenu.showMenu(actor, shootDirections, display);
		return action.execute(actor, map);
	}
	

	

	private ArrayList<ArrayList<Location>> getNextLayer(Actor actor, ArrayList<ArrayList<Location>> layer) {
		ArrayList<ArrayList<Location>> nextLayer = new ArrayList<ArrayList<Location>>();

		for (ArrayList<Location> path : layer) {
			List<Exit> exits = new ArrayList<Exit>(path.get(path.size() - 1).getExits());
			Collections.shuffle(exits);
			for (Exit exit : path.get(path.size() - 1).getExits()) {
				Location destination = exit.getDestination();
				if (!destination.getGround().canActorEnter(actor) || visitedLocations.contains(destination))
					continue;
				visitedLocations.add(destination);
				ArrayList<Location> newPath = new ArrayList<Location>(path);
				newPath.add(destination);
				nextLayer.add(newPath);
			}
		}
		return nextLayer;
	}
	
	private Location search(ArrayList<ArrayList<Location>> layer) {
		for (ArrayList<Location> path : layer) {
			if (containsTarget(path.get(path.size() - 1))) {
				return path.get(1);
			}
		}
		return null;
	}
	
	private boolean containsTarget(Location here) {
		return (here.getActor() != null &&
				here.getActor().hasCapability(ZombieCapability.UNDEAD));
	}
	


}
