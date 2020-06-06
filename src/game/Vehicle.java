package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
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
	public void addMoveAction(GameMap map,int x,int y,Actor actor,String direction) {
		System.out.println ((map.contains(actor)) );
		if(!map.contains(actor)) {
			this.allowableActions.add(new MoveActorAction(map.at(x, y),direction));
		}
	}
	//car.addMoveAction(ghostTown,79,24,player,"to GhostTown!");
	//car.addAction(new MoveActorAction(ghostTown.at(79,24), "to GhostTown!"));
}
