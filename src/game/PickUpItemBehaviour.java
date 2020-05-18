package game;

import java.util.Collection;
import java.util.Iterator;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.PickUpItemAction;

public class PickUpItemBehaviour implements Behaviour{
	
	private Class<?> pickUpItemClass;
	
	public PickUpItemBehaviour(Class<?> newPickUpItemClass){
		this.pickUpItemClass=newPickUpItemClass;
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		Location location=map.locationOf(actor);
		Collection<Item> items=location.getItems();
		if (items.size()>0){
			for(Item item:items){
				//if the item class is equals or is a subclass to pickUpItemClass
				if (item.getClass().equals(pickUpItemClass) || pickUpItemClass.isAssignableFrom(item.getClass())){
					return new PickUpItemAction(item);
				}
			}
			return null;
		}
		return null;		
	}

}
