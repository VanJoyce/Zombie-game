package game;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class RangeAttackAction {
	Human actor;
	GameMap map;
	
	public RangeAttackAction(Human actor,GameMap map) {
		this.actor=actor;
		this.map=map;
	}
	
	public String execute(Actor actor, GameMap map) {
		map.locationOf(actor);
		return null;
	}

}
