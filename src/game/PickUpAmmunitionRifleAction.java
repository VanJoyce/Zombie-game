package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.PickUpItemAction;

public class PickUpAmmunitionRifleAction extends PickUpItemAction {
	public PickUpAmmunitionRifleAction(AmmunitionRifle item) {
		super(item);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		((Human)actor).gotAmmunitionRifle();
		super.execute(actor, map);
		return menuDescription(actor);
	}

}
