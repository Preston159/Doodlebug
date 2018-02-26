
public class Doodlebug extends Organism {
	
	private int x, y;
	
	public Doodlebug(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void move() {
		int[] direction = Main.getDirection();
		int nx = this.x + direction[0];
		int ny = this.y + direction[1];
		if(nx < 0 || nx > 19 || ny < 0 || ny > 19) {
			move();
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
	}
	
	@Override
	public void breed() {
		
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
