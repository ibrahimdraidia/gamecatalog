/*
 *
 */
package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author GamyCats
 */
public class FormPanel extends JPanel
{
	private final String TEXT_COLOUR = "#AAAAAA";
	private final String TEXT_FIELD = "#505050";
	private JPanel gridPanel;

	//Game
	private JLabel     lb_name_game;
	private JTextField tf_name_game;
	//Editor
	private JLabel     lb_name_editor;
	private JTextField tf_name_editor;
	//Developer
	private JLabel     lb_listDev;
	private JComboBox  cb_listDev;
	//Platform
	private JLabel     lb_platform;
	private JComboBox  cb_platform;
	//Type
	private JLabel     lb_type;
	private JComboBox  cb_type;
	//Date Sortie
	private JLabel     lb_date;
	private JTextField tf_date;
	//URL image
	private JLabel     lb_url_image;
	private JTextField tf_url_image;
	//Description
	private JLabel     lb_description;
	private JTextField tf_description;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	Constructor
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	public FormPanel()
	{
		this.setMinimumSize(getMaximumSize());
		initObjects();
	}

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	Objects
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	private void initObjects()
	{
		//Panels
		gridPanel = new JPanel(new GridLayout(5, 2, 2, 2));

		//Instantiane lables
		lb_name_game = new JLabel("Game : ",      JLabel.CENTER);
		lb_name_game.setForeground(Color.decode(TEXT_COLOUR));
		lb_name_editor = new JLabel("Editor : ",    JLabel.CENTER);
		lb_name_editor.setForeground(Color.decode(TEXT_COLOUR));
		lb_listDev = new JLabel("Developer : ", JLabel.CENTER);
		lb_listDev.setForeground(Color.decode(TEXT_COLOUR));
		lb_platform = new JLabel("Platform : ",  JLabel.CENTER);
		lb_platform.setForeground(Color.decode(TEXT_COLOUR));
		lb_type = new JLabel("Type : ",      JLabel.CENTER);
		lb_type.setForeground(Color.decode(TEXT_COLOUR));
		lb_date = new JLabel("Type : ",JLabel.CENTER);
		lb_date.setForeground(Color.decode(TEXT_COLOUR));
		lb_url_image = new JLabel("Image url : ",      JLabel.CENTER);
		lb_url_image.setForeground(Color.decode(TEXT_COLOUR));
		lb_description = new JLabel("Description : ",      JLabel.CENTER);
		lb_description.setForeground(Color.decode(TEXT_COLOUR));

		//Instantiate Text fields and combo boxes
		tf_name_game =   new JTextField();
		tf_name_editor = new JTextField();
		cb_listDev = new JComboBox<>();
		cb_platform = new JComboBox<>();
		cb_type = new JComboBox<>();
		tf_date = new JTextField();
		tf_url_image = new JTextField();
		tf_description = new JTextField();

		// TextField width
		//tf_name_game.setColumns(20);
		//tf_name_editor.setColumns(20);

		// Combox 
		cb_listDev.setEditable(true);
		cb_listDev.setMaximumRowCount(5);
		cb_listDev.setBackground(Color.decode(TEXT_FIELD));
		/**/
		cb_platform.setEditable(true);
		cb_platform.setMaximumRowCount(5);
		cb_platform.setBackground(Color.decode(TEXT_FIELD));
		/**/
		cb_type.setEditable(true);
		cb_type.setMaximumRowCount(5);
		cb_type.setBackground(Color.decode(TEXT_FIELD));

		// Add the grid to the main panel.
		this.add(gridPanel);

		// Add lables text fields and comboboxes
		gridPanel.add(lb_name_game);
		gridPanel.add(tf_name_game);
		/**/
		gridPanel.add(lb_name_editor);
		gridPanel.add(tf_name_editor);
		/**/
		gridPanel.add(lb_listDev);
		gridPanel.add(cb_listDev);
		/**/
		gridPanel.add(lb_platform);
		gridPanel.add(cb_platform);
		/**/
		gridPanel.add(lb_type);
		gridPanel.add(cb_type);

		this.setBackground(Color.decode("#404040"));
		gridPanel.setBackground(Color.decode("#404040"));
	}
}
