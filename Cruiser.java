
public class Cruiser extends Ship {
	
	/**
	 * construct cruiser
	 */
	public Cruiser() {
		// get the length
		length = 3;

		// get the hit
		hit = new boolean[length];
		for (int i = 0; i < length; i++) {
			hit[i] = false;
		}
	}
	
	/**
	 * get the type of the ship
	 */
	@Override
	public String getShipType() {
		return "Cruiser";
	}

}
