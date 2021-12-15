
public class EmptySea extends Ship {
	
	/**
	 * construct the empty sea
	 */
	public EmptySea() {
		// get the length
		// An empty tile is an emptySea object
		length = 1;

		// get the hit
		hit = new boolean[length];
		for (int i = 0; i < length; i++) {
			hit[i] = false;
		}
	}
	
	/**
	 * get the type of ship
	 */
	@Override
	public String getShipType() {
		return "Empty";
	}
	
	@Override
    public String toString(){
        if(isSunk()){
            return "-";
        }else{
            return ".";
        }
    }
}
