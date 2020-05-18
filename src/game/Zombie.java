package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.IntrinsicWeapon;
import edu.monash.fit2099.engine.WeaponItem;

/**
 * A Zombie.
 * 
 * This Zombie is pretty boring.  It needs to be made more interesting.
 * 
 * @author ram
 *
 */
public class Zombie extends ZombieActor {
	private int counter=0;
	private Behaviour[] behaviours = {
			new PickUpItemBehaviour(WeaponItem.class),
			new AttackBehaviour(ZombieCapability.ALIVE),
			new HuntBehaviour(Human.class, 10),
			new WanderBehaviour()
	};
	//	7/5/2020 12.24pm
	
	private ArrayList<String> zombieLimbs= setZombieLimbs();	
	private int noOfHands=2;
	private int noOfLegs=2;
	private int noOfLimbs=4;

	//private ZombieLimbs zombieLimbs=new ZombieLimbs();
	//
	
	public Zombie(String name) {
		super(name, 'Z', 100, ZombieCapability.UNDEAD);
	}
	

	@Override
	public IntrinsicWeapon getIntrinsicWeapon() {
		//
		double biting_chances = Math.random();
		if (biting_chances>=0.5) {
			return new IntrinsicWeapon(15,"bites");
		}
		//
		return new IntrinsicWeapon(10, "punches");
	}

	/**
	 * If a Zombie can attack, it will.  If not, it will chase any human within 10 spaces.  
	 * If no humans are close enough it will wander randomly.
	 * 
	 * @param actions list of possible Actions
	 * @param lastAction previous Action, if it was a multiturn action
	 * @param map the map where the current Zombie is
	 * @param display the Display where the Zombie's utterances will be displayed
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		double say=Math.random();
		if (say<=0.10) {
			System.out.println("Braaaaaains");
		}
		//if zombie got 0 leg
		if(getNoOfLegs()==0) {
			return getActionForNotMoving(map);
		}
		//if zombie got 1 leg
		else if(getNoOfLegs()==1) {
			if (counter%2==0) {
				counter+=1;
				return getActionForMoving(map);
			}
			else {
				counter+=1;
				return getActionForNotMoving(map);
			}
		}
		
		else {
			return getActionForMoving(map);
		}
	}
	public Action getActionForMoving(GameMap map) {
		for (Behaviour behaviour : behaviours) {
			Action action = behaviour.getAction(this, map);
			if (action != null)
				return action;
		}
		return new DoNothingAction();
	}
	
	public Action getActionForNotMoving(GameMap map) {
		for (int i=0;i<2;i++) {
			Action action = behaviours[i].getAction(this, map);
			if (action != null)
				return action;
		}
		return new DoNothingAction();
	}
	
	public ArrayList<String> setZombieLimbs() {
		ArrayList<String> zombieLimb= new ArrayList<String>(4);
		zombieLimb.add("rightHand");
		zombieLimb.add("leftHand");
		zombieLimb.add("rightLeg");
		zombieLimb.add("leftLeg");
		return zombieLimb;
	}
	
	public String loseLimbs() {
		int limbIndex=(int)(Math.random()*((noOfLimbs)-0)+0);
		String limb=zombieLimbs.get(limbIndex);
		zombieLimbs.remove(limbIndex);
		if(limb.substring(limb.length()-4, limb.length()-1).equals("Hand")){
			noOfHands-=1;
			noOfLimbs-=1;
					
		}
		else {
			noOfLegs-=1;
			noOfLimbs-=1;
		}
		return limb;
	}
	
	public int getNoOfHands() {
		return noOfHands;
	}
	
	public int getNoOfLegs() {
		return noOfLegs;
	}
	
	public int getNoOfLimbs() {
		return noOfLimbs;
	}
	
	public void lossLegs() {
		counter+=1;
	}
}
