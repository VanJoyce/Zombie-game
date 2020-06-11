package game;

import java.util.List;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class ShotgunAttack extends Action{
	protected Random rand = new Random();
	protected Display display;
	//direction coordinate
	
	/*	^
	 *  1|        * * *
	 * 	2| 		  * * *
	 * 	3| 		  * * *	
	 * 	4|		x
	 * 	5|
	 * 	6| 
	 *  7|_ _ _ _ _ _ _
	 *    1 2 3 4 5 6 7
	 */
	int [][] north=new int[][] {{ 0,-1},{-1,-1},{-1, 0},{-1, 1},{-2,-2},{-2,-1},{-2, 0},{-2, 1},{-2, 2}};
	int [][] south=new int[][] {{ 0,-1},{ 1,-1},{ 1, 0},{ 1, 1},{ 2,-2},{ 2,-1},{ 2, 0},{ 2, 1},{ 2, 2}};
	int [][] west =new int[][] {{-1, 0},{-2,-1},{-2, 0},{-2, 1},{-3,-2},{-3,-1},{-3, 0},{-3, 1},{-3, 2}};
	int [][] east =new int[][] {{ 1, 0},{ 2,-1},{ 2, 0},{ 2, 1},{ 3,-2},{ 3,-1},{ 3, 0},{ 3, 1},{ 3, 2}};
	
	int [][] nh_wt=new int[][] {{-3,-3},{-3,-2},{-3,-1},{-2,-3},{-2,-2},{-2,-1},{-1,-3},{-1,-2},{-1,-1}};
	int [][] nh_et=new int[][] {{ 3,-3},{ 3,-2},{ 3,-1},{ 2,-3},{ 2,-2},{ 2,-1},{ 1,-3},{ 1,-2},{ 1,-1}};
	int [][] sh_wt=new int[][] {{-3, 3},{-3, 2},{-3, 1},{-2, 3},{-2, 2},{-2, 1},{-1, 3},{-1, 2},{-1, 1}};
	int [][] sh_et=new int[][] {{ 3, 3},{ 3, 2},{ 3, 1},{ 2, 3},{ 2, 2},{ 2, 1},{ 1, 3},{ 1, 2},{ 1, 1}};
	
	int [][][] direction = new int[][][] {north,south,west,east,nh_wt,nh_et,sh_wt,sh_et};
	
	public ShotgunAttack(Display display) {
		this.display=display;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		//for every direction
		//for(int[][] direct:direction){
			
		
			//call direction. List<Location> getLocationInDirection
			// List<Location> location = //direction.getLocationInDirection;
			
			//if all actor's got the same percentage of getting hit
			//add the double here: Double getDouble=rand.nextDouble();
			
			//for each location
			/*
			for (Location point:location){
				if location.containsAnActor(){
				
					//if all actor dont have the same percentage of getting hit: add double here
					 Double getDouble=rand.nextDouble();
					  
					 if (getDouble>0.75){
					    Actor target=location.getActor();
					    
					    if no zombie limbs are falling out, then:
					    ShotgunAttackAction attack=new ShotgunAttackAction(target);
					    
					    ////
					    if (target.isInstance(Zombie.class)){
					    	ZombieAttackAction attack=new ZombieAttackAction(target);
					    }
					    
						else{
							AttackAction attack=new ShotgunAttackAction(target);
						}
						/////
						result=attack.execute(actor, map);
					    display.println(result);
					      
					}
	
				}
		
			}
		}
		*/
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

}
