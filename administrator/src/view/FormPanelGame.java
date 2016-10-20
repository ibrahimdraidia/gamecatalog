/*
 * Game TabPane
 */
package view;

import db.GameHandler;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author GamyCats
 */
public class FormPanelGame extends JPanel implements ActionListener
{
	private final String TEXT_COLOUR = "#AAAAAA";
	private final String TEXT_FIELD = "#404040";
	private final String HEADDER = "Gc";
	private final int TEXT_FIELD_WIDTH = 11;
	private JPanel containerPanel;
	private JPanel left1;
	private JPanel left2;
	private JPanel left3;
	private JPanel left4;
	private JPanel left5;
	private JPanel left6;
	private JPanel left7;
	private JPanel left8;
	private JPanel right1;
	private JPanel right2;
	private JPanel right3;
	private JPanel right4;
	private JPanel right5;
	private JPanel right6;
	private JPanel right7;
	private JPanel right8;
	private JPanel gridPanelText;
	private JPanel gridPanelButton;
	//Game
	private JLabel     lb_name_game;
	private JTextField tf_name_game;
	//Editor
	private JLabel     lb_name_editor;
	private JComboBox  cb_name_editor;
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
				null, HEADDER, TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION,
				new Font("Dialog", 1, 12),
				new Color(250, 250, 250)));
		containerPanel = new JPanel();
		gridPanelText = new JPanel();
		gridPanelText.setLayout(new GridLayout(8, 2, 2, 2));
		gridPanelText.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
		left1 = new JPanel();
		left2 = new JPanel();
		left3 = new JPanel();
		left4 = new JPanel();
		left5 = new JPanel();
		left6 = new JPanel();
		left7 = new JPanel();
		left8 = new JPanel();
		right1= new JPanel();
		right2= new JPanel();
		right3= new JPanel();
		right4= new JPanel();
		right5= new JPanel();
		right6= new JPanel();
		right7= new JPanel();
		right8= new JPanel();
		gridPanelButton = new JPanel(new GridLayout(1, 4, 9, 8));
		gridPanelButton.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));

		//Instantiane lables, annotate.
		lb_name_game = new JLabel("Game : ", JLabel.CENTER);
		lb_name_editor = new JLabel("Editor : ", JLabel.CENTER);
		lb_listDev = new JLabel("Devteam : ", JLabel.CENTER);
		lb_platform = new JLabel("Platform : ", JLabel.CENTER);
		lb_type = new JLabel("Genre : ", JLabel.CENTER);
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
		cb_name_editor = new JComboBox<Object>();
		cb_listDev = new JComboBox<>();
		cb_platform = new JComboBox<>();
		cb_type = new JComboBox<>();
		tf_date = new JTextField();
		tf_url_image = new JTextField();
		tf_description = new JTextField();

		//TextField columns
		tf_name_game.setColumns(TEXT_FIELD_WIDTH);
		tf_date.setColumns(TEXT_FIELD_WIDTH);
		tf_url_image.setColumns(TEXT_FIELD_WIDTH);
		tf_description.setColumns(TEXT_FIELD_WIDTH);

		// Combox setup.
		cb_name_editor.setEditable(true);
		cb_name_editor.setMaximumRowCount(5);
		cb_name_editor.setBackground(Color.decode(TEXT_FIELD));
		/**/
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
		//Button colour
		filter.setBackground(Color.red);

		// Add the grid to the main panel.
		containerPanel.add(gridPanelText);
		this.add(containerPanel, BorderLayout.CENTER);
		this.add(gridPanelButton, BorderLayout.SOUTH);

		// Add lables text fields and comboboxes
		left1.add(lb_name_game);
		left2.add(lb_name_editor);
		left3.add(lb_listDev);
		left4.add(lb_platform);
		left5.add(lb_type);
		left6.add(lb_date);
		left7.add(lb_url_image);
		left8.add(lb_description);
		/**/
		right1.add(tf_name_game);
		right2.add(cb_name_editor);
		right3.add(cb_listDev);
		right4.add(cb_platform);
		right5.add(cb_type);
		right6.add(tf_date);
		right7.add(tf_url_image);
		right8.add(tf_description);
		/**/
		gridPanelText.add(left1);
		gridPanelText.add(right1);
		gridPanelText.add(left2);
		gridPanelText.add(right2);
		gridPanelText.add(left3);
		gridPanelText.add(right3);
		gridPanelText.add(left4);
		gridPanelText.add(right4);
		gridPanelText.add(left5);
		gridPanelText.add(right5);
		gridPanelText.add(left6);
		gridPanelText.add(right6);
		gridPanelText.add(left7);
		gridPanelText.add(right7);
		gridPanelText.add(left8);
		gridPanelText.add(right8);

		// Add buttons
		gridPanelButton.add(filter);
		gridPanelButton.add(create);
		gridPanelButton.add(update);
		gridPanelButton.add(delete);

		// Pannel background colours
		this.setBackground(Color.decode(TEXT_FIELD));
		this.setBackground(Color.decode(TEXT_FIELD));
		containerPanel.setBackground(Color.decode(TEXT_FIELD));
		left1.setBackground(Color.decode(TEXT_FIELD));
		left2.setBackground(Color.decode(TEXT_FIELD));
		left3.setBackground(Color.decode(TEXT_FIELD));
		left4.setBackground(Color.decode(TEXT_FIELD));
		left5.setBackground(Color.decode(TEXT_FIELD));
		left6.setBackground(Color.decode(TEXT_FIELD));
		left7.setBackground(Color.decode(TEXT_FIELD));
		left8.setBackground(Color.decode(TEXT_FIELD));
		right1.setBackground(Color.decode(TEXT_FIELD));
		right2.setBackground(Color.decode(TEXT_FIELD));
		right3.setBackground(Color.decode(TEXT_FIELD));
		right4.setBackground(Color.decode(TEXT_FIELD));
		right5.setBackground(Color.decode(TEXT_FIELD));
		right6.setBackground(Color.decode(TEXT_FIELD));
		right7.setBackground(Color.decode(TEXT_FIELD));
		right8.setBackground(Color.decode(TEXT_FIELD));
		gridPanelText.setBackground(Color.decode(TEXT_FIELD));
		gridPanelButton.setBackground(Color.decode(TEXT_FIELD));
	}

	private void initListiners()
	{
		// Listeners
		filter.addActionListener(this);
		create.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
	}

	/*
	 * Effectivly the projects controlers are run from the listeners here.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == filter)
		{
			
		}
		else if (e.getSource() == create)
		{
			if (tf_date.getText().trim().length() != 0)
			{
				VerifyRegex check = new VerifyRegex(1, tf_date.getText().toString());
				if (!check.validate())
				{
					showMessageDialog(
							null, "Incorect date format, please use YYYY-MM-DD",
							"Format date", ERROR_MESSAGE);
					System.out.println("Incorect date format");
				}
				else
				{
					createGame();
				}
			}
			else if(tf_url_image.getText().trim().length() != 0)
			{
				VerifyRegex check = new VerifyRegex(2, tf_url_image.getText().toString());
				if (!check.validate())
				{
					showMessageDialog(
							null, "Incorect format for URL", "Format URL", WARNING_MESSAGE);
					System.out.println("Incorect data entry format for URL");
				}
				else
				{
					createGame();
				}
			}
			else if (tf_description.getText().trim().length() != 0)
			{
				VerifyRegex check = new VerifyRegex(3, tf_description.getText().toString());
				if (!check.validate())
				{
					showMessageDialog(
							null, "Description is limited to 1000 characters",
							"Format description", WARNING_MESSAGE);
					System.out.println("Description is limited to 1000 characters");
				}
				else
				{
					createGame();
				}
			}
			else
			{
				createGame();
			}
		}
		else if (e.getSource() == update)
		{
			//Put values from text fields and parse into hash table.
			Map<String, Object> createGameMap = new HashMap<String, Object>();
			createGameMap.put("name_game", tf_name_game.getText().toString());
			createGameMap.put("release_date", "1990-11-21");
			createGameMap.put("pic_game", tf_url_image.getText().toString());
			createGameMap.put("summary_game", tf_description.getText().toString());
			//Parse 
			new GameHandler().add(createGameMap);
		}
		else if (e.getSource() == delete)
		{
			int n;

			Object[] options =
			{
				"Yes",
				"No"
			};

			n = JOptionPane.showOptionDialog(FormPanelGame.this,
					"Are you sure that you want to proceed? \n"
							+ "the current record will be\npermanantly deleted.",
					"Carfull",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[1]);

			System.out.println("Going, going, ...");

			if (n == JOptionPane.OK_OPTION)
			{
				System.out.println("Gone!");
			}
		}
	}

	private void createGame()
	{
		//Put values from text fields and parse into hash table.
		Map<String, Object> createGameMap = new HashMap<String, Object>();
		createGameMap.put("name_game", tf_name_game.getText().toString());
		createGameMap.put("release_date", "1990-11-21");
		createGameMap.put("pic_game", tf_url_image.getText().toString());
		createGameMap.put("summary_game", tf_description.getText().toString());
		//Parse 
		new GameHandler().add(createGameMap);
	}
}

