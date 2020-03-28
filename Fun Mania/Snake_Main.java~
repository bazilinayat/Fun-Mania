import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;

import javax.swing.*;

public class Snake_Main implements ActionListener{
	JPanel p,p1;
	JButton b1,b2,play,high,exit;
	JFrame frame=new JFrame();
	Snakeplay single = new Snakeplay();
	Snakeplay2 multi = new Snakeplay2();
	Connection c=null;
	Statement st=null;
	ResultSet rs=null;
	
	Snake_Main(){
		frame.setSize(900,700);
		frame.setBackground(Color.GRAY);
		frame.setTitle("2D - Snake");
		frame.setLocationRelativeTo(null);//to make the jframe come to the center
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		p=new JPanel();
		p.setSize(900,700);
		p.setLayout(null);
		
		p1=new JPanel();
		p1.setSize(900,700);
		p1.setLayout(null);
		
		play=new JButton("Play");
		play.setBackground(Color.LIGHT_GRAY);
		play.setBounds(350,100,150,70);
		play.setVisible(true);
		
		high=new JButton("Highscore");
		high.setBackground(Color.LIGHT_GRAY);
		high.setBounds(350,250,150,70);
		high.setVisible(true);
		
		exit=new JButton("Exit");
		exit.setBackground(Color.LIGHT_GRAY);
		exit.setBounds(350,400,150,70);
		exit.setVisible(true);
		
		play.addActionListener(this);
		high.addActionListener(this);
		exit.addActionListener(this);
		p.add(play);
		p.add(high);
		p.add(exit);		
		frame.add(p);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==play){
			//play.setVisible(false);
			//high.setVisible(false);
			//exit.setVisible(false);
			p.setVisible(false);
			frame.add(p1);
			b1=new JButton("Single Player");
			b1.setBounds(350,200,200,100);
			b1.setBackground(Color.LIGHT_GRAY);
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					frame.add(single);
					//b1.setVisible(false);
					//b2.setVisible(false);
					p1.setVisible(false);
				}
			});
			p1.add(b1);
			
			b2=new JButton("Two Player");
			b2.setBounds(350,400,200,100);;
			b2.setBackground(Color.LIGHT_GRAY);
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					frame.add(multi);
					//b2.setVisible(false);
					//b1.setVisible(false);
					p1.setVisible(false);
				}
			
			});
			p1.add(b2);
		}
		try{
			if(e.getSource()==high){

				//for first
				int i=2;
				Class.forName("org.postgresql.Driver");
				c=DriverManager.getConnection("jdbc:postgresql://192.168.100.253/tydb34", "ty34", "");
				st=c.createStatement();
				rs=st.executeQuery("select pname,score from player,score where gid=1 and score.pid=player.pid");
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
				f.setSize(500,500);
				f.setTitle("Highscores");
				f.setLayout(new GridLayout(10,2));
				for(int k=0;k<12;k++){
					f.add(l[k]);
				}
				f.setVisible(true);
				f.setResizable(false);
				f.setLocationRelativeTo(null);
				f.pack();

				//for second
				i=2;
				Class.forName("org.postgresql.Driver");
				c=DriverManager.getConnection("jdbc:postgresql://192.168.100.253/tydb34", "ty34", "");
				st=c.createStatement();
				rs=st.executeQuery("select pname,score from player,score where gid=11 and score.pid=player.pid");
				JLabel[] l1=new JLabel[12];
				for(int j=0;j<12;j++){
					l1[j]=new JLabel();
				}
				l1[0].setText("          Name");
				l1[1].setText("          Score");
				while(rs.next()){
					l1[i].setText("          "+rs.getString(1));
					i++;
					l1[i].setText("          "+String.valueOf(rs.getInt(2)));
					i++;
				}
				c.close();
				//JTable tab=new JTable(data,col);
				//JScrollPane sp=new JScrollPane(tab);
				JFrame f1=new JFrame();
				f1.setSize(500,500);
				f1.setTitle("Highscores");
				f1.setLayout(new GridLayout(10,2));
				for(int k=0;k<12;k++){
					f1.add(l1[k]);
				}
				f1.setVisible(true);
				f1.setResizable(false);
				f1.setLocationRelativeTo(null);
				f1.pack();
			}
		}
		catch(Exception c){
			System.out.println("Exception : "+c);
		}
		if(e.getSource()==exit){
			frame.dispose();
		}
		
	}
}
