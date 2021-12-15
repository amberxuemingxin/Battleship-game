
public abstract class Ship {

	private int bowColumn;
	private int bowRow;
	private boolean horizontal;
	protected int length;
	protected boolean[] hit;

	
	/**
	 * get the column of the ship
	 * @return the column of the ship
	 */
	public int getBowColumn() {
		return bowColumn;
	}

	/**
	 * get the row of the ship
	 * @return the row of the ship
	 */
	public int getBowRow() {
		return bowRow;
	}
	
	/**
	 * get the length of the ship
	 * @return the length of the ship
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * get the type of the ship
	 * @return the type of the ship
	 */
	public abstract String getShipType();
	
	/**
	 * check if the ship is horizontal
	 * @return true if ship is horizontal, false otherwise.
	 */
	public boolean isHorizontal() {
		return horizontal;
	}
	
	/**
	 * check if the ship is sunk
	 * @return true if the ship is sunk, false otherwise
	 */
	public boolean isSunk() {
		for (int i = 0; i < length; i++) {
			if (!hit[i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * check if it is a good spot to place the ship
	 * @param row the row of the ship
	 * @param column the column of the ship
	 * @param horizontal the orientation of the ship
	 * @param ocean the ocean for the ships.
	 * @return
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		if (row < 0 || column < 0) {
			throw new IllegalArgumentException("Argument has negative value.");
		}
		
		if (horizontal) {
			if (column + length > 10) {
				return false;
			}
			for (int i = Math.max(0, row - 1); i <= Math.min(9, row + 1); i++) {
				for  (int j = Math.max(0, column - 1); j <= Math.min(9, column + length); j++) {
					if (ocean.isOccupied(i, j)) {
						return false;
					}
				}
			}
		} else {
			if (row + length > 10) {
				return false;
			}
			for (int i = Math.max(0, row - 1); i <= Math.min(9, row + length); i++) {
				for  (int j = Math.max(0, column - 1); j <= Math.min(9, column + 1); j++) {
					if (ocean.isOccupied(i, j)) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	/**
	 * place a ship at determined location
	 * @param row the row of the ship
	 * @param column the column of the ship
	 * @param horizontal the orientation of the ship
	 * @param ocean the ocean for the of ships
	 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		setBowRow(row);
		setBowColumn(column);
		setHorizontal(horizontal);
		
		if(horizontal) {
			for(int i = column; i < column + length; i++) {
				ocean.ships[row][i] = this;
			}
		} else {
			for(int i = row; i < row + length; i++) {
				ocean.ships[i][column] = this;
			}
		}
	}
	
	/**
	 * set the ship's column
	 * @param bowColumn the ship's column
	 */
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}
	
	/**
	 * set the ship's row
	 * @param bowRow the ship's row
	 */
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}
	
	/**
	 * set the ship's orientation
	 * @param horizontal the orientation of the ship
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	
	/**
	* If a part of this ship occupies this coordinate, and if the ship hasn't been
	* sunk, mark the part of the ship at that coordinate as "hit".
	*
	* @param row the row of the shot
	* @param column the column of the shot
	* @return {@literal true} if this ship hasn't been sunk and a part of this ship
	* occupies the given <code>row</code> and <code>column</code> and
	* {@literal false} otherwise.
	*/
	public boolean shootAt(int row, int column) {
		if (isSunk()) {
			return false;
		}
		
		if (horizontal) {
			int spot = column - bowColumn;
			if (row == bowRow && spot >= 0 && spot < length) {
				hit[spot] = true;
				return true;
			}
		} else {
			int spot = row - bowRow;
			if (column == bowColumn && spot >= 0 && spot < length) {
				hit[spot] = true;
				return true;
			}
		}
		
		return false;
		
	}
	
	/**
	 * @return  a single character String to use in the Ocean's print method. 
	 * This method should return "x" if the ship has been sunk, 
	 * and "S" if it has not yet been sunk. 
	 * This method can only be used to print out locations in the ocean that have been shot at; 
	 * it should not be used to print locations that have not been the target of a shot yet.
	 */
	public String toString() {
		if (isSunk()) {
			return "x";
		} else {
			return "S";
		}
	}
}
