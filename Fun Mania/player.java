import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;

class player extends JFrame implements ActionListener{

	//JFrame frame;
	JLabel name,gender,topic;
	JRadioButton male,female;
	JButton submit,clear;
	JTextField t;
	ButtonGroup bg;
	static String name1,gender1;
	static String sel= "";
	int score=0,gid=0;
	static int pid=0;
	player(int id,int sc){
		//frame=new JFrame();
		JLabel background=new JLabel(new ImageIcon("./res/b11.jpg"));
		add(background);
		score= sc;
		gid=id;
		topic=new JLabel("Player Information");
		topic.setForeground(Color.BLACK);
		topic.setBounds(150,30,200,30);
		background.add(topic);

		name=new JLabel("Name :");
		name.setForeground(Color.BLACK);
		name.setBounds(100,100,50,30);
		background.add(name);

		t=new JTextField();
		t.setVisible(true);
		t.setBounds(170,100,100,30);
		background.add(t);

		gender=new JLabel("Gender :");
		gender.setForeground(Color.BLACK);
		gender.setBounds(100,200,70,30);
		background.add(gender);

		male=new JRadioButton("Male", true);
		male.setBounds(180,190,100,15);
		background.add(male);
		female=new JRadioButton("Female");
		female.setBounds(180,220,100,15);
		background.add(female);

		bg = new ButtonGroup();
		bg.add(male);		
   		bg.add(female);

		male.addActionListener(this);
   		female.addActionListener(this);

		submit=new JButton("Submit");
		submit.setBounds(75,350,100,40);
		submit.addActionListener(this);
		background.add(submit);

		clear=new JButton("Clear");
		clear.setBounds(250,350,100,40);
		clear.addActionListener(this);
		background.add(clear);


		background.setLayout(null);
		setTitle("Score");
		setSize(400,500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e){
		
		if(male.isSelected())
     			sel = sel + " Male";
		else if(female.isSelected())
      			sel = sel + " Female";

		Connection conn=null;
		PreparedStatement iplayer=null;
		PreparedStatement iscore=null;
		Statement st;
		try{
		
			//connection
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection("jdbc:postgresql://192.168.100.253/tydb34","ty34","");
			if(conn==null){
				System.out.println("Connection Failed");
			}
			else{
				if(e.getSource()==submit){
				
				if(t.getText()==null){
					System.out.println("Mar jaa");
				}
				else{			
					name1=t.getText();
				}
				if(male.isSelected()){
				gender1="M";
				}
				else{
				gender1="F";
				}
				
				st=conn.createStatement();
				ResultSet rs=st.executeQuery("select count(pid) from player");
				rs.next();
				pid=rs.getInt(1)+1;
				
				iplayer=conn.prepareStatement("insert into player values(?,?,?)");
				iplayer.setInt(1,pid);
				iplayer.setString(2,name1);
 				iplayer.setString(3,gender1);
				iplayer.executeUpdate();

				iscore=conn.prepareStatement("insert into score values(?,?,?)");
				iscore.setInt(1,gid);
				iscore.setInt(2,pid);
				iscore.setInt(3,score);
				iscore.executeUpdate();

				conn.close();

				//System.out.print(Snakeplay.score1);
				JFrame f=new JFrame();
				f.setSize(300,300);
				f.add(new JLabel("Name : "+name1+"Gender : "+gender1+"Score : "+score));
				f.setVisible(true);
				//Snakeplay.f.setVisible(true);
				dispose();
				}
			}
		}
		catch(Exception ae){
			System.out.println("Exception : "+ae);
		}
		if(e.getSource()==clear){
			t.setText(null);
			male.setSelected(false);
			female.setSelected(false);
		}
	}
}
