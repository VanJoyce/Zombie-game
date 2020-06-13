package game;

import java.util.Random;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Weapon;

public class RiffleAttackAction extends AttackAction{
	private SniperRifle rifle;
	private Random rand = new Random();
	private Ammunition ammo;
	
	public RiffleAttackAction(Actor target, RangedWeapon rifle, Ammunition ammo) {
		super(target);
		this.rifle=(SniperRifle)rifle;
		this.ammo = ammo;
		rifle.addCapability(RangedWeaponCapability.SHOOT);
	}
	
	
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
