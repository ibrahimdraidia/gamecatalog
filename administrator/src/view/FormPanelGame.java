/*
 * Game TabPane
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author GamyCats
 */
public class FormPanelGame extends JPanel implements ActionListener
{
	private final String TEXT_COLOUR = "#AAAAAA";
	private final String TEXT_FIELD = "#505050";
	private JPanel containerPanel;
	private JPanel boxPanelLeft;
	private JPanel boxPanelRight;
	private JPanel gridPanelButton;
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
	//Buttons
	private JButton filter;
	private JButton create;
	private JButton update;
	private JButton delete;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	Constructor
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	public FormPanelGame()
	{
		initObjects();
		initListiners();
	}

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	Objects
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	private void initObjects()
	{
		//Panels
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder(
				null, "Here we go !", TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION,
				new Font("Dialog", 1, 12),
				new Color(250, 250, 250)));
		containerPanel = new JPanel();
		boxPanelLeft = new JPanel();
		boxPanelLeft.setLayout(new BoxLayout(boxPanelLeft, BoxLayout.Y_AXIS));
		boxPanelRight = new JPanel();
		boxPanelRight.setLayout(new BoxLayout(boxPanelRight, BoxLayout.Y_AXIS));
		gridPanelButton = new JPanel(new GridLayout(1, 4, 9, 8));
		gridPanelButton.setBorder(BorderFactory.createEmptyBorder(50, 5, 5, 5));


		//Instantiane lables, annotate.
		lb_name_game = new JLabel("Game : ", JLabel.CENTER);
		lb_name_editor = new JLabel("Editor : ", JLabel.CENTER);
		lb_listDev = new JLabel("Developer : ", JLabel.CENTER);
		lb_platform = new JLabel("Platform : ", JLabel.CENTER);
		lb_type = new JLabel("Type : ", JLabel.CENTER);
		lb_date = new JLabel("Date : ", JLabel.CENTER);
		lb_url_image = new JLabel("Image url : ", JLabel.CENTER);
		lb_description = new JLabel("Description : ", JLabel.CENTER);
		//Label text colour
		lb_name_game.setForeground(Color.decode(TEXT_COLOUR));
		lb_name_editor.setForeground(Color.decode(TEXT_COLOUR));
		lb_listDev.setForeground(Color.decode(TEXT_COLOUR));
		lb_platform.setForeground(Color.decode(TEXT_COLOUR));
		lb_type.setForeground(Color.decode(TEXT_COLOUR));
		lb_date.setForeground(Color.decode(TEXT_COLOUR));
		lb_url_image.setForeground(Color.decode(TEXT_COLOUR));
		lb_description.setForeground(Color.decode(TEXT_COLOUR));

		//Instantiate Text fields and combo boxes
		tf_name_game = new JTextField();
		tf_name_editor = new JTextField();
		cb_listDev = new JComboBox<>();
		cb_platform = new JComboBox<>();
		cb_type = new JComboBox<>();
		tf_date = new JTextField();
		tf_url_image = new JTextField();
		tf_description = new JTextField();

		// Combox setup.
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

		//Buttons
		filter = new JButton("filter");
		create = new JButton("new");
		update = new JButton("update");
		delete = new JButton("delete");

		// Add the grid to the main panel.
		//this.add(borderPanelVertical);
		containerPanel.add(boxPanelLeft);
		containerPanel.add(boxPanelRight);
		this.add(containerPanel, BorderLayout.CENTER);
		this.add(gridPanelButton, BorderLayout.SOUTH);

		// Add lables text fields and comboboxes
		boxPanelLeft.add(lb_name_game);
		boxPanelLeft.add(lb_name_editor);
		boxPanelLeft.add(lb_listDev);
		boxPanelLeft.add(lb_platform);
		boxPanelLeft.add(lb_type);
		boxPanelLeft.add(lb_date);
		boxPanelLeft.add(lb_url_image);
		boxPanelLeft.add(lb_description);

		boxPanelRight.add(tf_name_game);
		boxPanelRight.add(tf_name_editor);
		boxPanelRight.add(cb_listDev);
		boxPanelRight.add(cb_platform);
		boxPanelRight.add(cb_type);
		boxPanelRight.add(tf_date);
		boxPanelRight.add(tf_url_image);
		boxPanelRight.add(tf_description);

		// Add buttons
		gridPanelButton.add(filter);
		gridPanelButton.add(create);
		gridPanelButton.add(update);
		gridPanelButton.add(delete);

		// Pannel background colours
		this.setBackground(Color.decode("#404040"));
		this.setBackground(Color.decode("#404040"));
		containerPanel.setBackground(Color.decode("#404040"));
		boxPanelLeft.setBackground(Color.decode("#404040"));
		boxPanelRight.setBackground(Color.decode("#404040"));
		gridPanelButton.setBackground(Color.decode("#404040"));
	}

	private void initListiners()
	{
		// Listeners
		filter.addActionListener(this);
		create.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == filter)
		{
			System.out.println("Groovy choosy.");
		}
		else if (e.getSource() == create)
		{
			System.out.println("Groovy choosy.");
		}
		else if (e.getSource() == update)
		{
			System.out.println("Groovy choosy.");
		}
		else if (e.getSource() == delete)
		{
			System.out.println("Groovy choosy.");
		}
	}
}
