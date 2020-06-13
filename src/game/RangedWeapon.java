package game;

import edu.monash.fit2099.engine.WeaponItem;

public abstract class RangedWeapon extends WeaponItem{	
	public RangedWeapon(String name, char displayChar) {
		super(name, displayChar, 10, "uses the " + name + " to ");
		this.addCapability(RangedWeaponCapability.WHACK);
	}
	
	@Override
	public int damage() {
		if (this.hasCapability(RangedWeaponCapability.SHOOT)){
			return 15;
		} else {
			return 10;
		}
	}
	
	@Override
	public String verb() {
		if (this.hasCapability(RangedWeaponCapability.SHOOT)) {
			return super.verb() + "shoot";
		} else {
			return super.verb() + "whack";
		}
	}
		
}
