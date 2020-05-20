package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * Behaviour class to check surrounding ground for unripe crops
 * @author Vanessa
 *
 */
public class HarvestBehaviour implements Behaviour{

	/**
	 * Returns action for harvesting crop if crop is ripe.
	 * 
	 * @param actor the actor that is harvesting the crop
	 * @param map the map which the crop is on
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location location = map.locationOf(actor);
		if (location.getGround() instanceof Crop) {
			Crop crop = (Crop) location.getGround();
			if (crop.getAge() >= 20) {
				return new HarvestAction(location);
			}
		}
		
		List<Exit> exits = new ArrayList<Exit>(map.locationOf(actor).getExits());
		Collections.shuffle(exits);
		
		for (Exit e: exits) {
			if (!(e.getDestination().getGround() instanceof Crop))
				continue;
			if (e.getDestination().getGround() instanceof Crop) {
				return new HarvestAction(e.getDestination());
			}
		}
		return null;
	}

}
