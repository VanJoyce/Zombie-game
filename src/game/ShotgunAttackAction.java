package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Weapon;

public class ShotgunAttackAction extends AttackAction{

	public ShotgunAttackAction(Actor target) {
		super(target);
	}
	
	public String execute(Actor actor, GameMap map,Weapon weapon) {
		int damage = weapon.damage();
		return isDead(actor,target,weapon,damage,map);
	}
}
