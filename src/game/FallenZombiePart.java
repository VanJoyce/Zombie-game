package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;

public class FallenZombiePart extends PortableItem{
	private char bodyPartType;
	public FallenZombiePart(String name, char displayChar,char bodyPartType) {
		super(name, displayChar);
		this.bodyPartType=bodyPartType;
		// TODO Auto-generated constructor stub
	}
	
	public List<Action> getAllowableActions() {
		allowableActions.add(new CraftAction(this));
		return allowableActions.getUnmodifiableActionList();
	}
	
	public char getBodyType() {
		return bodyPartType;
	}
	
	public String getName() {
		return name;
	}
	public char getDisplayChar() {
		return displayChar;
	}
}
