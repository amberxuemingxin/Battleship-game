import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class ShipTest {
	@Test
	void testGetBowColumn() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		battleship.placeShipAt(0, 0, false, ocean);
		assertEquals(0, battleship.getBowColumn());
	}
	
	@Test
	void testGetBowRow() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		battleship.placeShipAt(0, 0, false, ocean);
		assertEquals(0, battleship.getBowRow());
	}
	
	@Test
	void testGetLength() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		battleship.placeShipAt(0, 0, false, ocean);
		assertEquals(4, battleship.getLength());
	}
	
	@Test
	void testGetShipType() {
		Battleship battleship = new Battleship();
		assertEquals("Battleship", battleship.getShipType());
	}
	
	@Test
	void testIsHorizontal() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		battleship.placeShipAt(0, 0, false, ocean);
		assertEquals(false, battleship.isHorizontal());
	}
	
	@Test
	void testIsSunk() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		battleship.placeShipAt(0, 0, false, ocean);
		
		assertEquals(true, battleship.shootAt(0, 0));
		assertEquals(true, battleship.shootAt(1, 0));
		assertEquals(true, battleship.shootAt(2, 0));
		assertEquals(true, battleship.shootAt(3, 0));
		assertEquals(true, battleship.isSunk());
	}
	
	
	@Test
	void testIsOkToPlaceShipAt() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		
		assertEquals(true, battleship.okToPlaceShipAt(0, 0, false, ocean));
		assertEquals(false, battleship.okToPlaceShipAt(1, 9, true, ocean));

	}
	

	@Test
	void testPlaceShipAt() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		
		battleship.placeShipAt(0, 0, false, ocean);

		assertEquals(0, ocean.ships[0][0].getBowColumn());
		assertEquals(0, ocean.ships[0][0].getBowRow());
		assertEquals(false, ocean.ships[0][0].isHorizontal());
		assertEquals(4, ocean.ships[0][0].getLength());
		assertEquals("Battleship", ocean.ships[0][0].getShipType());
	}
	
	@Test
	void testSetBowColumn() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		battleship.placeShipAt(0, 0, false, ocean);
		battleship.setBowColumn(1);
		assertEquals(1, battleship.getBowColumn());
	}
	
	@Test
	void testSetBowRow() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		battleship.placeShipAt(0, 0, false, ocean);
		battleship.setBowRow(1);
		assertEquals(1, battleship.getBowRow());
	}
	
	@Test
	void testSetHorizontal() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		battleship.placeShipAt(0, 0, false, ocean);
		battleship.setHorizontal(true);
		assertEquals(true, battleship.isHorizontal());
	}
	

	@Test
	void testShootAt() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		
		battleship.placeShipAt(0, 0, false, ocean);
		
		assertEquals(true, battleship.shootAt(0, 0));
		assertEquals(true, battleship.shootAt(1, 0));
		assertEquals(true, battleship.shootAt(2, 0));
		assertEquals(true, battleship.shootAt(3, 0));
		assertEquals(false, battleship.shootAt(0, 0));
		assertEquals(false, battleship.shootAt(4, 5));
	}

	@Test
	void testToString() {
		Battleship battleship = new Battleship();
		Ocean ocean = new Ocean();
		battleship.placeShipAt(0, 0, true, ocean);
		assertEquals("S", battleship.toString());

		battleship.shootAt(0, 0);
		battleship.shootAt(0, 1);
		battleship.shootAt(0, 2);
		battleship.shootAt(0, 3);

		assertEquals(true, battleship.isSunk());
		assertEquals("x", battleship.toString());
	}

}
