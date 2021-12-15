
public class Battleship extends Ship {

	/**
	 * construct battleship
	 */
	public Battleship() {
		// get the length
		length = 4;
		
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
		return "Battleship";
	}

}
