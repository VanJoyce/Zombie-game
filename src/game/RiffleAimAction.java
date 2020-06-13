package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Weapon;

public class RiffleAimAction extends Action{

	private Actor target;
	
	private RangedWeapon rifle;
	
	
	public RiffleAimAction(Actor target, RangedWeapon rifle) {
		// TODO Auto-generated constructor stub
		this.target=target;
		this.rifle=rifle;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		((SniperRifle)rifle).aim(target);
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor +" aims at "+target;
	}

}
