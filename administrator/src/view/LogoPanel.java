/*
 * Logos, something with wings perhaps? ... Funky!
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author GamyCats
 */
public class LogoPanel extends JPanel
{
	private JPanel flowRight;
	private JLabel logo;
	private JLabel greenLed;
	private JLabel redLed;

	public LogoPanel()
	{
		initObjects();
	}

	private void initObjects()
	{
		this.setBackground(Color.decode("#303030"));
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(15,15,5,15));

		// Set the logo
		Icons icons = new Icons();
		logo = new JLabel(icons.logo());
		this.add(logo, BorderLayout.WEST);

		// Set the leds
		greenLed = new JLabel(icons.iconGreenLedOn50());
		redLed = new JLabel(icons.iconRedLedOff50());

		flowRight = new JPanel();
		flowRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
		flowRight.setBackground(Color.decode("#303030"));
		this.add(flowRight, BorderLayout.EAST);

		flowRight.add(greenLed);
		flowRight.add(redLed);
	}
}
