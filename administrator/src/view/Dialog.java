/*
 *
 */
package view;

import javax.swing.JDialog;

/**
 *
 * @author iain
 */
public class Dialog extends JDialog
{
	private final String _message;
	private final String _header;

	Dialog(String message, String header)
	{
		_message = message;
		_header = header;

		message();
	}

	private void message()
	{
		
	}
	
}
