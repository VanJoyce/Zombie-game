package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Menu;

/**
 * Class representing the Player.
 */
public class Player extends Human {

	private Menu menu = new Menu();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
	}

	/**
	 * Returns possible actions for this turn.
	 * 
	 * @param actions 		actions that can be performed this turn
	 * @param lastAction 	the last action performed by player
	 * @param map			the map the player is on
	 * @param display		the user interface
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		for (int i=0;i<super.getInventory().size();i++) {
			if (super.getInventory().get(i) instanceof FallenZombiePart) {
				actions.add(new CraftAction((FallenZombiePart) super.getInventory().get(i)));
			}
		}
		
		//Player should be able to interact with the ground they're standing on
		actions.add(map.locationOf(this).getGround().allowableActions(this, map.locationOf(this), ""));
		
		//for(Actions action:this.getAllowableActions(otherActor, direction, map))
		
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		return menu.showMenu(this, actions, display);
	}
	

	
}
