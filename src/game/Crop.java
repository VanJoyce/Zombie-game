package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;

/**
 * Class that represents a crop. It can grow.
 * @author Vanessa
 *
 */
public class Crop extends GrowableGround{
	static final char YOUNG_DISPLAY = '=';
	static final char MID_DISPLAY = '<';
	static final char OLD_DISPLAY = '*';
	
	/**
	 * Constructs a crop.
	 */
	public Crop() {
		super(YOUNG_DISPLAY);
	}
	
	/**
	 * As the crop ripens, its display character changes.
	 * 
	 * @param location the location of the crop
	 */
	@Override
	public void tick(Location location) {
		super.tick(location, MID_DISPLAY, OLD_DISPLAY);
	}
	
	/**
	 * Crop can be fertilized if unripe and actor is Farmer. It can be harvested if 
	 * it's ripe and actor is either Farmer or Player.
	 * 
	 * @param actor the actor acting
	 * @param location the location of the crop
	 * @param direction the direction of the crop from actor
	 * @return an action that can be done unto the crop at the moment.
	 */
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction) {
		if (this.getAge() > 20 && actor instanceof Player) {
			return new Actions(new HarvestAction(location));
		}
		
//		if (displayChar == YOUNG_DISPLAY || displayChar == MID_DISPLAY) {
//			if(actor.getClass() == Farmer.class) {
//				return new Actions(new FertilizeAction(location));
//			}
//		} else {
//			if (actor.getClass() == Farmer.class || actor.getClass() == Player.class) {
//				return new Actions(new HarvestAction(location));
//			}
//		}
		return new Actions();
	}
}