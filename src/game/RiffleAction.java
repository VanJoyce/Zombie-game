package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

public class RiffleAction extends Action{
	private Display display;
	private int counter;
	private ArrayList<Integer> aimArray=new ArrayList<Integer>(3);
	
	public RiffleAction(Display display) {
		this.display=display;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
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
