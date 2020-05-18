package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class CraftAction extends Action{
	public CraftAction(FallenZombiePart zombieLimb) {}

	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		List<Item> inventory=actor.getInventory();
		for(Item item:inventory) {
			if(item.getClass().equals(FallenZombiePart.class)){
				actor.removeItemFromInventory(item);
				if(((FallenZombiePart)item).getBodyType()=='H'){
					((Actor) inventory).addItemToInventory(new ZombieClub(item.name+" Weapon",item.displayChar,15,"whacks"))
				}
				else if(((FallenZombiePart)item).getBodyType()=='L'){
					((Actor) inventory).addItemToInventory(new ZombieMaze(item.name+" Weapon",item.displayChar,15,"whacks"))
				}
			}
		}
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

}
