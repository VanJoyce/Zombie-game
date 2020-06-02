package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Action class for chanting. 5 new Zombies are spawned randomly on the map.
 * @author Vanessa
 *
 */
public class ChantAction extends Action{
	private int chantCounter = 0;
	private Random rand = new Random();
	
	public ChantAction(int chantCounter) {
		this.chantCounter = chantCounter;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		int noOfZombies = 0;
		
		while (noOfZombies < 5) {
			noOfZombies++;
			String name = "Zombie Minion " + chantCounter + "." + noOfZombies;
			Zombie zombie = new Zombie(name);
			
			int x = rand.nextInt(map.getXRange().max());
			int y = rand.nextInt(map.getYRange().max());
			
			while (!map.at(x, y).canActorEnter(zombie)) {
				x = rand.nextInt(map.getXRange().max());
				y = rand.nextInt(map.getYRange().max());
			};
			map.at(x, y).addActor(zombie);
		}
		
		return actor + "chants, causing 5 new zombies to rise from the dead.";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + "chants";
	}

}
