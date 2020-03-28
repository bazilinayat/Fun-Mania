
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class GameBoard extends JFrame 
{
	/**
	 * The width of the GameBoard.
	 */
	private final int WIDTH;
	//for scores
	private static int numScore;

	public int getScore(){
		return numScore;
	}

	private final int id=3;
	/**
	 * The height of the GameBoard.
	 */
	private final int HEIGHT;

	/**
	 * The maximum number of guesses before game over.
	 */
	private final int MAX_INCORRECT;
	//min Score
	private final int MIN_Score;
	/**
	 * The maximum list length permitted.
	 */
	private final int MAX_list_LENGTH;

	/**
	 * The directory of the images of the hangman.
	 */
	private final String HANGMAN_IMAGE_DIRECTORY;

	/**
	 * The type of the images of the hangman.
	 */
	private final String HANGMAN_IMAGE_TYPE;

	/**
	 * The base (common) name of the images of the hangman (e.g. "hangman" for
	 * "hangman_0.png, hangman_1.png, ...")
	 */
	private final String HANGMAN_IMAGE_BASE_NAME;

	/**
	 * The directory of the images of the letters.
	 */
	private final String LETTER_IMAGE_DIRECTORY;

	/**
	 * The type of the images of the letters.
	 */
	private final String LETTER_IMAGE_TYPE;

	/**
	 * The letter rack containing a the letters to be guessed.
	 */
	private LetterRack gameRack;

	/**
	 * The hangman image placeholder.
	 */
	private Hangman gameHangman;

	/**
	 * The number of incorrect guesses.
	 */
	private int numIncorrect;

	/**
	 * Display the list hidden as *'s, revealing each letter as it is
	 * guessed
	 */
	private JLabel correct;

	/**
	 * Displays the number of incorrect guesses.
	 */
	private JLabel incorrect;
	//display score

	private JLabel score;
	/**
	 * The list to be guessed by the player.
	 */
	private String list;

	/**
	 * StringBuilder used to hide the list, revealing letters as they are
	 * guessed by the player.
	 */
	private StringBuilder listHidden;

	
	JMenuBar menubar;
	JMenu fileMenu;
	JMenuItem NewGameMenu,exitMenu;
	
	
	/**
	 * The default constructor.
	 */
	ArrayList a=new ArrayList();
	static int file_no;
	public GameBoard(int f)
	{
		BufferedReader br=null;
		String s;
		file_no=f;
		if(file_no==1){
			try{
				if(file_no==1)
					br=new BufferedReader(new FileReader("./res/Education.txt"));
				if(file_no==2)
					br=new BufferedReader(new FileReader("./res/Entertainment.txt"));
				if(file_no==3)
					br=new BufferedReader(new FileReader("./res/Food&Drink.txt"));
				if(file_no==4)
					br=new BufferedReader(new FileReader("./res/Sport.txt"));
				if(file_no==5)
					br=new BufferedReader(new FileReader("./res/Travel.txt"));
				if(file_no==6)
					br=new BufferedReader(new FileReader("./res/Work&Jobs.txt"));
				while((s=br.readLine())!=null){
					a.add(s);
				}
			}
			catch(Exception e){
				System.out.println("Exception : "+e);
			}
		}

		WIDTH = 500;
		HEIGHT = 500;
		MAX_INCORRECT = 6;
		MIN_Score = 10;
		MAX_list_LENGTH = 10;

		// The default directory for the sample images is images/ and the 
		//     default image type is .png; ensure this directory is
		//     created in the project folder if the sample images are used.
		HANGMAN_IMAGE_DIRECTORY = LETTER_IMAGE_DIRECTORY = "./images/";
		HANGMAN_IMAGE_TYPE = LETTER_IMAGE_TYPE = ".png";
		HANGMAN_IMAGE_BASE_NAME = "hangman";

		setTitle("Hangman");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocation(500,500);
		addCloseWindowListener();
		initMenuBar();
		initialize();
	}
	
	void New()
	{
		dispose();
		new Hang_Menu();
		new player(id,numScore);
	}

	void initMenuBar()
	{
	menubar = new JMenuBar();
   
    fileMenu = new JMenu("Game");
    fileMenu.setMnemonic(KeyEvent.VK_F);
    

    NewGameMenu = new JMenuItem("NewGame");
    NewGameMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
            ActionEvent.CTRL_MASK));
    
    NewGameMenu.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		System.out.println("Here");
		New();
		}
	});
    
    exitMenu = new JMenuItem("Exit");
    exitMenu.setToolTipText("Exit application");
    exitMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
            ActionEvent.CTRL_MASK));
    exitMenu.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispatchEvent(
					new WindowEvent(GameBoard.this,
					WindowEvent.WINDOW_CLOSING));				
		}
	});
    
    
    //fileMenu.add(newMenu);
    fileMenu.add(NewGameMenu);
    fileMenu.add(exitMenu);

   
    menubar.add(fileMenu);
    setJMenuBar(menubar);
    setVisible(true);
}
	/**
	 * Initializes all elements of the GameBoard that must be refreshed upon
	 * the start of a new game.
	 */
	private void initialize()
	{        
		numIncorrect = 0;
		numScore = 0;

		correct = new JLabel("Word: ");
		incorrect = new JLabel("Incorrect: " + numIncorrect);
		score = new JLabel("Score: "+ numScore);

		list = new String();
		listHidden = new StringBuilder();
		getlist();
		addTextPanel();
		addLetterRack();
		addHangman();

		// set board slightly above middle of screen to prevent dialogs
		//     from blocking images
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2,
				dim.height / 2 - getSize().height / 2 - 200);
		setVisible(true);
	}

	public void reinitialize(){

		numIncorrect = 0;
		correct = new JLabel("Word: ");
		incorrect = new JLabel("Incorrect: " + numIncorrect);
		score = new JLabel("Score: "+ numScore);

		list = new String();
		listHidden = new StringBuilder();

		getlist();
		addTextPanel();
		addLetterRack();
		addHangman();

		// set board slightly above middle of screen to prevent dialogs
		//     from blocking images
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2,
				dim.height / 2 - getSize().height / 2 - 200);
		setVisible(true);

	}

	/**
	 * Prompts the user to confirm before quitting out of the window.
	 */
	private void addCloseWindowListener()
	{
		// NOTE: Must be DO_NOTHING_ON_CLOSE for prompt to function correctly
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent we)
			{
				int prompt = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to quit?",
						"Quit?", 
						JOptionPane.YES_NO_OPTION);

				if (prompt == JOptionPane.YES_OPTION){
					new player(id,numScore);
					dispose();
				}
			}
		});
	}

	/**
	 * Adds the correct and incorrect labels to the top of the GameBoard
	 */
	private void addTextPanel()
	{
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(1,3));
		textPanel.add(correct);
		textPanel.add(incorrect);
		textPanel.add(score);
		// use BorderLayout to set the components of the gameboard in
		//     "visually agreeable" locations
		add(textPanel, BorderLayout.NORTH);
	}

	/**
	 * Adds the LetterRack to the bottom of the GameBoard and attaches
	 * the LetterTile TileListeners to the LetterTiles.
	 */
	private void addLetterRack()
	{
		gameRack = new LetterRack(list, 
				LETTER_IMAGE_DIRECTORY, 
				LETTER_IMAGE_TYPE);
		gameRack.attachListeners(new TileListener());
		add(gameRack, BorderLayout.SOUTH);
	}

	/**
	 * Adds a panel that contains the hangman images to the middle of the
	 * GameBoard.
	 */
	private void addHangman()
	{
		JPanel hangmanPanel = new JPanel();
		gameHangman = new Hangman(HANGMAN_IMAGE_BASE_NAME,
				HANGMAN_IMAGE_DIRECTORY,
				HANGMAN_IMAGE_TYPE);
		hangmanPanel.add(gameHangman);
		add(hangmanPanel, BorderLayout.CENTER);
	}

	/**
	 * Retrieves the list from the player, constrained by the length and
	 * content of the list.
	 */
	private void getlist()
	{
		if(a.size()==0){
			BufferedReader br = null;
			try{
				if(file_no==1)
					br=new BufferedReader(new FileReader("./res/Education.txt"));
				if(file_no==2)
					br=new BufferedReader(new FileReader("./res/Entertainment.txt"));
				if(file_no==3)
					br=new BufferedReader(new FileReader("./res/Food&Drink.txt"));
				if(file_no==4)
					br=new BufferedReader(new FileReader("./res/Sport.txt"));
				if(file_no==5)
					br=new BufferedReader(new FileReader("./res/Travel.txt"));
				if(file_no==6)
					br=new BufferedReader(new FileReader("./res/Work&Jobs.txt"));
				String s;
				while((s=br.readLine())!=null){
					a.add(s);
				}
			}
			catch(Exception e){
				System.out.println("Exception : "+e);
			}
		}
		//System.out.println("List is : "+a);
		Random r = new Random();
		int i=r.nextInt(a.size());
		list=(String)a.get(i);
		System.out.println("list"+list);
		a.remove(i);
		listHidden.append(list.replaceAll(".", "*"));
		correct.setText(correct.getText() + listHidden.toString());
	}

	/**
	 * Prompts the user for a new game when one game ends.
	 */
	private void newGameDialog()
	{
		int dialogResult = JOptionPane.showConfirmDialog(null, 
				"Well Done...... " +
						"\nWould You Like to Continue Saving people?",
						null,
						JOptionPane.YES_NO_OPTION);
		if (dialogResult == JOptionPane.YES_OPTION)
			reinitialize(); // re-initialize the GameBoard
		else{
			new player(id,numScore);
			dispose();
		}
	}

	private void newGameOverDialog(){

		int dialogResult = JOptionPane.showConfirmDialog(null, 
				"Game Over...... " +
						"\nWould You Like to Start a New Game?",
						"Play Again?",
						JOptionPane.YES_NO_OPTION);
		if (dialogResult == JOptionPane.YES_OPTION)
			initialize(); // re-initialize the GameBoard
		else{
			new player(id,numScore);
			dispose();
		}

	}

	/**
	 * A custom MouseListener for the LetterTiles that detects when the user
	 * "guesses" (clicks on) a LetterTile and updates the game accordingly.
	 */
	private class TileListener implements MouseListener 
	{
		@Override
		public void mousePressed(MouseEvent e) 
		{
			Object source = e.getSource();
			if(source instanceof LetterTile)
			{
				char c = ' ';
				int index = 0;
				boolean updated = false;

				// cast the source of the click to a LetterTile object
				LetterTile tilePressed = (LetterTile) source;
				c = tilePressed.guess();

				// reveal each instance of the character if it appears in the
				//     the list
				while ((index = list.toLowerCase().indexOf(c, index)) != -1)
				{
					listHidden.setCharAt(index, list.charAt(index));
					index++;
					updated = true;
				}

				// if the guess was correct, update the GameBoard and check
				//     for a win
				if (updated)
				{
					numScore=5+numScore;
					score.setText("Score: " + numScore);
					//System.out.println("Score");
					correct.setText("Word: " + listHidden.toString());
					//numScore++;

					if (listHidden.toString().equals(list))
					{
						gameRack.removeListeners();
						gameHangman.winImage();
						newGameDialog();
					}

				}

				// otherwise, add an incorrect guess and check for a loss
				else 
				{
					incorrect.setText("Incorrect: " + ++numIncorrect);
					if (numIncorrect >= MAX_INCORRECT)
					{
						gameHangman.loseImage();
						gameRack.removeListeners();
						newGameOverDialog();
					}

					else
						gameHangman.nextImage(numIncorrect);
				}
			}
		}

		// These methods must be implemented in every MouseListener
		//     implementation, but since they are not used in this application, 
		//     they contain no code

		@Override
		public void mouseClicked(MouseEvent e) {}  

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
	}
	
}
