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
import javax.swing.Timer;

public class Snakeplay2 extends JPanel implements KeyListener,ActionListener{
	
	//for player 1
	private int[] snakeXLength=new int[750];
	private int[] snakeYLength=new int[750];
	
	final private int id=11;

	//default snake length
	private int lengthOfSnake=3;

	private boolean play=false;
	private boolean win1=false;
	private boolean win2=false;
	
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
	
	//for scores
	private int score=0;
	
	private int moves=0;
	
	
	//for player 2
	private int[] snake2XLength=new int[750];
	private int[] snake2YLength=new int[750];
	
	//default snake length
	private int lengthOfSnake2=3;
	
	//movement
	private boolean a=false;
	private boolean d=false;
	private boolean w=false;
	private boolean s=false;
	
	//image movement
	private ImageIcon rightMouth2;
	private ImageIcon leftMouth2;
	private ImageIcon upMouth2;
	private ImageIcon downMouth2;
	
	//body
	private ImageIcon snakeImage2;
	
	//for scores
	private int score2=0;
	
	private int moves2=0;
	
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
	
	private Timer timer;
	private int delay=100;
	
	private ImageIcon titleImage;
	
	//default constructor
	public Snakeplay2(){
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer=new Timer(delay,this);
		timer.start();
		//setVisible(true);
	}

	void reset(){

	if(win1){
		new player(id,score);
		moves=0;
		score=0;
		lengthOfSnake=3;
		moves2=0;
		score2=0;
		lengthOfSnake2=3;
		repaint();
	}
	if(win2){
		new player(id,score2);
		moves=0;
		score=0;
		lengthOfSnake=3;
		moves2=0;
		score2=0;
		lengthOfSnake2=3;
		repaint();
	}

}
	
