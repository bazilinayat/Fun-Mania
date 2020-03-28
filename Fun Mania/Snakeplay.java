import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.*;

public class Snakeplay extends JPanel implements KeyListener,ActionListener{
	private int[] snakeXLength=new int[750];
	private int[] snakeYLength=new int[750];
	
	final private int id=1;

	//default snake length
	private int lengthOfSnake=3;

	private boolean play=false;
	//movement
	private boolean left=false;
	private boolean right=false;
	private boolean up=false;
	private boolean down=false;
	//image movement
	private ImageIcon rightMouth;
	private ImageIcon leftMouth;
	private ImageIcon upMouth;
	private ImageIcon downMouth;	
	//body
	private ImageIcon snakeImage;
	
	//for enemy
	private int enemyXPos[]={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400
			,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	private int enemyYPos[]={75,100,125,150,175,200,225,250,275,300,325,350,375,400
			,425,450,475,500,525,550,575,600,625};
	
	private ImageIcon enemyImage;
	
	//to decide the random position of the enemy
	private Random random=new Random();
	private int xPos=random.nextInt(34);
	private int yPos=random.nextInt(23);
	
	//for scores
	private static int score=0;
	
	private Timer timer;
	private int delay=100;
	
	private ImageIcon titleImage;
	
	private int moves=0;

	public int getScore(){
		return score;
	}

	//default constructor
	public Snakeplay(){
		addKeyListener(this);
		setBackground(Color.DARK_GRAY);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer=new Timer(delay,this);
		timer.start();
		//setBackground(Color.DARK_GRAY);
		setVisible(true);
	}
	
	//paint function to draw everything
	public void paint(Graphics g){
		
		//
		if(moves==0){
			snakeXLength[2]=50;
			snakeXLength[1]=75;
			snakeXLength[0]=100;
			snakeYLength[2]=100;
			snakeYLength[1]=100;
			snakeYLength[0]=100;
		}
		
		//draw title image border
		g.setColor(Color.WHITE);
		g.drawRect(24,10,851,55);
		
		//draw the title image
		titleImage=new ImageIcon("./res/snaketitle.jpg");
		titleImage.paintIcon(this,g,25,11);
		
		//draw border for gameplay
		g.setColor(Color.WHITE);
		g.drawRect(24,74,851,577);
		
		//draw background for gameplay
		g.setColor(Color.BLACK);
		g.fillRect(25,75,850,575);
		
		//draw score rectangle
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial",Font.BOLD,14));
		g.drawString("Score : "+score,780,30);
		
		//draw length rectangle
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial",Font.BOLD,14));
		g.drawString("Length : "+lengthOfSnake,780,50);
		
		//draw snake
		rightMouth=new ImageIcon("./res/rightmouth2.png");
		rightMouth.paintIcon(this,g,snakeXLength[0],snakeYLength[0]);
		
		for(int a=0;a<lengthOfSnake;a++){
			//for the initial direction of snake
			if(a==0 && right){
				rightMouth=new ImageIcon("./res/rightmouth2.png");
				rightMouth.paintIcon(this,g,snakeXLength[a],snakeYLength[a]);
			}
			
			if(a==0 && left){
				leftMouth=new ImageIcon("./res/leftmouth2.png");
				leftMouth.paintIcon(this,g,snakeXLength[a],snakeYLength[a]);
			}
			
			if(a==0 && up){
				upMouth=new ImageIcon("./res/upmouth2.png");
				upMouth.paintIcon(this,g,snakeXLength[a],snakeYLength[a]);
			}
			
			if(a==0 && down){
				downMouth=new ImageIcon("./res/downmouth2.png");
				downMouth.paintIcon(this,g,snakeXLength[a],snakeYLength[a]);
			}
			
			//for the body of snake
			if(a!=0){
				snakeImage=new ImageIcon("./res/snakeimage2.png");
				snakeImage.paintIcon(this,g,snakeXLength[a],snakeYLength[a]);
			}
				
		}
		
		//draw the enemy
		enemyImage=new ImageIcon("./res/enemy.png");
		
		//to check if ball has collided with the snake
		if((enemyXPos[xPos]==snakeXLength[0]) && (enemyYPos[yPos]==snakeYLength[0])){
			//increment the scores
			score++;
			
			
			//increment the length of snake
			lengthOfSnake++;
			
			//new position of enemy
			xPos=random.nextInt(34);
			yPos=random.nextInt(23);
		}
		
		//paintinh the enemy
		enemyImage.paintIcon(this,g,enemyXPos[xPos],enemyYPos[yPos]);
		
		//to detect collision between head and body
		for(int b=1;b<lengthOfSnake;b++){
			if((snakeXLength[b]==snakeXLength[0]) && (snakeYLength[b]==snakeYLength[0])&&play){ //collide with himself
				right=false;
				left=false;
				up=false;
				down=false;
				play=false;
				
				g.setColor(Color.WHITE);
				g.setFont(new Font("arial",Font.BOLD,50));
				g.drawString("Gmae Over",300,300);
				reset();
				//moves=0;
				//score=0;
				///////////////////////////////////////////////////////////////////////////////////////////////
				lengthOfSnake=3;
				repaint();
				g.setFont(new Font("arial",Font.BOLD,20));
				g.drawString("SPACE to RESTART",350,340);
			}
		}
		
		g.dispose();
	}

void reset(){


System.out.println("In reset");
new player(id,score);
moves=0;
score=0;
lengthOfSnake=3;
repaint();

}
/*
private void player()
{
try
		{
			Process pro1=Runtime.getRuntime().exec("javac player.java");
			//pro1.waitFor();
			Process pro2=Runtime.getRuntime().exec("java player");
			//pro2.waitFor();
		}	
		catch(Exception e)
		{
			System.out.println("Some Error");
			e.printStackTrace();
		}
}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		
		//if right pressed
		if(right){
			//shifting the head to every position of the body one by one
			//so the body knows where the head is turning
			for(int r=lengthOfSnake-1;r>=0;r--){
				snakeYLength[r+1]=snakeYLength[r];
			}
			for(int r=lengthOfSnake;r>=0;r--){
				if(r==0){
					snakeXLength[r]=snakeXLength[r]+25;
				}
				else{
					snakeXLength[r]=snakeXLength[r-1];
				}
				//if snake touches the border on right then it should come back from
				//the left side
				if(snakeXLength[r]>850){
					snakeXLength[r]=25;
				}
			}
			repaint();
		}
		
		//if left pressed
		if(left){
			//shifting the head to every position of the body one by one
			//so the body knows where the head is turning
			for(int r=lengthOfSnake-1;r>=0;r--){
				snakeYLength[r+1]=snakeYLength[r];
			}
			for(int r=lengthOfSnake;r>=0;r--){
				if(r==0){
					snakeXLength[r]=snakeXLength[r]-25;
				}
				else{
					snakeXLength[r]=snakeXLength[r-1];
				}
				//if snake touches the border on right then it should come back from
				//the left side
				if(snakeXLength[r]<25){
					snakeXLength[r]=850;
				}
			}
			repaint();
		}

		//if up pressed
		if(up){
			//shifting the head to every position of the body one by one
			//so the body knows where the head is turning
			for(int r=lengthOfSnake-1;r>=0;r--){
				snakeXLength[r+1]=snakeXLength[r];
			}
			for(int r=lengthOfSnake;r>=0;r--){
				if(r==0){
					snakeYLength[r]=snakeYLength[r]-25;
				}
				else{
					snakeYLength[r]=snakeYLength[r-1];
				}
				//if snake touches the border on right then it should come back from
				//the left side
				if(snakeYLength[r]<75){
					snakeYLength[r]=625;
				}
			}
			repaint();
		}

		//if down pressed
		if(down){
			//shifting the head to every position of the body one by one
			//so the body knows where the head is turning
			for(int r=lengthOfSnake-1;r>=0;r--){
				snakeXLength[r+1]=snakeXLength[r];
			}
			for(int r=lengthOfSnake;r>=0;r--){
				if(r==0){
					snakeYLength[r]=snakeYLength[r]+25;
				}
				else{
					snakeYLength[r]=snakeYLength[r-1];
				}
				//if snake touches the border on right then it should come back from
				//the left side
				if(snakeYLength[r]>625){
					snakeYLength[r]=75;
				}
			}
			repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		//for space key to restart the game
		/*if(e.getKeyCode()==KeyEvent.VK_SPACE){
			moves=0;
			score=0;
			lengthOfSnake=3;
			repaint();
		}*/
		
		//for right arrow key
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			moves++;
			right=true;
			play=true;
			if(!left){
				right=true;
			}
			else{
				right=false;
				left=true;
			}
			up=false;
			down=false;
		}
		
		//for left arrow key
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			moves++;
			left=true;
play=true;
			if(!right){
				left=true;
			}
			else{
				left=false;
				right=true;
			}
			up=false;
			down=false;
		}
		
		//for up arrow key
		if(e.getKeyCode()==KeyEvent.VK_UP){
			moves++;
			up=true;
play=true;
			if(!down){
				up=true;
			}
			else{
				up=false;
				down=true;
			}
			right=false;
			left=false;
		}
		
		//for down arrow key
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			moves++;
			down=true;
play=true;
			if(!up){
				down=true;
			}
			else{
				down=false;
				up=true;
			}
			right=false;
			left=false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}	
}
