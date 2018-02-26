public class Main {
	
	static Organism[][] board = new Organism[20][];
	static {
		for(int i = 0; i < 20; i++) {
			board[i] = new Organism[20];
		}
	}
	
	public static void main(String[] args) {
		placeBugs();
		do {
			displayBoard();
		} while(step());
	}
	
	public static boolean step() {
		int ants = 0;
		for(Organism[] oa : board) {
			for(Organism o : oa) {
				if(o == null)
					continue;
				if(o instanceof Ant)
					ants++;
				o.move();
			}
		}
		return ants != 0;
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
		assert isInBoard(fx, fy) && isInBoard(tx, ty);
		o.setX(tx);
		o.setY(ty);
		board[tx][ty] = o;
		board[fx][fy] = null;
	}
	
	public static void placeBugs() {
		int randInt;
		int randIntTwo;
		
		for(int i = 0; i < 100; i++) {
			randInt = (int) (Math.random() * 20);
			randIntTwo = (int) (Math.random() * 20);
			board[randInt][randIntTwo] = new Ant(randInt, randIntTwo);
		}
		for(int i = 0; i < 5; i++) {
			randInt = (int) (Math.random() * 20);
			randIntTwo = (int) (Math.random() * 20);
			board[randInt][randIntTwo] = new Doodlebug(randInt, randIntTwo);
		}
	}
	
	public static boolean isInBoard(int x, int y) {
		return x >= 0 && x < 20 && y >= 0 && y < 20;
	}
	
}
