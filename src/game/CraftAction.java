package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class CraftAction extends Action{
	
	private FallenZombiePart zombieLimb;
	
	public CraftAction(FallenZombiePart zombieLimb) {
		this.zombieLimb=zombieLimb;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		actor.removeItemFromInventory(zombieLimb);
		if(zombieLimb.getBodyType()=='H'){
			actor.addItemToInventory(new ZombieClubs(zombieLimb.getName()+" Weapon"));
		}
		else if(zombieLimb.getBodyType()=='L'){
			actor.addItemToInventory(new ZombieMace(zombieLimb.getName()+" Weapon"));
		}
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" creates new Weapon: "+ zombieLimb.getName()+" Weapon";
	}

}
