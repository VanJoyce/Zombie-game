package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

public class RiffleAction extends Action{
	private Actor target;
	private int aiming;
	private ArrayList<Actor> aimArray=new ArrayList<Actor>(3);
	
	public RiffleAction(Actor target) {
		this.target=target;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		String result="";
		if(target==aimArray.get(aimArray.size()-1)) {
			if()
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void reset() {
		counter=0;
		
	}
	
	private void arrayReset() {
		
	}

}
