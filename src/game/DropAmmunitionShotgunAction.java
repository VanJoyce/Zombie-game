package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.GameMap;

public class DropAmmunitionShotgunAction extends DropItemAction{
	public DropAmmunitionShotgunAction(AmmunitionShotgun item) {
		super(item);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		((Human)actor).noAmmunitionShotgun();
		super.execute(actor, map);
		return menuDescription(actor);
	}
}