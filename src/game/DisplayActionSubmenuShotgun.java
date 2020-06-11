package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;

public class DisplayActionSubmenuShotgun extends Action{

	private Menu subMenu;
	private Display display;
	private Actions subMenuActions;
	private Class<?> weaponType;
	
	
	public DisplayActionSubmenuShotgun(Class<?> weaponType) {
		this.weaponType=weaponType;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		if (weaponType.isInstance(Shotgun.class)){
		subMenuActions.add(new ShotgunAttack(display));//shotgun special attack
		}
		/*
		if (weaponType.isInstance(SniperRifle.class)){
			subMenuActions.add(new RiffleAttack(display));//rifle special attack);
		}
		*/
		System.out.println(menuDescription(actor));
		//u want a new list of actions to display
		subMenu.showMenu(actor, subMenuActions, display);
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

}
