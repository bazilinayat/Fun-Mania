import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;

public class Simple_menu implements ActionListener{
	public static JFrame obj;
	static JPanel p;
	private JLabel imglabel;
	private ImageIcon img;
	public static Brick_Gameplay gameplay;
	static JButton play,exit;
	Connection c=null;
	Statement st=null;
	ResultSet rs=null;
	Simple_menu(){
		obj=new JFrame();
		obj.setLayout(null);
		gameplay=new Brick_Gameplay();
		obj.setBounds(0,0,600,720);
		
		img = new ImageIcon("./res/Green.jpg");;
		imglabel = new JLabel(img);
		obj.add(imglabel);
		imglabel.setBounds(0,0,600,720);
		
		play=new JButton("Play");
		play.setBackground(Color.LIGHT_GRAY);
		play.setBounds(225,200,150,40);
		play.setVisible(true);
		
		exit=new JButton("Exit");
		exit.setBackground(Color.LIGHT_GRAY);
		exit.setBounds(225,300,150,40);
		exit.setVisible(true);
		
		obj.setTitle("The Simple Game");
		obj.setResizable(false);
		obj.setLocationRelativeTo(null);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(obj.DISPOSE_ON_CLOSE);
		
		play.addActionListener(this);
		exit.addActionListener(this);
		imglabel.add(play);
		imglabel.add(exit);
		//obj.add(gameplay);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==play){
			obj.dispose();
			View.main(null);
		}
		if(e.getSource()==exit){
			obj.dispose();
		}
	}
}
