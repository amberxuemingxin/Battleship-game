
public class Destroyer extends Ship {

	/**
	 * construct destroyer
	 */
	public Destroyer() {
		// get the length
		length = 2;

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
		return "Destroyer";
	}

}
