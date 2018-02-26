
public class Ant extends Organism {
	
	private int x, y;
	
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
			x = nx;
			y = ny;
		}
	}

	@Override
	public Organism breed() {
		
		return null;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	
}
