
public abstract class Organism {
	
	public abstract void move();
	public abstract void breed();
	public abstract int getX();
	public abstract int getY();
	public abstract void setX(int x);
	public abstract void setY(int y);
	
	@Override
	public String toString() {
		return "OR";
	}
	
}
