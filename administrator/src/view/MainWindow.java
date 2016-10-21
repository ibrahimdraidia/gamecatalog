/*
 * MainWindow view for the gamycatalog.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
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
