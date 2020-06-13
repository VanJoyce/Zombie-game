package game;

import java.util.Random;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Weapon;

public class RiffleAttackAction extends AttackAction{
	private SniperRifle rifle;
	private Random rand = new Random();
	
	public RiffleAttackAction(Actor target, RangedWeapon rifle) {
		super(target);
		this.rifle=(SniperRifle)rifle;
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
		return isDead(actor,target,weapon,damage,map);
		
	}
	
	

}
