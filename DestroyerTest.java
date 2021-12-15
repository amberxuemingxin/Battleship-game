import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DestroyerTest {

	@Test
	void testGetShipType() {
		Destroyer destroyer = new Destroyer();
		assertEquals("Destroyer", destroyer.getShipType());
	}


}