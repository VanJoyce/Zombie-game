package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Weapon;

public class FireShotgunAction extends Action{
	private Exit direction;
	static final String NORTH = "8";
	static final String NORTH_EAST = "9";
	static final String EAST = "6";
	static final String SOUTH_EAST = "3";
	static final String SOUTH = "2";
	static final String SOUTH_WEST = "1";
	static final String WEST = "4";
	static final String NORTH_WEST = "7";
	
	private Weapon shotgun;
	protected Random rand = new Random();
	
	public FireShotgunAction(Exit e,Weapon shotgun) {
		// check GameMap for where they add the string
		this.direction = e;
		this.shotgun=shotgun;
	}
	

	@Override
	public String execute(Actor actor, GameMap map) {
		String result = menuDescription(actor);
		List<Location> range = getRange(map);
		//if all actor dont have the same percentage of getting hit: add double here
		Double getDouble=rand.nextDouble();
		for (Location l : range) {
			// add attack action if actor is here (75% chance)
			//map.at(l.x(), l.y()).setGround(new Fence()); // just for visualisation
			
			//if all actor dont have the same percentage of getting hit: add double here
			 //Double getDouble=rand.nextDouble();
			 if (l.containsAnActor()){
				 if (getDouble<1.00){
				    Actor target=l.getActor();
				    
				    //if no zombie limbs are falling out, then:
				    ShotgunAttackAction attack=new ShotgunAttackAction(target);
				    
				   /*
				    target instanceof Zombie
				    if (target.isInstance(Zombie)){
				    	ZombieAttackAction attack=new ZombieAttackAction(target);
				    }
				    
					else{
						AttackAction attack=new ShotgunAttackAction(target);
					}
					*/
					/////
					result=result+"\n"+attack.execute(actor, map,shotgun,30);
				      
				 }
			
			 }
		
		}
		return result;
	}

	@Override
	public String menuDescription(Actor actor) {
		return "Fire the shotgun " + direction.getName();
	}
	
	@Override
	public String hotkey() {
		return direction.getHotKey();
	}
	
	private ArrayList<Location> getRange(GameMap map) {
		ArrayList<Location> range = new ArrayList<Location>();
		int x = direction.getDestination().x();
		int y = direction.getDestination().y();
		int right = 0;
		int up = 0;
		if (direction.getHotKey() == NORTH || direction.getHotKey() == SOUTH) {
			if (direction.getHotKey() == NORTH) {
				up = -1;
			} else {
				up = 1;
			}
			
			int width;
			for (int m = 0; m < 3; m++) {
				width = -m;
				for (int n = 0; n < (m*2+1); n++) {
					range.add(map.at(x + width, y + (up * m)));
					width++;
				}
			}
		} else if (direction.getHotKey() == EAST || direction.getHotKey() == WEST) {
			if (direction.getHotKey() == EAST) {
				right = 1;
			} else {
				right = -1;
			}
			
			int height;
			for (int m = 0; m < 3; m++) {
				height = -m;
				for (int n = 0; n < (m*2+1); n++) {
					range.add(map.at(x + (right * m), y + height));
					height++;
				}
			}
		} else {
			if (direction.getHotKey() == NORTH_EAST) {
				up = -1;
				right = 1;
			} else if (direction.getHotKey() == NORTH_WEST) {
				up = -1;
				right = -1;
			} else if (direction.getHotKey() == SOUTH_EAST) {
				up = 1;
				right = 1;
			} else {
				up = 1;
				right = -1;
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					range.add(map.at(x + (right*i), y + (up*j)));
				}
			}
		}
		
		return range;
	}
		
}
