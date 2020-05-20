package game;

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
	
	/**
	 * Returns a FertilizeAction on the unripe crop at location where actor is standing.
	 * 
	 * @param actor the actor who fertilizes the crop
	 * @param map the map which the crop is on
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location location = map.locationOf(actor);
		if (location.getGround() instanceof Crop) {
			Crop crop = (Crop) location.getGround();
			if (crop.getAge() < 20) {
				return new FertilizeAction(location);
			}
		}
		return null;
	}
	
}
