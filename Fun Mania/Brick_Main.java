import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;

public class Brick_Main implements ActionListener{
	public static JFrame obj;
	static JPanel p;
	private JLabel imglabel;
	private ImageIcon img;
	public static Brick_Gameplay gameplay;
	static JButton play,high,exit;
	Connection c=null;
	Statement st=null;
	ResultSet rs=null;
	Brick_Main(){
		p=new JPanel();
		p.setBounds(0,0,700,600);
		//p.setBackground(Color.black);
		obj=new JFrame();
		p.setLayout(null);
		gameplay=new Brick_Gameplay();
		obj.setBounds(0,0,700,600);
		
		img = new ImageIcon("./res/Green.jpg");;
		imglabel = new JLabel(img);
		p.add(imglabel);
		imglabel.setBounds(0,0,700,600);
		
		play=new JButton("Play");
		play.setBackground(Color.LIGHT_GRAY);
		play.setBounds(275,100,150,40);
		play.setVisible(true);
		
		high=new JButton("Highscore");
		high.setBackground(Color.LIGHT_GRAY);
		high.setBounds(275,250,150,40);
		high.setVisible(true);
		
		exit=new JButton("Exit");
		exit.setBackground(Color.LIGHT_GRAY);
		exit.setBounds(275,400,150,40);
		exit.setVisible(true);
		
		obj.setTitle("My Brick");
		obj.setResizable(false);
		obj.setLocationRelativeTo(null);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(obj.DISPOSE_ON_CLOSE);
		
		play.addActionListener(this);
		high.addActionListener(this);
		exit.addActionListener(this);
		imglabel.add(play);
		imglabel.add(high);
		imglabel.add(exit);
		//obj.add(gameplay);
		obj.add(p);
	}
	
	private void add(JLabel imglabel2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==play){
			play.setVisible(false);
			high.setVisible(false);
			exit.setVisible(false);
			obj.add(gameplay);
		}
		try{
			if(e.getSource()==high){
				int i=2;
				Class.forName("org.postgresql.Driver");
				c=DriverManager.getConnection("jdbc:postgresql://192.168.100.253/tydb34", "ty34", "");
				st=c.createStatement();
				rs=st.executeQuery("select pname,score from player,score where gid=2 and score.pid=player.pid");
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
				//JTable tab=new JTable(data,col);
				//JScrollPane sp=new JScrollPane(tab);
				JFrame f=new JFrame();
				f.setSize(500,500);
				f.setTitle("Highscores");
				f.setLocationRelativeTo(null);
				f.setLayout(new GridLayout(10,2));
				for(int k=0;k<12;k++){
					f.add(l[k]);
				}
				f.setVisible(true);
				f.setResizable(false);
				f.setLocationRelativeTo(null);
				f.pack();
				//JOptionPane.showMessageDialog(null, "", "Highscores", JOptionPane.INFORMATION_MESSAGE);

			}
		}
		catch(Exception c){
			System.out.println("Exception : "+c);
		}
		if(e.getSource()==exit){
			obj.dispose();
		}
	}
}
