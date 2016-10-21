/*
 * MainWindow view for the gamycatalog.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author GamyCats
 */
public class MainWindow extends JFrame
{
	// Exteriour border
	private final int BORDER = 10;
	//Panels
	private JPanel mainPanel;
	private MainLogoPanel logoPanel;
	private MainTabPanel tabPanel;
	private TablePanelGame tablePanel;
	//MenuBar
	private JMenuBar menuBar;
	private JMenu menu1, menu2, menu3;
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
		super.setMinimumSize(new Dimension(1400, 800));
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);

		//initMenuBar();
		initObjects();

		super.setVisible(true);
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
		MainLogoPanel logoPanel = new MainLogoPanel();
		mainPanel.add(logoPanel, BorderLayout.NORTH);
		mainPanel.add(new MainCenterPanel(logoPanel), BorderLayout.CENTER);
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
		} catch (ClassNotFoundException | InstantiationException |
				IllegalAccessException | UnsupportedLookAndFeelException e)
		{
			System.err.println(e);
		}
	}
}
