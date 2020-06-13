package game;

public abstract class Ammunition extends PortableItem{
	private int rounds;
	
	public Ammunition(String name, char displayChar) {
		super(name, displayChar);
		rounds = 10;
	}
	
	public int getRounds() {
		return rounds;
	}
	
	public void shotFired() {
		rounds -= 1;
	}
}
