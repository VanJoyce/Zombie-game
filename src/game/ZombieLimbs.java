package game;

import java.util.ArrayList;

public class ZombieLimbs {
	private ArrayList<String> zombieLimbs= setZombieLimbs();	
	private int noOfHands=2;
	private int noOfLegs=2;
	private int noOfLimbs=4;
	
	public ArrayList<String> setZombieLimbs() {
		ArrayList<String> zombieLimb= new ArrayList<String>(4);
		zombieLimb.add("rightHand");
		zombieLimb.add("leftHand");
		zombieLimb.add("rightLeg");
		zombieLimb.add("leftLeg");
		return zombieLimb;
	}
	public String loseLimbs() {
		int limbIndex=(int)Math.random()*((noOfLimbs)-0)+0;
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
}
