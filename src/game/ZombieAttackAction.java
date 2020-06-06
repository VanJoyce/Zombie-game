package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;

public class ZombieAttackAction extends AttackAction{

	public ZombieAttackAction(Actor target) {
		super(target);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		Weapon weapon = actor.getWeapon();
		if(weapon.verb().equals("bites")) {
			if(rand.nextDouble()<0.75) { 
				return actor + " misses " + target + ".";
			}
			else {
				actor.heal(5);
			}
		}
		else if(weapon.verb().equals("punches")) {
			if (rand.nextBoolean()) {
				return actor + " misses " + target + ".";
			}
		}
		
		int damage = weapon.damage();
		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
		
		target.hurt(damage);
		
		//super.execute(actor, map);
		
		if (!target.isConscious()) {
			PortableItem corpse;
			if (target instanceof Human) {
				corpse = new HumanCorpse(target.toString(), map);
			} else {
				corpse = new PortableItem("dead" + target.toString(), '%');
			}
			map.locationOf(target).addItem(corpse);
			
			Actions dropActions = new Actions();
			for (Item item : target.getInventory())
				dropActions.add(item.getDropAction());
			for (Action drop : dropActions)		
				drop.execute(target, map);
			map.removeActor(target);	
			
			result += System.lineSeparator() + target + " is killed.";
		}

	return result;

	}
}
