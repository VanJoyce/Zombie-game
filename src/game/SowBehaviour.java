package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;

/**
 * Behaviour to check if crop can be planted on the ground adjacent to actor.
 * @author Vanessa
 *
 */
public class SowBehaviour implements Behaviour {
	private Random rand = new Random();

	/**
	 * Returns a SowAction to sow a crop at location if it is a patch of dirt.
	 * @param actor the actor that is looking for dirt
	 * @param map the map that the actor is currently on
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		List<Exit> exits = new ArrayList<Exit>(map.locationOf(actor).getExits());
		Collections.shuffle(exits);
		
		for (Exit e: exits) {
			boolean cond1 = e.getDestination().getGround() instanceof Dirt;
			boolean cond2 = rand.nextDouble() <= 0.33;
			boolean cond3 = !e.getDestination().containsAnActor();
			
			if (cond1 && cond2 && cond3) {
				return new SowAction(e.getDestination());
			}
		}
		return null;
	}
	
}
