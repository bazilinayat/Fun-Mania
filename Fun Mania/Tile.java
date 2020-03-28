

public class Tile {

	public int x, y;
	public boolean black;
	public int animateY;

	public Tile(int x, int y, boolean black) {
		this.x =x;
		this.y =y;
		this.black = black;
	}
	
	public boolean pointInTile(int x,int y){	//coordinates of the click
		
		int width = PianoTiles.TILE_WIDTH; 
		int height = PianoTiles.TILE_HEIGHT;
		//Rectangle rect = new Rectangle(this.x, this.y, PianoTiles.TILE_WIDTH , PianoTiles.TILE_HEIGHT );
		//return rect.contains(x,y);	
		return(x > this.x * width && x < this.x * width + width && y > this.y * height && y < this.y * height + height);
	}

}
