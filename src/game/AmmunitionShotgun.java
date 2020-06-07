package game;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.PickUpItemAction;

public class AmmunitionShotgun  extends PortableItem implements Ammunition{

	public AmmunitionShotgun() {
		super("Shotgun Ammunition", ':');
		// TODO Auto-generated constructor stub
	}
	@Override
	public PickUpItemAction getPickUpAction() {
		if(portable)
			return new PickUpAmmunitionShotgunAction(this);
		
		return null;
	}

	@Override
	public DropItemAction getDropAction() {
		if(portable)
			return new DropAmmunitionShotgunAction(this);
		
		return null;
	}

}
