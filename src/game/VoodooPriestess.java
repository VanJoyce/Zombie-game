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
	private int turnsOnMap = 0;
	private Random rand = new Random();
	
	public VoodooPriestess(String name) {
		super(name, '&', 200, ZombieCapability.UNDEAD);
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		turnsOnMap++;
		if (map.contains(this)) {
			if (turnsOnMap % 10 == 0) {
				return new ChantAction(map);
			}
			if (turnsOnMap == 30) {
				map.removeActor(this);
			}
		} else {
			if (rand.nextDouble() <= 0.05) {
				turnsOnMap = 0;
				//generate random location then add to map;
			}
		}		
		return new DoNothingAction();
	}

}
