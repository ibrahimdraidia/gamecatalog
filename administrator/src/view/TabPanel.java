/*
 * Opens FormPanelGame, FormPanelEditor, FormPanelDev and FormPanelPlatform
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.text.View;
import view.LogoPanel;

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
	JTabbedPane tabPanelDescription;
	LogoPanel leds;

	public TabPanel(LogoPanel logopanel)
	{
		leds = logopanel;
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
		tabPanelGame.addTab("Game", new FormPanelGame(leds));
		tabPanelGame.addTab("Editor", new FormPanelEditor(leds));
		tabPanelGame.addTab("Dev", new FormPanelDev(leds));
		tabPanelGame.addTab("Platform", new FormPanelPlatform(leds));
		tabPanelGame.addTab("Description", new FormPanelDescription(leds));
		
		this.add(tabPanelGame);
	}
}
