import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BattleshipTest {

	@Test
	void testGetShipType() {
		Battleship battleship = new Battleship();
		assertEquals("Battleship",battleship.getShipType());
	}


}