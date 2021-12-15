import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class OceanTest {
	@Test
	void testIsOccupied() {
		Ocean ocean = new Ocean();
		assertEquals(false, ocean.isOccupied(6, 3));
	}
	
	@Test
	void testShootAt() {
		Ocean ocean = new Ocean();
		assertEquals(!ocean.ships[0][0].getShipType().equals("Empty"), ocean.shootAt(0, 0));
	}
	
	@Test
	void testGetShotsFired() {
		Ocean ocean = new Ocean();
		ocean.shootAt(0, 0);
		assertEquals(1, ocean.getShotsFired());
	}
	
	@Test
	void testGetShotsHit() {
		Ocean ocean = new Ocean();
		ocean.shootAt(0, 0);
		if (ocean.ships[0][0].getShipType().equals("Empty")) {
			assertEquals(0, ocean.getHitCount());
		} else {
			assertEquals(1, ocean.getHitCount());
		}
		
	}
	
	@Test
	void testGetShipsSunk() {
		Ocean ocean = new Ocean();
		assertEquals(0, ocean.getShipsSunk());
	}
	
	@Test
	void testIsGameOver() {
		Ocean ocean = new Ocean();
		assertEquals(false, ocean.isGameOver());
	}
	
}
