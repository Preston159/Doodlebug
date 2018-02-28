import java.util.Scanner;

public class Main {
	final static int size = 20;
	static Organism[][] board = new Organism[size][];
	
	static {
		for(int i = 0; i < size; i++) {
			board[i] = new Organism[size];
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		placeBugs();
		do {
			if(!step())
				break;
			System.out.println("Press enter to continue");
		} while(in.nextLine().equals(""));
		in.close();
	}
	
	public static boolean step() {
		int ants = 0;
		for(Organism[] oa : board) {
			for(Organism o : oa) {
				if(o == null)
					continue;
				o.move();
			}
		}
		for(Organism[] oa : board) {
			for(Organism o : oa) {
				if(o == null)
					continue;
				if(o instanceof Ant)
					ants++;
			}
		}
		displayBoard();
		return ants != 0;
	}
	
	public static void displayBoard() {
		for(Organism[] r : board) {
			for(Organism c : r) {
				if(c == null) {
					System.out.print(" ");
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
		o.setX(tx);
		o.setY(ty);
		board[tx][ty] = o;
		board[fx][fy] = null;
	}
	
	public static void placeBugs() {
		int randInt;
		int randIntTwo;
		
		for(int i = 0; i < 100; i++) {
			randInt = (int) (Math.random() * size);
			randIntTwo = (int) (Math.random() * size);
			board[randInt][randIntTwo] = new Ant(randInt, randIntTwo);
		}
		for(int i = 0; i < 1; i++) {
			randInt = (int) (Math.random() * size);
			randIntTwo = (int) (Math.random() * size);
			board[randInt][randIntTwo] = new Doodlebug(randInt, randIntTwo);
		}
	}
	
	public static boolean isInBoard(int x, int y) {
		return x >= 0 && x < size && y >= 0 && y < size;
	}
	
}
