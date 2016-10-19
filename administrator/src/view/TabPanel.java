/*
 * Opens FormPanelGame, FormPanelEditor, FormPanelDev and FormPanelPlatform
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author GamyCats
 */
public class TabPanel extends JPanel
{
	JTabbedPane tabPanelGame;
	JTabbedPane tabPanelEditor;
	JTabbedPane tabPanelDev;
	JTabbedPane tabPanel;

	public TabPanel()
	{
		initGamePanel();
	}

	private void initGamePanel()
	{
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
		this.setBackground(Color.decode("#303030"));

		// Tab panels
		tabPanelGame = new JTabbedPane();
		//New pages
		tabPanelGame.addTab("Game", new FormPanelGame());
		tabPanelGame.addTab("Editor", new FormPanelEditor());
		tabPanelGame.addTab("Dev", new FormPanelDev());
		tabPanelGame.addTab("Platform", new FormPanelPlatform());
		
		this.add(tabPanelGame);
	}
}
