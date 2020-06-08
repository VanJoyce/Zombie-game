package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Action class for player to quit.
 * @author Vanessa
 *
 */
public class QuitAction extends Action{

	@Override
	public String execute(Actor actor, GameMap map) {
		return "";
	}

	@Override
	public String menuDescription(Actor actor) {
		return "Quit the game";
	}
	
	@Override
	public String hotkey() {
		return "0";
	}

}
