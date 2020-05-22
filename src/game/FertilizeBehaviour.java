package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * Behaviour to check if ground at current location actor is standing on, is an unripe crop. 
 * @author Vanessa
 *
 */
public class FertilizeBehaviour implements Behaviour {
	private Random rand = new Random();
	
	/**
	 * Returns a FertilizeAction on the location where actor is standing if there is an unripe crop.
	 * 
	 * @param actor the actor who fertilizes the crop
	 * @param map the map which the crop is on
	 * @return a new FertilizeAction if there is an unripe crop, otherwise null
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location location = map.locationOf(actor);
		if (location.getGround() instanceof Crop) {
			Crop crop = (Crop) location.getGround();
			if (crop.getAge() < 20 && rand.nextDouble() < 0.6) { // 60% chance of fertilizing the crop
				return new FertilizeAction(location);
			}
		}
		return null;
	}
	
}
