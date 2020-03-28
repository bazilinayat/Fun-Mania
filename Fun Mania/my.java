//package pp;

import java.awt.event.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


public class my implements ActionListener{
	
	static JTextArea display ;
	static JFrame frame;
	static JButton b1,b2,b3,b4,b5,b6,b7,b8;
		
	my()
	{
		JPanel middlePanel = new JPanel ();
	    middlePanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Display Area" ) );

	    // create the middle panel components

	     display = new JTextArea ( 20, 38 );
	    display.setEditable (false); // set textArea non-editable
	    JScrollPane scroll = new JScrollPane ( display );
	    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

	    //Add Textarea in to middle panel
	    middlePanel.add ( scroll );

	    // My code
	    frame = new JFrame ();
	    frame.setLayout(new BorderLayout());
		frame.setTitle("?Instructions?");
	    frame.setSize(620,400);
	    frame.add ( middlePanel ,BorderLayout.EAST);
	    frame.setLocationRelativeTo ( null );
	    frame.setResizable(false);
	    frame.setVisible ( true );
	    
	    JPanel button = new JPanel();
	    button.setLayout(new GridLayout(8,0,0,10));
	    b1=new JButton("Snake");
	    b1.addActionListener(this);
	    button.add(b1);
	    b2=new JButton("Tetris");
	    b2.addActionListener(this);
	    button.add(b2);
	    b3=new JButton("Puzzel");
		b3.addActionListener(this);
	    button.add(b3);
	    b4=new JButton("Brick Breaker");
		b4.addActionListener(this);
	    button.add(b4);
	    b5=new JButton("Hangman");
		b5.addActionListener(this);
	    button.add(b5);
	    b6=new JButton("The Simple game");
		b6.addActionListener(this);
	    button.add(b6);
	    b7=new JButton("Piano Tiles");
		b7.addActionListener(this);
	    button.add(b7);
	    b8=new JButton("Brain teaser");
		b8.addActionListener(this);
	    button.add(b8);
	    frame.add(button,BorderLayout.WEST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BufferedReader reader=null;
		String line;
		if(e.getSource()==b1)
		{
			display.setText(null);
			try {
				reader = new BufferedReader(new FileReader("./res/snake.txt"));
				   while ((line = reader.readLine()) != null)
				   {
				        display.append(line + "\n");
				   }
				}
				   catch (IOException ioe) {
				   System.err.println(ioe);
				}
		}
		if(e.getSource()==b2)
		{
			display.setText(null);
			try {
				reader = new BufferedReader(new FileReader("./res/tetris.txt"));
				   while ((line = reader.readLine()) != null)
				   {
				       if (!line.startsWith(">"))
				       {
				           display.append(line + "\n");
				       }
				   }
				}
				   catch (IOException ioe) {
				   System.err.println(ioe);
				}
		}
		if(e.getSource()==b3)
		{
			display.setText(null);
			try {
				reader = new BufferedReader(new FileReader("./res/puzzle.txt"));
				   while ((line = reader.readLine()) != null)
				   {
				       if (!line.startsWith(">"))
				       {
				           display.append(line + "\n");
				       }
				   }
				}
				catch (IOException ioe) {
				   System.err.println(ioe);
				}
		}
		if(e.getSource()==b4)
		{
			display.setText(null);
			try {
				reader = new BufferedReader(new FileReader("./res/brick.txt"));
				   while ((line = reader.readLine()) != null)
				   {
				       if (!line.startsWith(">"))
				       {
				           display.append(line + "\n");
				       }
				   }
				}
				   catch (IOException ioe) {
				   System.err.println(ioe);
				}
		}
		if(e.getSource()==b5)
		{
			display.setText(null);
			try {
				reader = new BufferedReader(new FileReader("./res/hangman.txt"));
				   while ((line = reader.readLine()) != null)
				   {
				       if (!line.startsWith(">"))
				       {
				           display.append(line + "\n");
				       }
				   }
				}
				   catch (IOException ioe) {
				   System.err.println(ioe);
				}
		}
		if(e.getSource()==b6)
		{
			display.setText(null);
			try {
				reader = new BufferedReader(new FileReader("./res/simple.txt"));
				   while ((line = reader.readLine()) != null)
				   {
				       if (!line.startsWith(">"))
				       {
				           display.append(line + "\n");
				       }
				   }
				}
				   catch (IOException ioe) {
				   System.err.println(ioe);
				}
		}
		if(e.getSource()==b7)
		{
			display.setText(null);
			try {
				reader = new BufferedReader(new FileReader("./res/piano.txt"));
				   while ((line = reader.readLine()) != null)
				   {
				       if (!line.startsWith(">"))
				       {
				           display.append(line + "\n");
				       }
				   }
				}
				   catch (IOException ioe) {
				   System.err.println(ioe);
				}
		}
		if(e.getSource()==b8)
		{
			display.setText(null);
			try {
				reader = new BufferedReader(new FileReader("./res/brain.txt"));
				   while ((line = reader.readLine()) != null)
				   {
				       if (!line.startsWith(">"))
				       {
				           display.append(line + "\n");
				       }
				   }
				}
				   catch (IOException ioe) {
				   System.err.println(ioe);
				}
		}
	}
}
