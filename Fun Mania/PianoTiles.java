

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

public class PianoTiles implements ActionListener,MouseListener{

	public static PianoTiles pt;
	public ArrayList<Tile> tiles;
	public Renderer renderer;
	
	public final static int
		ROWS =3,
		COLUMNS = 3,
		TILE_WIDTH = 200,
		TILE_HEIGHT = 240;
	
	public Random random;
	final private int id=7;
	public int milSecDelay , score;
	public boolean delay, gameOver;
	public boolean p_called=false;
	
	
	public PianoTiles(){
		JFrame frame = new JFrame("Piano Tiles 0");
		Timer timer = new Timer(20,this);
		
		//tiles = new ArrayList<Tile>();
		renderer = new Renderer();
		
		random = new Random();
		frame.setSize(TILE_WIDTH*COLUMNS,TILE_HEIGHT*ROWS); 
		frame.add(renderer);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.addMouseListener(this);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		 
		start();
		timer.start();
	}
	
	public static void main(String[] args) {
		pt = new PianoTiles();
	}
	
	public void start(){
		score =0;
		gameOver=false;
		tiles = new ArrayList<Tile>();
		
		for(int x=0; x<COLUMNS ; x++){
			for(int y=0 ; y < ROWS ; y++){
				boolean canBeBlack = true;
				for(Tile tile :tiles){
					if(tile.y == y && tile.black){
						canBeBlack = false; 
					}
				}
				if(!canBeBlack){
					tiles.add(new Tile(x ,y ,false));
				}else{
					tiles.add(new Tile(x ,y ,random.nextInt(2)==0 || x==2));
				}
				
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		renderer.repaint();
		
		for(int i=0;i<tiles.size();i++){
			Tile tile = tiles.get(i);
			if(tile.animateY<0){
				tile.animateY += TILE_HEIGHT/5;
			}
		}
		milSecDelay++;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, TILE_WIDTH *COLUMNS, TILE_HEIGHT*ROWS);
		g.setFont(new Font("Arail",1,100));
		
		if(!gameOver){
			
			
			for( Tile tile: tiles)
			{
				g.setColor(tile.black ? Color.BLACK : Color.WHITE);
				g.fillRect(tile.x*TILE_WIDTH,tile.y *TILE_HEIGHT + tile.animateY,TILE_WIDTH , TILE_HEIGHT);
				g.setColor(tile.black ? Color.WHITE : Color.BLACK);
				g.drawRect(tile.x*TILE_WIDTH ,tile.y *TILE_HEIGHT + tile.animateY ,TILE_WIDTH , TILE_HEIGHT);
			} 
			g.setColor(Color.RED);
			g.drawString(String.valueOf(score), TILE_WIDTH+5, 100);
			
		}else{
			g.setColor(Color.red);
			g.drawString("Game Over!", 10,120);
			g.setFont(new Font("Arail",1,25));
			g.setColor(Color.black);
			g.drawString("Click to restart!", 180,200);
			//gameOver=false;
			if(!p_called){
				new player(id,score);
				p_called=true;
			}
		}
		
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
		
		
	}

	public void mouseExited(MouseEvent arg0) {
		
		
	}

	public void mousePressed(MouseEvent e) {

		boolean clicked =false;
		if(!gameOver)
		{
			//when clicked : check which tile is pressed 
			//if it's black : add score
			//if it's white : you lose
			for(int i=0; i< tiles.size();i++)
			{
				Tile tile = tiles.get(i);
				if(tile.pointInTile(e.getX(), e.getY()) && !clicked)
				{
					if(e.getY() > TILE_HEIGHT * (ROWS-1))
					{
						if(tile.black)
						{
							//System.out.println("Yo..");
							for(int j=0; j < tiles.size() ; j++)
							{
								if(tiles.get(j).y ==(ROWS)){
									tiles.remove(j);
								}
								tiles.get(j).y++; 
								tiles.get(j).animateY -= TILE_HEIGHT; // animation to move it back up
							}
						
							boolean canBeBlack = true;
							
							score += Math.max(100-milSecDelay, 10); 
							//System.out.println("You've Scored "+ Math.max(100-milSecDelay, 10) + " points");
							milSecDelay = 0;
							for(int x=0 ; x < COLUMNS; x++)
							{
								boolean black =random.nextInt(2)==0 || x==COLUMNS-1;
								
								Tile newTile;
								if(canBeBlack && black){
									 newTile = new Tile(x,0,true);
									 canBeBlack = false;
								}else{
									newTile = new Tile(x,0,false);
								}
								
								newTile.animateY-=TILE_HEIGHT;
									tiles.add(newTile);
							}
						}//end: if(tile.black)
						else
						{
							gameOver = true;
						}
					clicked = true;				
				}//end : if(e.getY() > TILE_HEIGHT *2)
				else
				{
					gameOver = true;
				}
			}//end: if(tile.pointInTile(e.getX(), e.getY()) && !clicked)
		}//end: for loop
	}//end: if(!gameOver)
	else
	{
		start();
		p_called=false;
	}
	}

	public void mouseReleased(MouseEvent arg0) {
		
		
	}
}