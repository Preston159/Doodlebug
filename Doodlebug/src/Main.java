import java.util.Scanner;

public class Main {
	
	static Organism[][] board = new Organism[20][];
	static {
		for(int i = 0; i < 20; i++) {
			board[i] = new Organism[20];
		}
	}
	
	public static void main(String[] args) {
		placeBugs();
		
		
	}
	
	public static void step() {
		
	}
	
	public static void displayBoard() {
		for(Organism[] r : board) {
			for(Organism c : r) {
				if(c == null) {
					System.out.print("_");
				} else {
					System.out.print(c);
				}
			}
			System.out.println();
		}
	}
	
	public static int[] getDirection() {
		int dir = (int) (Math.random() * 4);
		switch(dir) {
		case 0:
			return new int[] {-1, 0};
		case 1:
			return new int[] {1, 0};
		case 2:
			return new int[] {0, -1};
		case 3:
			return new int[] {0, 1};
		default: return null;
		}
	}
	
	public static void moveOrganism(int fx, int fy, int tx, int ty) {
		Organism o = board[fx][fy];
		assert o.getX() == fx && o.getY() == fy;
		board[fx][fy] = null;
		o.setX(tx);
		o.setY(ty);
		board[tx][ty] = o;
	}
	
	public static void placeBugs() {
		int randInt;
		int randIntTwo;
		int counter = 0;
		
		for(int i = 0; i < 100; i++) {
			randInt = (int)(Math.random()*20);
			randIntTwo = (int)(Math.random()*20);
			board[randIntTwo][randInt] = new Ant(randInt,randInt);
		}
		for(int i = 0; i < 5; i++) {
			randInt = (int)(Math.random()*20);
			randIntTwo = (int)(Math.random()*20);
			board[randInt][randIntTwo] = new Doodlebug(randInt,randIntTwo);
		}
		
		
		
		
		
		displayBoard();
	}
	
}
