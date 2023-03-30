public class Location{
	private int x;
	private int y;
	
	private int owner;
	private int score;

	public Location(){}
	public Location(int x, int y, int owner){
		this.x = x;
		this.y = y;
		this.owner = owner;
	}
	public Location(int x, int y, int owner, int score){
		this(x, y, owner);
		this.score = score;
	}
	public int getX(){return this.x;}
	public void setX(int x){this.x = x;}
	public int getY(){return this.y;} 
	public void setY(int y){this.y = y;}
	public int getOwner(){return this.owner;}
	public void setOwner(int owner){this.owner = owner;}
	public int getScore(){return this.score;}
	public void setScore(int score){this.score = score;}
}
