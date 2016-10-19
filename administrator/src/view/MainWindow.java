/*
 * Main page view for the gamycatalog.
 */
package view;


import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;


import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author GamyCats
 */
public class MainWindow  extends JFrame
{
	// Exteriour border
	private final int BORDER = 10;

	//Panels
	private JPanel mainPanel;
	private LogoPanel logoPanel;
	private TabPanel tabPanel;
	private TablePanel tablePanel;

	//MenuBar
	private JMenuBar  menuBar;
		    JMenu     menu1,
		    		  menu2,
		    		  menu3;
	private JMenuItem connect,
		              disconnect;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	Constructor
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	public MainWindow()
	{
		testLookAndFeel();
		super.setTitle("GameCatalog");
		super.setVisible(true);
		super.setMinimumSize(new Dimension(600, 400));
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	Objects
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	private void initObjects()
	{
		/*
		 * The main window, principal BorderLayout and spacing.
		 */
		mainPanel = (JPanel) this.getContentPane();
		mainPanel.setBackground(Color.decode("#222222"));
		mainPanel.setBorder(
				BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
		mainPanel.setLayout(new BorderLayout());

		/*
		 * Set border panels.
		 */
		mainPanel.add(new LogoPanel(), BorderLayout.NORTH);
		mainPanel.add(new TablePanel(), BorderLayout.CENTER);
	}

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	Menubar
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	private void initMenuBar()
	{
		/*
		 * The menu bar.
		 */
		menuBar = new JMenuBar();
		/**/
		menu1 = new JMenu("page");
		menu2 = new JMenu("db");
		menu3 = new JMenu("info");
		/**/
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);

		// Items within the menubar ...
		connect = new JMenuItem("Connect");
		disconnect = new JMenuItem("Disconnect");
		/**/
		menu2.add(connect);
		menu2.add(disconnect);

		// MenuBar background color.
		//menuBar.setBackground(Color.decode("#252525"));

		this.setJMenuBar(menuBar);
	}

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	Misc
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	private void testLookAndFeel()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(ClassNotFoundException | InstantiationException |
				IllegalAccessException | UnsupportedLookAndFeelException e)
		{
			System.err.println(e);
		}
	}
}
