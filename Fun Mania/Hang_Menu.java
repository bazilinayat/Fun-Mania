import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;

public class Hang_Menu implements ActionListener{

	static JFrame f;
	static JButton play,high,exit;
	static JRadioButton r1,r2,r3,r4,r5,r6;
	ButtonGroup bg;
	static String sel= "";
	static String cat;
	static Connection c=null;
	static Statement st=null;
	static ResultSet rs=null;
	private JLabel imglabel;
	private ImageIcon img;

	Hang_Menu(){
		JLabel l=new JLabel("Choose a category above and play.");
		l.setForeground(Color.BLACK);
		l.setFont(new Font("TimesRoman", Font.BOLD, 18));
		f=new JFrame();
		f.setSize(500, 550);
		f.setLayout(null);
		
		img = new ImageIcon("./res/Green.jpg");;
		imglabel = new JLabel(img);
		f.add(imglabel);
		imglabel.setBounds(0,0,700,600);
		
		play=new JButton("Play");
		play.setBackground(Color.LIGHT_GRAY);
		play.setBounds(170,230,150,40);
		play.setVisible(true);
		
		high=new JButton("Highscore");
		high.setBackground(Color.LIGHT_GRAY);
		high.setBounds(170,330,150,40);
		high.setVisible(true);
		
		exit=new JButton("Exit");
		exit.setBackground(Color.LIGHT_GRAY);
		exit.setBounds(170,430,150,40);
		exit.setVisible(true);
		
		r1=new JRadioButton("Education");
		r1.setBounds(50,50,100,20);
		
		r2=new JRadioButton("Entertainment");
		r2.setBounds(200,50,150,20);
		
		r3=new JRadioButton("Food&Drink");
		r3.setBounds(350,50,200,20);
		
		r4=new JRadioButton("Sport");
		r4.setBounds(50,100,150,20);
		
		r5=new JRadioButton("Travel");
		r5.setBounds(200,100,100,20);
		
		r6=new JRadioButton("Work&Jobs");
		r6.setBounds(350,100,150,20);
		
		bg = new ButtonGroup();
		bg.add(r1);		
   		bg.add(r2);
   		bg.add(r3);
   		bg.add(r4);
   		bg.add(r5);
   		bg.add(r6);
		
		l.setBounds(70,150,400,30);
		
		f.setTitle("Hangman");
		f.setResizable(false);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
		
		play.addActionListener(this);
		high.addActionListener(this);
		exit.addActionListener(this);
		imglabel.add(play);
		imglabel.add(high);
		imglabel.add(exit);
		imglabel.add(r1);
		imglabel.add(r2);
		imglabel.add(r3);
		imglabel.add(r4);
		imglabel.add(r5);
		imglabel.add(r6);
		imglabel.add(l);
		//obj.add(gameplay);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(r1.isSelected())
 			sel = sel + "Education";
	else if(r2.isSelected())
  			sel = sel + " Entertainment";
	else if(r3.isSelected())
			sel = sel + " Food&Drink";
	else if(r4.isSelected())
			sel = sel + " Sport";
	else if(r5.isSelected())
			sel = sel + " Travel";
	else if(r6.isSelected())
			sel = sel + " Work&Jobs";

		if(e.getSource()==play){
			if(r1.isSelected()){
				f.dispose();
				new Phantom_Hangman(1);
			}
			if(r2.isSelected()){
				f.dispose();
				new Phantom_Hangman(2);
			}
			if(r3.isSelected()){
				f.dispose();
				new Phantom_Hangman(3);
			}
			if(r4.isSelected()){
				f.dispose();
				new Phantom_Hangman(4);
			}
			if(r5.isSelected()){
				f.dispose();
				new Phantom_Hangman(5);
			}
			if(r6.isSelected()){
				f.dispose();
				new Phantom_Hangman(6);
			}
		}
		
		try{
			if(e.getSource()==high){
				int i=2;
				Class.forName("org.postgresql.Driver");
				c=DriverManager.getConnection("jdbc:postgresql://192.168.100.253/tydb34", "ty34", "");
				st=c.createStatement();
				rs=st.executeQuery("select pname,score from player,score where gid=3 and score.pid=player.pid");
				JLabel[] l=new JLabel[12];
				for(int j=0;j<12;j++){
					l[j]=new JLabel();
				}
				l[0].setText("          Name");
				l[1].setText("          Score");
				while(rs.next()){
					l[i].setText("          "+rs.getString(1));
					i++;
					l[i].setText("          "+String.valueOf(rs.getInt(2)));
					i++;
				}
				c.close();
				JFrame f=new JFrame();
				f.setSize(500,600);
				f.setTitle("Highscores");
				f.setLayout(new GridLayout(10,2));
				for(int k=0;k<12;k++){
					f.add(l[k]);
				}
				f.setVisible(true);
				f.setResizable(false);
				f.setLocationRelativeTo(null);
				f.pack();
			}
		}
		catch(Exception c){
			System.out.println("Exception : "+c);
		}
		if(e.getSource()==exit){
			f.dispose();
		}
	}

}
