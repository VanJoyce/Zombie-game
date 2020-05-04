package game;

import java.util.ArrayList;

public class ZombieLimbs {
	private ArrayList<String> zombieLimbs= {"rightHand","leftHand","rightLeg","leftLeg"};
	private int noOfHands=2;
	private int noOfLegs=2;
	private int noOfLimbs=4;
	
	public void loseLimbs() {
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
		
	}
			
	
}
