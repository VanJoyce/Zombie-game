package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Actor;

public class SniperRifle extends RangedWeapon{
	
	private int aiming=0;
	private ArrayList<Actor> aimArray=new ArrayList<Actor>(3);
	
	public SniperRifle() {
		super("SniperRifle", '}');
		// TODO Auto-generated constructor stub
	}
	
	public void aim(Actor target) {
		if (aimArray.size()!=0 && target==aimArray.get(aimArray.size()-1)) {
			aiming+=1;
		}
		else {
			aimArray.clear();
			aimArray.add(target);
			aiming=1;
		}
	}
	
	public int getAim() {return aiming;}
	public Actor getCurrentTarget() {return aimArray.get(aimArray.size()-1);}
	public int getDamage() {
		if(aiming==0) {return this.damage();}
		else if(aiming==1) {return this.damage()*2;}
		else {return 100;}
	}
	
	public void reset() {
		
	}

}
