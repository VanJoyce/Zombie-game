package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.MoveActorAction;

public class Vehicle extends Item{

	public Vehicle(String name, char displayChar) {
		super(name, displayChar, false);
		// TODO Auto-generated constructor stub
	}
	
	public void addAction(Action action) {
		this.allowableActions.add(action);
	}
	
}
