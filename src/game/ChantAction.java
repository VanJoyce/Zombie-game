package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Action class for chanting. 5 new Zombies are spawned randomly on the map.
 * @author Vanessa
 *
 */
public class ChantAction extends Action{
	
	@Override
	public String execute(Actor actor, GameMap map) {
		//generate random location and add five zombies. Maybe get the max x coordinate and max y coordinate and generate two random integers for x and y coordinates.
		return actor + "chants, causing 5 new zombies to rise from the dead.";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + "chants";
	}

}
