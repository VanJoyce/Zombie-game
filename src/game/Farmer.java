package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;

/**
 * Class representing a farmer (human with farming abilities).
 * @author Vanessa
 *
 */
public class Farmer extends Human{
	private Behaviour[] behaviours = {
			new PickUpItemBehaviour(Food.class),
			new HarvestBehaviour(),
			new FertilizeBehaviour(),
			new SowBehaviour(),
			new WanderBehaviour()
	};
	
	/**
	 * Constructor to create a Farmer
	 * 
	 * @param name the farmer's display name
	 */
	public Farmer(String name) {
		super(name, 'F', 80);
	}

	/**
	 * If Farmer can harvest, they should. If there is nothing to harvest nearby, the Farmer 
	 * should fertilize the unripe crop they are standing on. If the Farmer is not standing on 
	 * a crop, they should sow a crop on an adjacent patch of dirt.
	 * Otherwise, the farmer should wander.
	 * 
	 * @param actions list of possible Actions
	 * @param lastAction previous Action, if it was a multiturn action
	 * @param map the map where the current Farmer is
	 * @param display the Display where the Farmer's actions are shown
	 */
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		for (Behaviour behaviour : behaviours) {
			Action action = behaviour.getAction(this, map);
			if (action != null)
				return action;
		}
		return new DoNothingAction();
	}
}
