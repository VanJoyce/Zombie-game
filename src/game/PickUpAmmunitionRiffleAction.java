package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.PickUpItemAction;

public class PickUpAmmunitionRiffleAction extends PickUpItemAction {
	public PickUpAmmunitionRiffleAction(AmmunitionRiffle item) {
		super(item);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		((Human)actor).gotAmmunitionRiffle();
		super.execute(actor, map);
		return menuDescription(actor);
	}

}
