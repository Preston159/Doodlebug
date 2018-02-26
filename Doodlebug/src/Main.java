
public class Main {
	
	static Organism[][] board = new Organism[20][];
	static {
		for(int i = 0; i < 20; i++) {
			board[i] = new Organism[20];
		}
	}
	
	public static void main(String[] args) {
		displayBoard();
	}
	
	public static void step() {
		
	}
	
	public static void displayBoard() {
		for(Organism[] r : board) {
			for(Organism c : r) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
}
