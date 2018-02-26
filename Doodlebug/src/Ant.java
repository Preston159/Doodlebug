
public class Ant extends Organism {
	
	private int x, y;
	private int age = 0;
	
	public Ant(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void move() {
		int[] direction = Main.getDirection();
		int nx = x + direction[0];
		int ny = y + direction[1];
		Organism o = Main.board[nx][ny];
		if(o == null && nx >= 0 && nx < 20 && ny >= 0 && ny < 20) {
			Main.moveOrganism(x, y, nx, ny);
		}
		if(age++ % 3 == 0) {
			breed();
		}
	}

	@Override
	public void breed() {
		int[][] locations = new int[][] {
				new int[] { -1, 0 },
				new int[] { 1, 0 },
				new int[] { 0, -1 },
				new int[] { 0, 1}
		};
		for(int[] l : locations) {
			int nx = x + l[0];
			int ny = y + l[1];
			if(Main.board[nx][ny] == null) {
				Main.board[nx][ny] = new Ant(nx, ny);
				break;
			}
		}
	}
	
	@Override
	public String toString() {
		return "o";
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
}
