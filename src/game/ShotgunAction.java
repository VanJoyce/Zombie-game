package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Menu;

public class ShotgunAction extends Action{
		Menu submenu = new Menu();
		Display display;
		Actions shootDirections = new Actions();
		
		public ShotgunAction(Display display) {
			this.display = display;
		}
		
		@Override
		public String execute(Actor actor, GameMap map) {
			List<Exit> exits = new ArrayList<Exit>(map.locationOf(actor).getExits());
			
			for (Exit e: exits) {
				shootDirections.add(new FireShotgunAction(e));
			}
			Action action = submenu.showMenu(actor, shootDirections, display);
			return action.execute(actor, map);
		}

		@Override
		public String menuDescription(Actor actor) {
			return actor + " fires the shotgun";
		}
}
