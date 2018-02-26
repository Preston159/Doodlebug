
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
			this.x+=1;
		}
		else if(Main.board[this.x - 1][this.y] instanceof Ant){
			this.x-=1;
		}
		else if(Main.board[this.x][this.y+1] instanceof Ant){
			this.y+=1;
		}
		else if(Main.board[this.x][this.y-1] instanceof Ant){
			this.y-=1;
		}
		else {
			this.x+=nx;
			this.y+=ny;
		}
	}
	
	@Override
	public Organism breed() {
		
		return null;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	
}
