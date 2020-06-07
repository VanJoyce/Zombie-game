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
	
	/**
	 * @param actor is the actor
	 * @param map is the Gamemap
	 * 
	 * If the actor is a zombie, it will either have a chance to punch or to bite. If a successful bite occurs, the
	 * zombie heals by 5 points. 
	 * 
	 *  If the actor is a human(which is the player), it will first determine the number of limbs the target(zombie) has.
	 *  If the zombie has more than 0 limbs, a random generator is used to determine whether the zombie will lose its limbs or not.
	 *  If so,loseLimbs() is then called to make the zombie loss limbs.
	 *  The limb that the zombie lose will then be a new FallenZombiePart and it will be added to the map.
	 *  If the zombie loses its arms and has one arm left, it may lose one of its item in its inventory.
	 *  If the zombie loses its arms and has no arm left, it will lose all its item in its inventory.
	 *  If the zombie loses its leg and has one leg left, its movement will be halved.
	 *  If the zombie loses its leg and has no leg left, it cannot move at all though it can still bite or punch.
	 *  The movement control of the zombie is done in the zombie's playAction().
	 *  
	 *  
	 *  
	 *  
	 */
	
	@Override
	public String execute(Actor actor, GameMap map) {

		Weapon weapon = actor.getWeapon();
		System.out.print("Hello from attackaction!");
		if (rand.nextBoolean()) {
			return actor + " misses " + target + ".";
		}
		int damage = weapon.damage();
		
		return isDead(actor,target,weapon,damage,map);
	}
	
	
	public String isDead(Actor actor,Actor target,Weapon weapon, int damage,GameMap map) {
		
		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
		
		target.hurt(damage);

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
		
		/*
		 * 		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
		
		target.hurt(damage);

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
		 */
		
	

	/*
	@Override
	public String execute(Actor actor, GameMap map) {

		Weapon weapon = actor.getWeapon();
		if(actor instanceof Zombie) {
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
		}
			
		//Human
		else {
			if (rand.nextBoolean()){
				return actor + " misses " + target + ".";
			}
			else {
				if(rand.nextDouble()<=0.25 & ((Zombie) target).getNoOfLimbs()>0) {
					String limb;
					try {
						limb = ((Zombie) target).loseLimbs();
					
						System.out.println(target+" loses "+limb);
						
						//if limb=hand
						if(((Zombie)target).isHand(limb)) {
						//if(limb.substring(limb.length()-4, limb.length()).equals("Hand")) {
						
							Item hand = new FallenZombiePart(target + " " + limb, 'h','H');
							map.locationOf(target).addItem(hand);
						
							//50% drop of item
							if (((Zombie) target).getNoOfHands()==1) {
								if(rand.nextDouble()>0.5 && target.getInventory().size()>0) {
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
							Item leg = new FallenZombiePart(target+ " " + limb, 'l','L');
							map.locationOf(target).addItem(leg);
							((Zombie) target).lossLegs();
						}
					}
			
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		//

		int damage = weapon.damage();
		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
		
		target.hurt(damage);

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
	
	*/

	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target;
	}
}
