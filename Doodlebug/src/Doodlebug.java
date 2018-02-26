
public class Doodlebug extends Organism {
	
	private int x, y;
	
	public Doodlebug(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void move() {
		
	}
	
	@Override
	public Organism breed() {
		
		return null;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	
}
