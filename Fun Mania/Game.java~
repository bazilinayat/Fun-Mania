
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Game extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	ImageIcon i1,i2,i3,i4,i5,i6,i7,i8,i9;
	JMenuBar mnuBar;
	JMenu mnuHelp;
	JMenuItem mAbout;

	Game()
	{
		super("Fun Mania"); //setting the title 
		initComponents();
		//initMenubar();
		setSize(1280, 1024);//width,height
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	//JLabel lblTitle, lblEventInformation;


	//String eventInformation;

	void initComponents()
	{
		JLabel background=new JLabel(new ImageIcon("./res/b2.jpg"));
		add(background);
		background.setLayout(new GridLayout());

		
		b1 = new JButton("");
		i1 = new ImageIcon("./res/images/1.jpg");
		b2 = new JButton("");
		i2 = new ImageIcon("./res/images/2.png");
		b3 = new JButton("");
		i3 = new ImageIcon("./res/images/3.jpg");
		b4 = new JButton("");
		i4 = new ImageIcon("./res/images/4.jpg");
		b5 = new JButton("");
		i5 = new ImageIcon("./res/images/5.jpg");
		b6 = new JButton("");
		i6 = new ImageIcon("./res/images/6.jpg");
		b7 = new JButton("");
		i7 = new ImageIcon("./res/images/7.jpg");
		b8 = new JButton("");
		i8 = new ImageIcon("./res/images/image.png");
		b9 = new JButton("");
		i9 = new ImageIcon("./res/images/9.jpg");

		//set properties
		b1.setIcon(i1);    
		Dimension d1 = new Dimension(30,60);
		b1.setPreferredSize(d1);

		b2.setIcon(i2);    
		Dimension d2 = new Dimension(30,60);
		b2.setPreferredSize(d2);
		b3.setIcon(i3);    
		Dimension d3 = new Dimension(30,60);
		b3.setPreferredSize(d3);
		b4.setIcon(i4);    
		Dimension d4 = new Dimension(30,60);
		b4.setPreferredSize(d4);
		b5.setIcon(i5);    
		Dimension d5 = new Dimension(30,60);
		b5.setPreferredSize(d5);
		b6.setIcon(i6);    
		Dimension d6 = new Dimension(30,60);
		b6.setPreferredSize(d6);
		b7.setIcon(i7);    
		Dimension d7 = new Dimension(30,60);
		b7.setPreferredSize(d7);
		b8.setIcon(i8);    
		Dimension d8 = new Dimension(30,60);
		b8.setPreferredSize(d8);
		b9.setIcon(i9);    
		Dimension d9 = new Dimension(30,60);
		b9.setPreferredSize(d9);

		//set auto sizing and positioning using GridLayout
		
		background.setLayout(new GridLayout(3,2,30,30));//rows,cols,vgap,hgap

		//add the components
		background.add(b1);
		background.add(b2);
		background.add(b3);
		background.add(b4);
		background.add(b5);
		background.add(b6);
		background.add(b7);
		background.add(b8);
		background.add(b9);

		//set the listener

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);

		
		mnuBar = new JMenuBar();
		mnuHelp = new JMenu("Help");
		mAbout = new JMenuItem("About");

		//AboutHandler ah = new AboutHandler();
		mAbout.addActionListener(new About());
		background.add(mAbout);

		//add the menu items to the menu
		mnuHelp.add(mAbout);

		//add the menu to the menubar
		mnuBar.add(mnuHelp);
		//set the menubar into the window
		setJMenuBar(mnuBar);
		
	}

	class About extends JFrame implements ActionListener 
	{
		public void actionPerformed(ActionEvent ex)
		{
			setTitle("About");
			setSize(300, 250);//width,height
			setLocationRelativeTo(null);
			JLabel ver = new JLabel("Fun Mania v1.0", JLabel.CENTER);
			ver.setForeground(Color.BLACK);
			add(ver);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setResizable(false);
			setVisible(true);
		}
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			try
			{
				new Snake_Main();
			}	
			catch(Exception e1)
			{
				System.out.println("Some Error");
				e1.printStackTrace();
			}
		}
		if(e.getSource()==b2)
		{
			try
			{
				new Hang_Menu();
			}
			catch(Exception e1)
			{
				System.out.println("Some Error");
				e1.printStackTrace();
			}
		}

		if(e.getSource()==b3)
		{
			try
			{
				new Tetris_Menu();
			}	
			catch(Exception e1)
			{
				System.out.println("Some Error");
				e1.printStackTrace();
			}
		}

		
		if(e.getSource()==b4)
		{
			try
			{
				new Brick_Main();
			}	
			catch(Exception e1)
			{
				System.out.println("Some Error");
				e1.printStackTrace();
			}
		}
		if(e.getSource()==b5)
		{
			try
			{
				new my();
			}	
			catch(Exception e2)
			{
				System.out.println("Some Error");
				e2.printStackTrace();
			}
		}

		if(e.getSource()==b6)
		{
			try
			{
				new Brain("Teaser");
			}	
			catch(Exception e2)
			{
				System.out.println("Some Error");
				e2.printStackTrace();
			}
		}

		if(e.getSource()==b7)
		{
			try
			{
				new Piano_Menu();
			}	
			catch(Exception e2)
			{
				System.out.println("Some Error");
				e2.printStackTrace();
			}
		}
		if(e.getSource()==b8)
		{
			try
			{
			//Process pro1=Runtime.getRuntime().exec("javac Tetris.java");
			Process pro2=Runtime.getRuntime().exec("java PuzzleEx");
			}	
			catch(Exception e2)
			{
				System.out.println("Some Error");
				e2.printStackTrace();
			}
		}
		if(e.getSource()==b9)
		{
			try
			{
			//Process pro1=Runtime.getRuntime().exec("javac Tetris.java");
			//Process pro2=Runtime.getRuntime().exec("java Simple_menu");
			new Simple_menu(); 
			}	
			catch(Exception e2)
			{
				System.out.println("Some Error");
				e2.printStackTrace();
			}
		}
	}
}
