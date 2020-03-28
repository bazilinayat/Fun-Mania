import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball implements Runnable {
	//Global vars
	int
	x1=600,
	y1=600,
	bWidth,
	bHeigth,
	b1Width,
	b1Heigth,
	x,
	y,
	//xDir,
	yDir,
	xDir1,
	yDir1,
	xDir2;
	
 
	Rectangle ball;
	Rectangle ball1;
	Rectangle ball2;
	View v=new View();

	public Ball(int x,int y){
		bWidth = 30;
		bHeigth = 30;
		b1Width = 30;
		b1Heigth = 30;

		this.x=x;
		this.y=y;
		
		this.x1=x;
		this.y1=y;
		
		//set the ball moving randomly
		Random r = new Random();

		//For Ball2
		int xrDir1 = r.nextInt(1);//always between 0 and 1.
		if(xrDir1==0){ 			//if 0 then change to -1 
			xrDir1--;
		}
		setXDir1(xrDir1);
		
		int yrDir1 = r.nextInt(1);//always between 0 and 1.
		if(yrDir1==0){			//if 0 then change to -1
			yrDir1--;
		}
		setYDir1(yrDir1);

		int xrDir2 = r.nextInt(1);//always between 0 and 1.
		if(xrDir2==0){ 			//if 0 then change to -1 
		xrDir2--;
		}
		setXDir2(xrDir2);
		
		int yrDir = r.nextInt(1);//always between 0 and 1.
		if(yrDir==0){			//if 0 then change to -1
			yrDir--;
		}
		setYDir(yrDir);
		
		//create a rectangle
		ball = new Rectangle(this.x,this.y,bWidth,bHeigth);
		//create a Ball1
		ball1 = new Rectangle(this.x1,this.y1,b1Width,b1Heigth);
		//create a Ball2
		ball2 = new Rectangle(this.x,this.y,b1Width,b1Heigth);
	}
	public void setXDir2(int xD2){
	xDir2= xD2;
	}
	public void setYDir(int yD){
		yDir= yD;
	}
	
	public void setXDir1(int xD1){
		xDir1= xD1;
	}
	public void setYDir1(int yD1){
		yDir1= yD1;
	}
	public void draw(Graphics g){
		//collision();
		g.setColor(Color.white);
		g.fillRect(ball.x, ball.y, ball.width,ball.height);
		g.setColor(Color.white);
		g.fillRect(ball1.x, ball1.y, ball1.width,ball1.height);
		g.setColor(Color.white);
		g.fillRect(ball2.x, ball2.y, ball2.width,ball2.height);
	}
	
	public void move(){
		//changes both x and y direction simultaneously using 
		//threads concept! wtf?
		//ball.x += xDir;
		ball.y += yDir;
		ball1.x += xDir1;
		ball1.y  += yDir1;
		ball2.x += xDir2;
		
		//For Ball2 
		if(ball2.x<=0){	//left edge
		setXDir2(+1);
			
		}
		if(ball2.x>=500-ball2.width){ //right edge
		setXDir2(-1);
		}
		
		//For Ball
		if(ball.y<=57){
			setYDir(+1);
		}
		if(ball.y>=500-ball.height){ 
			setYDir(-1);
		}

		//For Ball1
		if(ball1.x<=0){	//left edge
		setXDir1(+1);
			
		}
		if(ball1.x>=1200-82){ //right edge
		setXDir1(-1);
		}
		if(ball1.y<=0){
			setYDir1(+1);
		}
		if(ball1.y>=850-152){ 
			setYDir1(-1);
		}
	}
	

	@Override
	public void run() {
		try{
			while(true){
				move();
				Thread.sleep(5);
				
			}
		}catch(Exception e){System.out.println(e.getMessage());}

	}

}
