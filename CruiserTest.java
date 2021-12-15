import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CruiserTest {

	@Test
	void testGetShipType() {
		Cruiser cruiser = new Cruiser();
		assertEquals("Cruiser", cruiser.getShipType());
	}


}
