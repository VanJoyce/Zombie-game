package game;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.PickUpItemAction;

public class AmmunitionRifle extends PortableItem implements Ammunition{

	public AmmunitionRifle() {
		super("Riffle Ammunition", ';');
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public PickUpItemAction getPickUpAction() {
		if(portable)
			return new PickUpAmmunitionRifleAction(this);
		
		return null;
	}

	@Override
	public DropItemAction getDropAction() {
		if(portable)
			return new DropAmmunitonRifleAction(this);
		
		return null;
	}

}
