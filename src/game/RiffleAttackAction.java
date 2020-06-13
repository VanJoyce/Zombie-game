package game;

import java.util.Random;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Weapon;
/**This class represents the attack when player(or any actors that is using rifle) decides to shoot the zombies/
 * 
 * @author Jaclyn
 *
 */
public class RiffleAttackAction extends AttackAction{
	private SniperRifle rifle;
	private Random rand = new Random();
	private Ammunition ammo;
	
	/**
	 * 
	 * @param target the actor getting shot
	 * @param rifle the weapon itself
	 * @param ammo the ammunition
	 */
	public RiffleAttackAction(Actor target, RangedWeapon rifle, Ammunition ammo) {
		super(target);
		this.rifle=(SniperRifle)rifle;
		this.ammo = ammo;
		rifle.addCapability(RangedWeaponCapability.SHOOT);
	}
	
	/**
	 * If the aim is 0, there's the usual success percentage of a successful attack with usual amount of damage.
	 * If the aim is 1, there's a 90 success percentage chances of a successful attack with a double damage.
	 * If the aim is 2, it is certain that it is a successful attack with a instant kill.
	 * When the ammo hits 0, ammo is remove from the inventory.
	 */
	public String execute(Actor actor, GameMap map,Weapon weapon) {
		int aim=rifle.getAim();
		HumanAttackAction attack=new HumanAttackAction(target);

		if(aim==0) {
			attack.execute(actor,map,rifle, 0.5);
		}
		if(aim==1) {
			attack.execute(actor,map,rifle, 0.9);
		}
		if(aim==2) {
			attack.execute(actor,map,rifle, 1);
		}
		
		int damage = weapon.damage();
		rifle.reset();
		String result =  isDead(actor,target,weapon,damage,map);
		
		ammo.shotFired();
		if (ammo.getRounds() == 0) {
			actor.removeItemFromInventory(ammo);		
			result += "\nThis ammunition has no more rounds.";
		}
		
		return result;
		
	}
	
	

}
