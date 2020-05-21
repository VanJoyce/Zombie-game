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

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		//
		for (int i=0;i<super.getInventory().size();i++) {
			if (super.getInventory().get(i) instanceof FallenZombiePart) {
				actions.add(new CraftAction((FallenZombiePart) super.getInventory().get(i)));
			}
		}
		//
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		return menu.showMenu(this, actions, display);
	}
	/*
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		System.out.println("checker"+otherActor);
		Actions list = super.getAllowableActions(otherActor, direction, map);
		List<Item> inventory= super.getInventory();
		for(Item item:inventory) {
			System.out.println(item.getClass());
			if(item.getClass().equals(FallenZombiePart.class)) {
				System.out.println("Hello");
				list.add(new CraftAction((FallenZombiePart) item));
			}
		}
		return list;
	}
	*/
}
