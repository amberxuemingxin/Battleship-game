import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EmptySeaTest {

	@Test
	void testGetShipType() {
		EmptySea emptysea = new EmptySea();
		assertEquals("Empty", emptysea.getShipType());
	}
	
	@Test
	void testToString() {
		Ocean ocean = new Ocean();
		EmptySea emptysea = new EmptySea();
		emptysea.placeShipAt(0, 0, false, ocean);
		
		assertEquals(true, emptysea.shootAt(0, 0));
		assertEquals(true, emptysea.isSunk());
	}


}