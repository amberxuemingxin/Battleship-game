
public class Submarine extends Ship {

	/**
	 * construct submarine
	 */
	public Submarine() {
		// get the length
		length = 1;

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
		return "Submarine";
	}

}
