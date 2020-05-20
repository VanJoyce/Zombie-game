package game;

/**
 * Class that represents Food. Food objects are items that are created when a Crop is
 * harvested. A human that eats this, can heal damage.
 * @author Vanessa
 *
 */
public class Food extends PortableItem{
	/**
	 * The amount of points this Food object can heal
	 */
	protected int healPoints;
	
	/**
	 * Constructor for Food. displayChar is 'G' and Food can heal.
	 */
	public Food(int healPoints) {
		super("food", 'O');
		this.healPoints = healPoints;
		this.allowableActions.add(new HealAction(this, healPoints));
	}
}
