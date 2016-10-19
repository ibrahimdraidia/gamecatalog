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
	public Icon iconGreenLedOn50()
	{
		Icon dbIcon = createImageIcon(path+"green_led-on-50.png");
		return dbIcon;
	}

	public Icon iconGreenLedOff50()
	{
		Icon dbIcon = createImageIcon(path+"green_led-off-50.png");
		return dbIcon;
	}

	public Icon iconRedLedOn50()
	{
		Icon dbIcon = createImageIcon(path+"red_led-on-50.png");
		return dbIcon;
	}

	public Icon iconRedLedOff50()
	{
		Icon dbIcon = createImageIcon(path+"red_led-off-50.png");
		return dbIcon;
	}

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

	public JLabel labelGreenLedOn50()
	{
		ImageIcon dbicon = createImageIcon(path+"green_led-on-50.png");
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
