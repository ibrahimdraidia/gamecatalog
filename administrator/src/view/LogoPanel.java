/*
 * Logos, something with wings perhaps? ... Funky!
 */
package view;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author GamyCats
 */
public class LogoPanel extends JPanel
{
	private JPanel logoPanel;
	private JLabel logo;

	public LogoPanel()
	{
		initObjects();
	}

	private void initObjects()
	{
		this.getParent();
		this.setBackground(Color.decode("#303030"));

		Icons icons = new Icons();
		logo = new JLabel(icons.logo());

		this.add(logo);

		//TODO why does the color make the panel dissapear?

		//logoPanel = new JPanel();:w
		//mainPanel.add(logoPanel);
		//logoPanel.setBackground(Color.red);
	}
}
