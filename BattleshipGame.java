import java.util.Scanner;

public class BattleshipGame {
	
	/**
	 * the main function for battleship game
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();

        System.out.println("Battleship Game Start");
        ocean.print();
        
        while(!ocean.isGameOver()) {
        	System.out.println("Enter row number you want to hit (0 - 9):");
        	int row = s.nextInt();
        	while (row < 0 || row > 9) {
        		System.out.println("Enter valid row number you want to hit (0 - 9):");
        		row = s.nextInt();
        	}
        	
        	System.out.println("Enter column number you want to hit (0 - 9):");
        	int column = s.nextInt();
        	while (column < 0 || column > 9) {
        		System.out.println("Enter valid column number you want to hit (0 - 9):");
        		column = s.nextInt();
        	}
        	
        	if(ocean.shootAt(row, column)){
        		if (ocean.ships[row][column].isSunk()) {
        			System.out.println("You just sunk a " + ocean.ships[row][column].getShipType());
        		} else {
        			System.out.println("You hit a ship!");
        		}
                
            }else{
                System.out.println("You missed.");
            }
        	System.out.println();
        	System.out.println("Shotsfired: " + ocean.shotsFired + ", hitcount: " 
        			+ ocean.hitCount + ", shipsSunk: " + ocean.shipsSunk);
        	System.out.println();
        	System.out.println();
        	ocean.print();
        }
        
        System.out.println("Game over");
        System.out.println("Score: " + ocean.getShotsFired());
        s.close();
	}
}
