package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class DropAmmunitonRiffleAction extends DropItemAction{
	public DropAmmunitonRiffleAction(AmmunitionRiffle item) {
		super(item);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		((Human)actor).noAmmunitionRiffle();
		super.execute(actor, map);
		return menuDescription(actor);
	}
}
