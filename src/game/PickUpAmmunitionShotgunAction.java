package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.PickUpItemAction;

public class PickUpAmmunitionShotgunAction extends PickUpItemAction{

	public PickUpAmmunitionShotgunAction(AmmunitionShotgun item) {
		super(item);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		((Human)actor).gotAmmunitionShotgun();
		super.execute(actor, map);
		return menuDescription(actor);
	}

}
