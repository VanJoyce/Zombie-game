package game;

import java.util.Random;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;

/** Class representing the whole world of the Zombie game.
 * 
 * @author Vanessa
 *
 */
public class ZombieWorld extends World {
	private GameStatus currentStatus = GameStatus.RUNNING;
	private VoodooPriestess mamboMarie = new VoodooPriestess("Mambo Marie");
	private Random rand = new Random();

	public ZombieWorld(Display display) {
		super(display);
	}
	
	@Override
	public void run() {
		if (player == null)
			throw new IllegalStateException();

		// initialize the last action map to nothing actions;
		for (Actor actor : actorLocations) {
			lastActionMap.put(actor, new DoNothingAction());
		}

		// This loop is basically the whole game
		while (stillRunning()) {
			GameMap playersMap = actorLocations.locationOf(player).map();
			playersMap.draw(display);
			
			// Process all the actors.
			for (Actor actor : actorLocations) {
				if (stillRunning())
					processActorTurn(actor);
			}
			
			//Add Mambo Marie to the gameMap
			if(!actorLocations.contains(mamboMarie) && rand.nextDouble() <= 0.05) {
				GameMap map = actorLocations.locationOf(player).map();
				int x = 0;
				int y = 0;
				while (!map.at(x, y).canActorEnter(mamboMarie)) {
					x++;
				};
				map.at(x, y).addActor(mamboMarie);
			}
			
			// Tick over all the maps. For the map stuff.
			for (GameMap gameMap : gameMaps) {
				gameMap.tick();
			}

		}
		display.println(endGameMessage());
	}
	
	/**
	 * Checks if the player has won lost or maybe quit the game.
	 */
	@Override
	protected boolean stillRunning() {
		if (actorLocations.contains(player)) {			
			int humans = 0;
			int zombies = 0;
			for (Actor actor : actorLocations) {
				if (actor instanceof Player){
					continue;
				} else if (actor instanceof Human) {
					humans++;
				} else if (actor instanceof Zombie) {
					zombies++;
				}
			}
			
			if (humans == 0) {
				currentStatus = GameStatus.LOST;
				return false;
			} else if (zombies == 0 && !mamboMarie.isConscious()) {
				currentStatus = GameStatus.WON;
				return false;
			}	// to check quit maybe add something to player menu. Maybe need an action.
			return true;
		}
		currentStatus = GameStatus.LOST;
		return false;
	}
	
	@Override
	protected String endGameMessage() {
		if (currentStatus == GameStatus.LOST) {
			return "GAME OVER. MAMBO MARIE AND THE ZOMBIES HAVE TAKEN OVER THE WORLD.";
		} else if (currentStatus == GameStatus.WON) {
			return "CONGRATULATIONS, YOU HAVE WON THE GAME! THE COMPOUND IS NOW SAFE THANKS TO YOU.";
		} else if (currentStatus == GameStatus.QUIT) {
			return "You have quit the game.";
		} else {
			throw new Error("The game is still running but player has not lost, won or quit.");
		}
	}
	
	private enum GameStatus {
		RUNNING, QUIT, LOST, WON
	}
}
