//package back;

//package mazesolver;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class View extends JFrame implements Runnable{
	
		int x,	//x-axis default position of ball
		y,	//y-axis default position of ball
		xDir,	//x-Direction
		yDir;	//x-Direction
		
	private Image dbImage;	//Double buffering Image
	private Graphics dbg;	//Double buffering Graphics
	private Image face;		//Player image on screen
	Font font=new Font("Arial",Font.BOLD|Font.ITALIC,30);
	int times=0;
	static Ball b=new Ball(700,450);
	private static int level=1;
	//private MapGenerator map;

	public void run(){
		try{
			while(true){
			//infinite while loop run as fast as computer can manage
			//but we'll control the speed of the object by sleep method
			move();
			//Controls the speed of update of object on screen
			//time inc: speed decrease ;time dec: speed increase
			Thread.sleep(10); 
			
			}
		}catch(Exception e){
			System.out.println("Error detected in run() method's catch"); 
		}
	}
	
	public void move(){
		//changes both x and y direction simultaneously using 
		//threads concept! wtf?
		x += xDir;
		y += yDir;
		
		//Handles collisions at boundary of the window.
		if(x<=0)
			x=0;
		if(x>=1200-52)
			x=1200-52;
		if(y<=0)
			y=0;
		if(y>=850-132) 
			y=850-132;
			
	}
	
	public void setXDir(int xD){
		xDir= xD;
	}
	public void setYDir(int yD){
		yDir= yD;
	}

public class AL extends KeyAdapter{
		//Action Listener inner class
		//Handles all KeyEvents 
		public void keyPressed(KeyEvent e){
			int keyCode=e.getKeyCode();
			if(keyCode==e.VK_LEFT){
				setXDir(-2);
			}
			if(keyCode==e.VK_RIGHT){
				setXDir(+2);		
			}
			if(keyCode==e.VK_UP){
				setYDir(-2);
			}
			if(keyCode==e.VK_DOWN){
				setYDir(+2);
			}
			
		}
		
		public void keyReleased(KeyEvent e){
			// set all direction flags to 0
			//so it becomes null after every paintComponent call
			
			int keyCode=e.getKeyCode();
			if(keyCode==e.VK_LEFT){
				setXDir(0);
			}
			if(keyCode==e.VK_RIGHT){
				setXDir(0);		
			}
			if(keyCode==e.VK_UP){
				setYDir(0);
			}
			if(keyCode==e.VK_DOWN){
				setYDir(0);
			}
		}
	}

  /**
   * Conventions:
   * 
   * maze[row][col]
   * 
   * Values: 0 = Wall
   *         1 = Empty Space
   *
   */
  private int [][] maze = 
      { {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,1},
        {1,0,0,0,0,1,1,0,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
        {1,0,1,1,0,1,0,1,0,1,1,1,0,1,1,1,0,1,1,0,0,1,1,1,0,0,1,1,0,0,1},
        {1,0,1,1,0,1,0,1,1,0,0,0,1,0,0,0,0,0,0,1,1,1,0,1,1,1,1,0,1,0,1},
        {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,0,1,1,1,1,0,1},
        {1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,1,0,0,1},
        {1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,0,1},
        {1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,1,0,1,1,0,0,1},
        {1,0,1,1,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1},
        {1,0,1,0,0,1,1,1,1,1,0,0,0,1,1,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,1},
        {1,0,1,0,1,1,0,1,1,0,0,1,0,1,0,0,0,0,1,1,0,1,1,1,0,0,0,1,0,0,1},
        {1,0,1,0,1,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,0,1,1,0,1,1,0,1},
        {1,0,1,1,0,1,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,1,1,1,1,1,1,0,1,0,1},
        {1,0,1,0,1,0,0,1,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,0,1,1,0,1},
        {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
      };

  
  View() {
	addKeyListener(new AL());
      setTitle("Simple Maze Solver");
      setSize(1200, 950);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setFocusable(true);

	x=100; y=90;
  }	

  @Override
  public void paint(Graphics g) {

		dbImage = createImage(getWidth(), getHeight());
		//Creates an off-screen image used for double buffering?wtf
		dbg = dbImage.getGraphics();
		//stores graphics of image in Graphic obj
		paintComponent(dbg);
		//paint the graphics on screen
		g.drawImage(dbImage, 0, 0, this);
		//draw image to the screen
		//map.draw((Graphics2D)g);

}
  
	public void paintComponent(Graphics g){
		
		// draw the maze
     		 for (int row = 0; row < maze.length; row++) {
          		for (int col = 0; col < maze[0].length; col++) {
              		Color color;
             			 switch (maze[row][col]) {
                  		case 1 : color = Color.BLACK; break;
                  		//case 9 : color = Color.RED; break;
                 		 default : color = Color.WHITE;
              }
              g.setColor(color);
              g.fillRect(40 * col, 40 * row, 40, 40);
              g.setColor(Color.BLACK);
              g.drawRect(40 * col, 40 * row, 40, 40);
          }
      }
     		 
       	
   		
     		Rectangle r1= new Rectangle(x,y,20,20);	//movable
   		g.setColor(Color.BLUE);
   		g.fillRect(r1.x, r1.y, r1.width, r1.height);
   		g.setColor(Color.green);
		Rectangle r2= new Rectangle(320,400,40,40);//stable
		g.fillRect(r2.x, r2.y, r2.width, r2.height);
   		g.setColor(Color.white);
		b.draw(g);
			
			for (int row = 0; row < maze.length; row++) {
          		for (int col = 0; col < maze[0].length; col++) {
						if(maze[row][col]==0)
                 		 {
					//collision of player with walls
                 			if(r1.intersects(new Rectangle(40*col,40*row,40,40))){
                 				//xDir *=-xDir;
                 				//yDir *=-yDir;
                 				//xDir *=-1;
                 				//yDir *=-1;
                 				//x=350; y=350;
                 				//reset();
                 				//System.out.println("Detected "+times+++" Times");
                 				nxtlevel();
                 			}  
						//collision of door with player
					        if(r2.intersects(r1)){
                 				//reset();
					        	nxtlevel();
                 				//System.out.println("Detected "+times+++" Times");
						}
						//collision of player with enemy
					        if(b.ball.intersects(r1)){
                 				//reset();
					        	nxtlevel();
                 				//System.out.println("Detected "+times+++" Times");
                 			}
					        if(b.ball1.intersects(r1)){
                 				//reset();
					        	nxtlevel();
                 				//System.out.println("Detected "+times+++" Times");
                 			}      
                 		 }
					}
			}

	
		repaint();//repaints by calling paint() method of this component
	}

	void nxtlevel()
	{
		//System.out.println("here");
		/*int dialogResult = JOptionPane.showConfirmDialog(null, 
				"Game Over...... " +
						JOptionPane.OK_OPTION);
		if (dialogResult == JOptionPane.OK_OPTION)
		{
			//new Simple_menu();
			dispose();
			//reset(); // re-initialize the Game
		}*/
JOptionPane.showMessageDialog(null,null, "Game Over.....", JOptionPane.PLAIN_MESSAGE);
		dispose();
		

	}

	/*void reset()
	{
		new View();
		//repaint();
		x=100; y=90;
	}*/
	
	public static void main(String[] args) {
		View jg=new View();
		jg.setVisible(true);
		Thread t1=new Thread(jg);
		t1.start();
		//create and run thread
		Thread balls=new Thread(b);
		balls.start();

	}

  
}