	//paint function to draw everything
	public void paint(Graphics g){
		
		//common
		{
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
		}
		
		//for player 1
		{
			if(moves==0){
				snakeXLength[2]=50;
				snakeXLength[1]=75;
				snakeXLength[0]=100;
				
				snakeYLength[2]=100;
				snakeYLength[1]=100;
				snakeYLength[0]=100;
			}
			
			
			
			//draw score rectangle
			g.setColor(Color.WHITE);
			
			g.setFont(new Font("arial",Font.BOLD,14));
			g.drawString("Player 1",30,40);
			
			g.setFont(new Font("arial",Font.BOLD,14));
			g.drawString("Score : "+score,100,30);
			
			//draw length rectangle
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial",Font.BOLD,14));
			g.drawString("Length : "+lengthOfSnake,100,50);
			
			//draw snake
			rightMouth=new ImageIcon("./res/rightmouth12.png");
			rightMouth.paintIcon(this,g,snakeXLength[0],snakeYLength[0]);
			
			for(int a=0;a<lengthOfSnake;a++){
				//for the initial direction of snake
				if(a==0 && right){
					rightMouth=new ImageIcon("./res/rightmouth12.png");
					rightMouth.paintIcon(this,g,snakeXLength[a],snakeYLength[a]);
				}
				
				if(a==0 && left){
					leftMouth=new ImageIcon("./res/leftmouth12.png");
					leftMouth.paintIcon(this,g,snakeXLength[a],snakeYLength[a]);
				}
				
				if(a==0 && up){
					upMouth=new ImageIcon("./res/upmouth12.png");
					upMouth.paintIcon(this,g,snakeXLength[a],snakeYLength[a]);
				}
				
				if(a==0 && down){
					downMouth=new ImageIcon("./res/downmouth12.png");
					downMouth.paintIcon(this,g,snakeXLength[a],snakeYLength[a]);
				}
				
				//for the body of snake
				if(a!=0){
					snakeImage=new ImageIcon("./res/snakeimage12.png");
					snakeImage.paintIcon(this,g,snakeXLength[a],snakeYLength[a]);
				}
					
			}
			
			//draw the enemy
			enemyImage=new ImageIcon("./res/enemy.png");
			
			//to check if enemy has collided with the snake
			if((enemyXPos[xPos]==snakeXLength[0]) && (enemyYPos[yPos]==snakeYLength[0])){
				//increment the scores
				score++;
				
				//increment the length of snake
				lengthOfSnake++;
				
				//new position of enemy
				xPos=random.nextInt(34);
				yPos=random.nextInt(23);
			}			
		}
		
		//for player 2
		{
			if(moves2==0){
				snake2XLength[2]=775;
				snake2XLength[1]=750;
				snake2XLength[0]=725;

				snake2YLength[2]=600;
				snake2YLength[1]=600;
				snake2YLength[0]=600;
			}

			//draw score rectangle
			g.setColor(Color.WHITE);

			g.setFont(new Font("arial",Font.BOLD,20));
			g.drawString("Player 2",670,40);

			g.setFont(new Font("arial",Font.BOLD,14));
			g.drawString("Score : "+score2,780,30);

			//draw length rectangle
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial",Font.BOLD,14));
			g.drawString("Length : "+lengthOfSnake2,780,50);

			//draw snake
			leftMouth2=new ImageIcon("./res/leftmouth2.png");
			leftMouth2.paintIcon(this,g,snake2XLength[0],snake2YLength[0]);

			for(int b=0;b<lengthOfSnake2;b++){
				//for the initial direction of snake
				if(b==0 && d){
					rightMouth2=new ImageIcon("./res/rightmouth2.png");
					rightMouth2.paintIcon(this,g,snake2XLength[b],snake2YLength[b]);
				}

				if(b==0 && a){
					leftMouth2=new ImageIcon("./res/leftmouth2.png");
					leftMouth2.paintIcon(this,g,snake2XLength[b],snake2YLength[b]);
				}

				if(b==0 && w){
					upMouth2=new ImageIcon("./res/upmouth2.png");
					upMouth2.paintIcon(this,g,snake2XLength[b],snake2YLength[b]);
				}

				if(b==0 && s){
					downMouth2=new ImageIcon("./res/downmouth2.png");
					downMouth2.paintIcon(this,g,snake2XLength[b],snake2YLength[b]);
				}

				//for the body of snake
				if(b!=0){
					snakeImage2=new ImageIcon("./res/snakeimage2.png");
					snakeImage2.paintIcon(this,g,snake2XLength[b],snake2YLength[b]);
				}

			}

			//draw the enemy
			enemyImage=new ImageIcon("./res/enemy.png");

			//to check if enemy has collided with the snake
			if((enemyXPos[xPos]==snake2XLength[0]) && (enemyYPos[yPos]==snake2YLength[0])){
				//increment the scores
				score2++;

				//increment the length of snake
				lengthOfSnake2++;

				//new position of enemy
				xPos=random.nextInt(34);
				yPos=random.nextInt(23);
			}			
		}
		
		//paintinh the enemy
		enemyImage.paintIcon(this,g,enemyXPos[xPos],enemyYPos[yPos]);

		//to detect collision between head nad body
		for(int b=1;b<lengthOfSnake2;b++){
			if((snake2XLength[b]==snake2XLength[0]) && (snake2YLength[b]==snake2YLength[0])&&play){
				d=false;
				a=false;
				w=false;
				s=false;
				play=false;
				win1=true;

				g.setColor(Color.WHITE);
				
				g.setFont(new Font("arial",Font.BOLD,60));
				g.drawString("Player 1 WINS",250,250);
				
				g.setFont(new Font("arial",Font.BOLD,50));
				g.drawString("Gmae Over",300,300);

				g.setFont(new Font("arial",Font.BOLD,20));
				g.drawString("SPACE to RESTART",350,340);
				reset();
			}
			//if 1 cuts 2
			if(lengthOfSnake>lengthOfSnake2){
				if((snakeXLength[0]==snake2XLength[b]) && (snakeYLength[0]==snake2YLength[b])&&play){
					d=false;
					a=false;
					w=false;
					s=false;
					right=false;
					left=false;
					up=false;
					down=false;
					play=false;
					win1=true;

					g.setColor(Color.WHITE);

					g.setFont(new Font("arial",Font.BOLD,60));
					g.drawString("Player 1 WINS",250,250);

					g.setFont(new Font("arial",Font.BOLD,50));
					g.drawString("Gmae Over",300,300);

					g.setFont(new Font("arial",Font.BOLD,20));
					g.drawString("SPACE to RESTART",350,340);
					reset();
				}
			}
		}
		for(int b=1;b<lengthOfSnake;b++){
			if((snakeXLength[b]==snakeXLength[0]) && (snakeYLength[b]==snakeYLength[0])&&play){
				right=false;
				left=false;
				up=false;
				down=false;
				play=false;
				win2=true;

				g.setColor(Color.WHITE);

				g.setFont(new Font("arial",Font.BOLD,60));
				g.drawString("Player 2 WINS",250,250);

				g.setFont(new Font("arial",Font.BOLD,50));
				g.drawString("Gmae Over",300,300);

				g.setFont(new Font("arial",Font.BOLD,20));
				g.drawString("SPACE to RESTART",350,340);
				reset();
			}
			
			//2 cuts 1
			if(lengthOfSnake2>lengthOfSnake){
				if((snake2XLength[0]==snakeXLength[b]) && (snake2YLength[0]==snakeYLength[b])&&play){
					d=false;
					a=false;
					w=false;
					s=false;
					right=false;
					left=false;
					up=false;
					down=false;
					play=false;
					win2=true;

					g.setColor(Color.WHITE);

					g.setFont(new Font("arial",Font.BOLD,60));
					g.drawString("Player 1 WINS",250,250);

					g.setFont(new Font("arial",Font.BOLD,50));
					g.drawString("Gmae Over",300,300);

					g.setFont(new Font("arial",Font.BOLD,20));
					g.drawString("SPACE to RESTART",350,340);
					reset();
				}
			}
		}
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		
		//for player 1
		{
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
		
		//for player 2
		{
			//if right pressed
			if(d){
				//shifting the head to every position of the body one by one
				//so the body knows where the head is turning
				for(int r=lengthOfSnake2-1;r>=0;r--){
					snake2YLength[r+1]=snake2YLength[r];
				}
				for(int r=lengthOfSnake2;r>=0;r--){
					if(r==0){
						snake2XLength[r]=snake2XLength[r]+25;
					}
					else{
						snake2XLength[r]=snake2XLength[r-1];
					}
					//if snake touches the border on right then it should come back from
					//the left side
					if(snake2XLength[r]>850){
						snake2XLength[r]=25;
					}
				}
				repaint();
			}

			//if left pressed
			if(a){
				//shifting the head to every position of the body one by one
				//so the body knows where the head is turning
				for(int r=lengthOfSnake2-1;r>=0;r--){
					snake2YLength[r+1]=snake2YLength[r];
				}
				for(int r=lengthOfSnake2;r>=0;r--){
					if(r==0){
						snake2XLength[r]=snake2XLength[r]-25;
					}
					else{
						snake2XLength[r]=snake2XLength[r-1];
					}
					//if snake touches the border on right then it should come back from
					//the left side
					if(snake2XLength[r]<25){
						snake2XLength[r]=850;
					}
				}
				repaint();
			}

			//if up pressed
			if(w){
				//shifting the head to every position of the body one by one
				//so the body knows where the head is turning
				for(int r=lengthOfSnake2-1;r>=0;r--){
					snake2XLength[r+1]=snake2XLength[r];
				}
				for(int r=lengthOfSnake2;r>=0;r--){
					if(r==0){
						snake2YLength[r]=snake2YLength[r]-25;
					}
					else{
						snake2YLength[r]=snake2YLength[r-1];
					}
					//if snake touches the border on right then it should come back from
					//the left side
					if(snake2YLength[r]<75){
						snake2YLength[r]=625;
					}
				}
				repaint();
		}

			//if down pressed
			if(s){
				//shifting the head to every position of the body one by one
				//so the body knows where the head is turning
				for(int r=lengthOfSnake2-1;r>=0;r--){
					snake2XLength[r+1]=snake2XLength[r];
				}
				for(int r=lengthOfSnake2;r>=0;r--){
					if(r==0){
						snake2YLength[r]=snake2YLength[r]+25;
					}
					else{
						snake2YLength[r]=snake2YLength[r-1];
					}
					//if snake touches the border on right then it should come back from
					//the left side
					if(snake2YLength[r]>625){
						snake2YLength[r]=75;
					}
				}
				repaint();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		//common
		{
			//for space key to restart the game
			/*if(e.getKeyCode()==KeyEvent.VK_SPACE){
				moves=0;
				score=0;
				lengthOfSnake=3;
				moves2=0;
				score2=0;
				lengthOfSnake2=3;
				repaint();
			}*/
		}
		
		//for player 1
		{
						
			//for right arrow key
			if(e.getKeyCode()==KeyEvent.VK_RIGHT){
				moves++;
				play=true;
				right=true;
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
				play=true;
				left=true;
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
				play=true;
				up=true;
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
				play=true;
				down=true;
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
		
		//for player 2
		{

			//for right arrow key
			if(e.getKeyCode()==KeyEvent.VK_D){
				moves2++;
				play=true;
				d=true;
				if(!a){
					d=true;
				}
				else{
					d=false;
					a=true;
				}
				w=false;
				s=false;
			}

			//for left arrow key
			if(e.getKeyCode()==KeyEvent.VK_A){
				moves2++;
				play=true;
				a=true;
				if(!d){
					a=true;
				}
				else{
					a=false;
					d=true;
				}
				w=false;
				s=false;
			}

			//for up arrow key
			if(e.getKeyCode()==KeyEvent.VK_W){
				moves2++;
				play=true;
				w=true;
				if(!s){
					w=true;
				}
				else{
					w=false;
					s=true;
				}
				d=false;
				a=false;
			}

			//for down arrow key
			if(e.getKeyCode()==KeyEvent.VK_S){
				moves2++;
				play=true;
				s=true;
				if(!w){
					s=true;
				}
				else{
					s=false;
					w=true;
				}
				d=false;
				a=false;
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}	
}
