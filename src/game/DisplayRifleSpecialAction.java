package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;

public class DisplayRifleSpecialAction extends Action{
	
	private Menu submenu = new Menu();
	private Display display;
	private Actions chooseAction = new Actions();
	private RangedWeapon rifle;
	private Ammunition ammo;
	private Actor target;
	
	public DisplayRifleSpecialAction(Actor target,RangedWeapon rifle,Ammunition ammo) {
		this.target=target;
	}
	
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		chooseAction.add(new RifleAimAction(target,rifle));
		chooseAction.add(new RifleAttackAction(target,rifle, ammo));
		return null;
	}
	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return "Choose "+target;
	}
	
	
	

}
