package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;

/**
 * Class representing an ordinary human.
 * 
 * 
 * @author ram
 *
 */
public class Human extends ZombieActor {
	
	private boolean hasAmmunitionRifle=false;
	private boolean hasAmmunitionShotgun=false;
	
	private Behaviour[] behaviours = {
			new PickUpItemBehaviour(Food.class),
			new WanderBehaviour()
	};

	/**
	 * The default constructor creates default Humans
	 * 
	 * @param name the human's display name
	 */
	public Human(String name) {
		super(name, 'H', 50, ZombieCapability.ALIVE);
	}
	
	/**
	 * The protected constructor can be used to create subtypes
	 * of Human, such as the Player
	 * 
	 * @param name the human's display name
	 * @param displayChar character that will represent the Human in the map 
	 * @param hitPoints amount of damage that the Human can take before it dies
	 */
	protected Human(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints, ZombieCapability.ALIVE);
	}

	/**
	 * Returns an action for one of its behaviours.
	 * 
	 * @param actions		list of actions the human can do
	 * @param lastAction	the previous action done by this human
	 * @param map			the map the human is on
	 * @param display		the user interface to show what action was done
	 * @return				the Action that the actor does this turn
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// FIXME humans are pretty dumb, maybe they should at least run away from zombies?		
		return chooseAction(map, behaviours);
	}
	
	/**
	 * If human is damaged, heal by eating food if there is any in inventory. Otherwise, loop
	 * through list of behaviours to choose an Action.
	 * 
	 * @param map			the map this is done on
	 * @param behaviours	a list of behaviours the human has
	 * @return				an action to be done
	 */
	protected Action chooseAction(GameMap map, Behaviour[] behaviours) {
		// If damaged, eat food if there is any in inventory
		if (this.hitPoints < this.maxHitPoints) {
			for (Item item : this.getInventory()) {
				if (item instanceof Food) {
					return ((Food) item).eat();
				}
			}
		}
		for (Behaviour behaviour : behaviours) {
			Action action = behaviour.getAction(this, map);
			if (action != null)
				return action;
		}
		return new DoNothingAction();
	}
	
	
	@Override
	public Weapon getWeapon() {
		Weapon weapon=highestDamageWeapon();
		if(weapon!=null) {
			return weapon;
		}
		return getIntrinsicWeapon();
	}
	
	
	private Weapon highestDamageWeapon() {
		int damage=0;
		Weapon weapon=null;
		for(Item item:inventory) {
			if(item.asWeapon()!=null)
				if(((Weapon)item).damage()>damage){
				weapon=item.asWeapon();
				damage=((Weapon)item).damage();
				}
		}
		return weapon;
	}
	
	
	public void gotAmmunitionRifle() {
		hasAmmunitionRifle=true;
	}
	
	public void gotAmmunitionShotgun() {
		hasAmmunitionShotgun=true;
	}
	
	public void noAmmunitionShotgun() {
		hasAmmunitionShotgun=false;
	}
	
	public void noAmmunitionRifle() {
		hasAmmunitionRifle=false;
	}
	private boolean containAmmunitionShotgun() {
		return hasAmmunitionShotgun;
	}
	private boolean containAmmunitionRifle() {
		return hasAmmunitionRifle;
	}
}
