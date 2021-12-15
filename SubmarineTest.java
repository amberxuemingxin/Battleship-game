import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SubmarineTest {

	@Test
	void testGetShipType() {
		Submarine submarine = new Submarine();
		assertEquals("Submarine", submarine.getShipType());
	}


}