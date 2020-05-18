package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;

/**
 * Special Action for attacking other Actors.
 */
public class AttackAction extends Action {

	/**
	 * The Actor that is to be attacked
	 */
	protected Actor target;
	/**
	 * Random number generator
	 */
	protected Random rand = new Random();

	/**
	 * Constructor.
	 * 
	 * @param target the Actor to attack
	 */
	public AttackAction(Actor target) {
		this.target = target;
	}

	@Override
	public String execute(Actor actor, GameMap map) {

		Weapon weapon = actor.getWeapon();
		//made by jaclyn
		//Zombie
		if(actor.getClass()==Zombie.class) {
			if(weapon.verb().equals("bites")) {
				if(rand.nextDouble()<0.75) {
					return actor + " misses " + target + ".";
				}
				else {
					actor.heal(5);
				}
			}
			else if(weapon.verb().equals("punches")) {
				if (((Zombie)actor).getNoOfHands()==0) {
					return actor + " misses " + target + ".";
				}
				else if (((Zombie)actor).getNoOfHands()==1) {
					if(rand.nextDouble()<0.75) {
						return actor + " misses " + target + ".";
					}
				}
				else if (((Zombie)actor).getNoOfHands()==2) {
					if (rand.nextBoolean()) {
						return actor + " misses " + target + ".";
					}
				}
			}
		}
			
		//Human
		else {
			if (rand.nextBoolean()){
				return actor + " misses " + target + ".";
			}
			else {
				if(rand.nextDouble()<=0.25 & ((Zombie) target).getNoOfLimbs()>0) {
					String limb=((Zombie) target).loseLimbs();
					System.out.println(target+" loses "+limb);
						
					//if limb=hand
					if(limb.substring(limb.length()-4, limb.length()-1).equals("Hand")) {
						
						Item hand = new PortableItem("zombieHand " + target, 'H');
						map.locationOf(target).addItem(hand);
						
						//50% drop of item
						if (((Zombie) target).getNoOfHands()==1) {
							if(rand.nextDouble()>0.5) {
								int size=((Zombie)target).getInventory().size();
								((Zombie) target).removeItemFromInventory(((Zombie)target).getInventory().get(rand.nextInt(size)));
							}
						}
						//100% drop of item
						else {
							for(Item item:target.getInventory()) {
								((Zombie) target).removeItemFromInventory(item);
							}
						}
					}

					//if limb=leg
					else {
						Item leg = new PortableItem("zombieLeg " + target, 'L');
						map.locationOf(target).addItem(leg);
						((Zombie) target).lossLegs();
					}
				}
			}
		}
		//

		int damage = weapon.damage();
		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
		
		target.hurt(damage);

		if (!target.isConscious()) {
			Item corpse = new PortableItem("dead " + target, '%');
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

	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target;
	}
}
