/*
 * Images for the project.
 */
package view;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author GamyCats
 */
public class Icons
{
	private String path = "../images/";
	
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Logo
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	public Icon logo()
	{
		Icon dbIcon = createImageIcon(path+"gc-logo-s.png");
		return dbIcon;
	}

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  LED Lights
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	public Icon iconBlueLedOn30()
	{
		Icon dbIcon = createImageIcon(path+"blue_led-on-30.png");
		return dbIcon;
	}

	public Icon iconBlueLedOff30()
	{
		Icon dbIcon = createImageIcon(path+"blue_led-off-30.png");
		return dbIcon;
	}

	public Icon iconGreenLedOn30()
	{
		Icon dbIcon = createImageIcon(path+"green_led-on-30.png");
		return dbIcon;
	}

	public Icon iconGreenLedOff30()
	{
		Icon dbIcon = createImageIcon(path+"green_led-off-30.png");
		return dbIcon;
	}

	public Icon iconRedLedOn30()
	{
		Icon dbIcon = createImageIcon(path+"red_led-on-30.png");
		return dbIcon;
	}

	public Icon iconRedLedOff30()
	{
		Icon dbIcon = createImageIcon(path+"red_led-off-30.png");
		return dbIcon;
	}

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

	public JLabel labelGreenLedOn30()
	{
		ImageIcon dbicon = createImageIcon(path+"green_led-on-30.png");
		JLabel dbIcon = new JLabel(dbicon);		
		return dbIcon;
	}

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Icon factory	 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
    public ImageIcon createImageIcon(String path)
	{
        java.net.URL imgURL = Icons.class.getResource(path);
        if (imgURL != null)
		{
            return new ImageIcon(imgURL);
        }
		else
		{
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
