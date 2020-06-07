package game;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.PickUpItemAction;

public class AmmunitionRiffle extends PortableItem implements Ammunition{

	public AmmunitionRiffle() {
		super("Riffle Ammunition", ';');
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public PickUpItemAction getPickUpAction() {
		if(portable)
			return new PickUpAmmunitionRiffleAction(this);
		
		return null;
	}

	@Override
	public DropItemAction getDropAction() {
		if(portable)
			return new DropAmmunitonRiffleAction(this);
		
		return null;
	}

}
