package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;

public class HumanAttackAction extends AttackAction{

	public HumanAttackAction(Actor target) {
		super(target);
		// TODO Auto-generated constructor stub
	}
	
	public String execute(Actor actor,GameMap map) {
		Weapon weapon = actor.getWeapon();
		return execute(actor,map,weapon);
	}
	
	public String execute(Actor actor,GameMap map,Weapon weapon) {
		if (rand.nextBoolean()){
			return actor + " misses " + target + ".";
		}
		else {
			if(target instanceof Zombie) {
				if(rand.nextDouble()<=0.33 & ((Zombie) target).getNoOfLimbs()>0) {
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
	return super.isDead(actor, target, weapon, damage, map);
	}

}
