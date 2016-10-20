/*
 * http://stackoverflow.com/questions/16135726/java-how-to-read-from-file-when-i-used-printwriter-bufferedwriter-and-filewri
 */
package view;

//import ja009.LCS.data.DataBase;
//import ja009.LCS.util.Util;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import javax.swing.*;
import view.LogoPanel;
import view.Icons;

/**
 *
 * @author iain
 */
public class WinLoginDb extends JDialog implements ActionListener
{
	private final MainWindow win;
	//private DataBase db;
	private JLabel title;
	private JLabel database;
	private JLabel password;
	private JLabel dbIconLabel;
	private TextField textDatabase;
	private JPasswordField textPassword;
	private JButton okButton;
	private JButton cancelButton;
	private final int BORDER = 20;
	private final int SPACER = 10;
	private boolean isErrorPass;
	private boolean isErrorData;
	private String text = "";
	private String pass = "";
	private String[] wordlist = {"", ""};
	//private Util util;
	private LogoPanel leds;
	private Icons icons;

	/*
	 * Constructor, the main window is parsed into the constructor which allows
	 * the main window to be included in the 'setLocationRelativeTo()'; To 
	 * center the database dialog in the main window.
	 */
	public WinLoginDb(MainWindow win) throws IOException
	{
		this.win = win;
		super.setSize(500, 320);
		super.setLocationRelativeTo(this.win);
		super.setTitle("Database Connect");
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException | InstantiationException |
				IllegalAccessException | UnsupportedLookAndFeelException e) {
		}
	
		super.setVisible(true);
		this.isErrorPass = false;
		this.isErrorData = false;
		initObjects();
		initPannels();
		initListeners();
	}

	// All required objects
	private void initObjects() throws IOException
	{
		super.setModalityType(getModalityType());
		//util = new Util();
		title = new JLabel("Please enter your connection details ...");
		database = new JLabel("Database name : ");
		password = new JLabel("Password : ");
		textDatabase = new TextField(20);
		textPassword = new JPasswordField(20);
		okButton = new JButton("Ok");
		cancelButton = new JButton("Cancel");
		// Import database icon.
		dbIconLabel = icons.dbLabel70();
		textDatabase.setText(text);
		textPassword.setText(pass);
	
		setTextFieldsFromMemory();

		leds = new LogoPanel();
		icons = new Icons();
	}

	// Instantiate pannels and add all objects to them.
	private void initPannels()
	{
		/*
		 * The main window, principal BorderLayout and spacing.
		 */
		JPanel mainPanel = (JPanel) this.getContentPane();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBorder(
				BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));

		/*
		 * The north pannel, title request.
		 */
		JPanel theTopPanel = new JPanel();
		JPanel theTopLeftPanel = new JPanel();
		JPanel theTopCenterPanel = new JPanel();
		/**/
		theTopPanel.setLayout(new BorderLayout());
		theTopPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		theTopCenterPanel.setLayout(new GridLayout());
		/**/
		mainPanel.add(theTopPanel, BorderLayout.NORTH);
		theTopPanel.add(theTopLeftPanel, BorderLayout.WEST); 
		theTopPanel.add(theTopCenterPanel, BorderLayout.CENTER); 
		/**/
		theTopLeftPanel.add(dbIconLabel);
		theTopCenterPanel.add(title);

		/*
		 * The center pannels, text entry fields.
		 */
		JPanel theCenterPanel = new JPanel();
		JPanel theCenterLeftGridPanel = new JPanel();
		JPanel theCenterGridPanel = new JPanel();
		JPanel theCenterLeftFlowTop = new JPanel();
		JPanel theCenterLeftFlowBot = new JPanel();
		JPanel theCenterFlowTop = new JPanel();
		JPanel theCenterFlowBot = new JPanel();
		/**/
		theCenterPanel.setLayout(new BorderLayout());
		theCenterLeftGridPanel.setBorder(
				BorderFactory.createEmptyBorder(SPACER, SPACER, SPACER, SPACER));
		theCenterLeftGridPanel.setLayout(new GridLayout(2, 1, 10, 25));
		theCenterGridPanel.setBorder(
				BorderFactory.createEmptyBorder(SPACER, SPACER, SPACER, SPACER));
		theCenterGridPanel.setLayout(new GridLayout(2, 1, 10, 25));
		theCenterLeftFlowTop.setLayout(new FlowLayout(FlowLayout.RIGHT));
		theCenterLeftFlowBot.setLayout(new FlowLayout(FlowLayout.RIGHT));
		theCenterFlowTop.setLayout(new FlowLayout(FlowLayout.LEFT));
		theCenterFlowBot.setLayout(new FlowLayout(FlowLayout.LEFT));
		/**/
		mainPanel.add(theCenterPanel, BorderLayout.CENTER);
		theCenterPanel.add(theCenterLeftGridPanel, BorderLayout.WEST);
		theCenterPanel.add(theCenterGridPanel, BorderLayout.CENTER);
		/**/
		theCenterLeftGridPanel.add(database);
		theCenterLeftGridPanel.add(password);
		theCenterGridPanel.add(textDatabase);
		theCenterGridPanel.add(textPassword);

		/*
		 * The south button panel.
		 */
		JPanel theBottomPanel = new JPanel();
		theBottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		/**/
		mainPanel.add(theBottomPanel, BorderLayout.SOUTH);
		theBottomPanel.add(okButton);
		theBottomPanel.add(cancelButton);

		// Display the main pannel.
		mainPanel.setVisible(true);
	}

	private void initListeners()
	{
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		textPassword.addActionListener(this);
		textDatabase.addActionListener(this);
	}

	// Set connection details from file if present.
	private void setTextFieldsFromMemory() throws IOException
	{
		//TODO util
		//wordlist = util.readFromFile(wordlist);
		textDatabase.setText(wordlist[0]);
		textPassword.setText(wordlist[1]);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == okButton) {
	
			// If a pasword error has previously been signaled, reset.
			if (isErrorPass) {
				textPassword.setBackground(Color.white);
				isErrorPass = false;
			}

			// If a database error has previously been signaled, reset.
			if (isErrorData) {
				textDatabase.setBackground(Color.white);
				isErrorData = false;
			}
			//TODO db
			//db = new DataBase();
			//int state = db.connect(textDatabase.getText(), textPassword.getPassword());
	
			// Convert char[] to String.
			//TODO util
			//String word = util.charArrayToString(textPassword.getPassword());
	
			//TODO db
			//if (state == 1)
			//{
			//	leds.setGreenLedOn();
			//	//ODO util
			//	//util.writeCurrentConnectionDetails(
			//	//		textDatabase.getText(), word);
			//	this.dispose();
	
			//}
			//else if (state == 0)
			//{
			//	textDatabase.setText("Apache server not found ...");
			//	leds.setRedLedOn();
		
			//}
			//else if (state == 1049)
			//{
			//	textDatabase.setText("Database not found ...");
			//	textDatabase.setBackground(Color.PINK);
			//	isErrorData = true;
			//	leds.setRedLedOn();
			//}
			//else if (state == 1045)
			//{
			//	// Note, this does not seem to work on linux system, ok on windows.
			//	textPassword.setBackground(Color.PINK);
			//	isErrorPass = true;
			//	leds.setRedLedOn();
			//}

		}
		else if(e.getSource() == cancelButton)
		{
			this.dispose();
		}
	}
}
