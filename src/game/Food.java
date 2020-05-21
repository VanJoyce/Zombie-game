package game;

/**
 * Class that represents Food. Food objects are items that are created when a Crop is
 * harvested. A human that eats this, can heal damage.
 * @author Vanessa
 *
 */
public class Food extends PortableItem{
	protected int healPoints;
	
	/**
	 * Constructor for Food. Food can heal.
	 * 
	 * @param healPoints the number of points this food can heal
	 */
	public Food(int healPoints) {
		super("food", 'o');
		this.healPoints = healPoints;
		this.allowableActions.add(new HealAction(this, healPoints));
	}
}
