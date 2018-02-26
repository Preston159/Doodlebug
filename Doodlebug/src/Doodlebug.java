
public class Doodlebug extends Organism {
	
	private int x, y;
	private int age = 0;
	
	public Doodlebug(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void move() {
		int[] direction = Main.getDirection();
		int nx = this.x + direction[0];
		int ny = this.y + direction[1];
		if(nx-1 < 0 || nx+1 > 19 || ny-1 < 0 || ny+1 > 19) {
			
		}
		else if(Main.board[this.x + 1][this.y] instanceof Ant){
			Main.moveOrganism(x, y, x + 1, y);
		}
		else if(Main.board[this.x - 1][this.y] instanceof Ant){
			Main.moveOrganism(x, y, x - 1, y);
		}
		else if(Main.board[this.x][this.y + 1] instanceof Ant){
			Main.moveOrganism(x, y, x, y + 1);
		}
		else if(Main.board[this.x][this.y - 1] instanceof Ant){
			Main.moveOrganism(x, y, x, y - 1);
		}
		else {
			Main.moveOrganism(x, y, nx, ny);
		}
		
		if(age++ % 8 == 0) {
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
				Main.board[nx][ny] = new Doodlebug(nx, ny);
				break;
			}
		}
	}
	
	@Override
	public String toString() {
		return "X";
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
