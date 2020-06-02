package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;

/**
 * Class that represents a Voodoo priestess. She has a 5% chance per turn to appear on the map and every 10 turns she will chant to spawn 5 new zombies
 * on the map. If she is not killed, she will vanish after 30 turns. 
 * @author Vanessa
 *
 */
public class VoodooPriestess extends ZombieActor {
	private int chantCounter = 0;
	private int turnsOnMap = 0;
	private Random rand = new Random();
	private Behaviour behaviour = new WanderBehaviour();
	
	/**
	 * Constructor for Voodoo priestess. 
	 * @param name	the name of the Voodoo priestess
	 */
	public VoodooPriestess(String name) {
		super(name, '&', 200, ZombieCapability.UNDEAD);
	}

	/**
	 * Returns an action 
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		turnsOnMap++;
		if (map.contains(this)) {
			if (turnsOnMap % 10 == 0) {
				chantCounter++;
				return new ChantAction(chantCounter);
			}
			if (turnsOnMap == 30) {
				map.removeActor(this);
			}
		} else {
			System.out.println("I'M HERE");
			if (rand.nextDouble() <= 1) {
				turnsOnMap = 0;
				int x = rand.nextInt(map.getXRange().max());
				int y = rand.nextInt(map.getYRange().max());
				while (!map.at(x, y).canActorEnter(this)) {
					x = rand.nextInt(map.getXRange().max());
					y = rand.nextInt(map.getYRange().max());
				};
				map.at(x, y).addActor(this);
			}
		}
		
		Action action = behaviour.getAction(this, map);
		if (action != null)
			return action;
		return new DoNothingAction();
	}

}
