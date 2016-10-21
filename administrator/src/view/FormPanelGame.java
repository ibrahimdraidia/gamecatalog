/*
 * Game TabPane
 */
package view;

import db.DeveloperHandler;
import db.EditorHandler;
import db.GameHandler;
import db.PlatformHandler;
import db.TypeHandler;
import entity.Developer;
import entity.Editor;
import entity.Platform;
import entity.Type;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
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
	private final String COMBO_WIDTH = "XXXXXXXXXXXXXX";
	private final int TEXT_FIELD_WIDTH = 12;
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
	private MainLogoPanel leds;
	
	// Entity ID's
	private int id_editor = 0;
	private int id_developer = 0;
	private int id_platfom = 0;
	private int id_type = 0;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	Constructor
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	public FormPanelGame(MainLogoPanel logoPanel)
	{
		leds = logoPanel;
		initObjects();
		initListiners();
	}

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	Objects
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	@SuppressWarnings("unchecked")
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
		
		
		/*
		 *  Editors List
		 */
		ArrayList<Editor> listEditor =  (ArrayList<Editor>) new EditorHandler().getAll();
		cb_name_editor = new JComboBox<>();
		cb_name_editor.setEditable(false);
		if(!listEditor.isEmpty())
		{
			for (int i = 0; i < listEditor.size(); i++) {
				if(listEditor.get(i) != null)
				{
					cb_name_editor.addItem(listEditor.get(i));
				}
			}
		}
		
		
		/*
		 * Developers list
		 */
		ArrayList<Developer> listDevlopers =  (ArrayList<Developer>) new DeveloperHandler().getAll();
		cb_listDev = new JComboBox<>();
		cb_listDev.setEditable(false);
		
		if(!listDevlopers.isEmpty())
		{
			for (int i = 0; i < listDevlopers.size(); i++) {
				if(listDevlopers.get(i) != null)
				{
					cb_listDev.addItem(listDevlopers.get(i));
				}
			}
		}
		
		
		/*
		 * Platform list
		 */
		ArrayList<Platform> listPlatforms =  (ArrayList<Platform>) new PlatformHandler().getAll();
		ArrayList<String> listNamePlatform = new ArrayList<>();
		cb_platform = new JComboBox<>();
		cb_platform.setEditable(false);
		if(!listPlatforms.isEmpty())
		{
			for (int i = 0; i < listPlatforms.size(); i++) {
				if(listPlatforms.get(i) != null)
				{
					cb_platform.addItem(listPlatforms.get(i));
				}
			}
		}
		
		
		/*
		 * Type list
		 */
		ArrayList<Type> listTypes =  (ArrayList<Type>) new TypeHandler().getAll();
		cb_type = new JComboBox<>();
		cb_type.setEditable(false);
		if(!listTypes.isEmpty())
		{
			for (int i = 0; i < listTypes.size(); i++) {
				if(listTypes.get(i) != null)
				{
					cb_type.addItem(listTypes.get(i));
				}
			}
		}
		
		
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
		cb_name_editor.setPrototypeDisplayValue(COMBO_WIDTH);
		/**/
		cb_listDev.setEditable(true);
		cb_listDev.setMaximumRowCount(5);
		cb_listDev.setBackground(Color.decode(TEXT_FIELD));
		cb_listDev.setPrototypeDisplayValue(COMBO_WIDTH);
		/**/
		cb_platform.setEditable(true);
		cb_platform.setMaximumRowCount(5);
		cb_platform.setBackground(Color.decode(TEXT_FIELD));
		cb_platform.setPrototypeDisplayValue(COMBO_WIDTH);
		/**/
		cb_type.setEditable(true);
		cb_type.setMaximumRowCount(5);
		cb_type.setBackground(Color.decode(TEXT_FIELD));
		cb_type.setPrototypeDisplayValue(COMBO_WIDTH);

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
		/**/
		cb_name_editor.addActionListener(this);
		cb_listDev.addActionListener(this);
		cb_platform.addActionListener(this);
		cb_type.addActionListener(this);
	}

	/*
	 * Effectivly the projects controlers are run from the listeners here.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//Buttons
		if(e.getSource() == filter)
		{
			
		}
		else if (e.getSource() == create)
		{
			if (tf_name_game.getText().trim().length() == 0)
			{
				leds.setLedAlert();
				showMessageDialog(
						null, "You must provide a name\nfor each new record",
						"Format date", ERROR_MESSAGE);
				System.out.println("Incorect date format");
				leds.setLedNormal();
			}
			else if (tf_date.getText().trim().length() != 0)
			{
				// Check date before write ...
				VerifyRegex check = new VerifyRegex(1, tf_date.getText().toString());
				if (!check.validate())
				{
					leds.setLedAlert();
					showMessageDialog(
							null, "Incorect date format, please use YYYY-MM-DD",
							"Format date", ERROR_MESSAGE);
					System.out.println("Incorect date format");
					leds.setLedNormal();
				}
				else
				{
					createGame();
				}
			}
			else if(tf_url_image.getText().trim().length() != 0)
			{
				// Check format of url before write ...
				VerifyRegex check = new VerifyRegex(2, tf_url_image.getText().toString());
				if (!check.validate())
				{
					leds.setLedAlert();
					showMessageDialog(
							null, "Incorect format for URL", "Format URL", WARNING_MESSAGE);
					System.out.println("Incorect data entry format for URL");
					leds.setLedNormal();
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
					leds.setLedAlert();
					showMessageDialog(
							null, "Description is limited to 1000 characters",
							"Format description", WARNING_MESSAGE);
					System.out.println("Description is limited to 1000 characters");
					leds.setLedNormal();
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
			if (tf_name_game.getText().trim().length() == 0)
			{
				leds.setLedAlert();
				showMessageDialog(
						null, "You must provide a name\nfor this record",
						"Format date", ERROR_MESSAGE);
				System.out.println("Incorect date format");
				leds.setLedNormal();
			}
			else if (tf_date.getText().trim().length() != 0)
			{
				VerifyRegex check = new VerifyRegex(1, tf_date.getText().toString());
				if (!check.validate())
				{
					leds.setLedAlert();
					showMessageDialog(
							null, "Incorect date format, please use YYYY-MM-DD",
							"Format date", ERROR_MESSAGE);
					System.out.println("Incorect date format");
					leds.setLedNormal();
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
					leds.setLedAlert();
					showMessageDialog(
							null, "Incorect format for URL", "Format URL", WARNING_MESSAGE);
					System.out.println("Incorect data entry format for URL");
					leds.setLedNormal();
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
					leds.setLedAlert();
					showMessageDialog(
							null, "Description is limited to 1000 characters",
							"Format description", WARNING_MESSAGE);
					System.out.println("Description is limited to 1000 characters");
					leds.setLedNormal();
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
		else if (e.getSource() == delete)
		{
			int n;

			// Yes no option befor erase data.
			Object[] options =
			{
				"Yes",
				"No"
			};

			n = JOptionPane.showOptionDialog(FormPanelGame.this,
					"Are you sure that you want to proceed? \n"
							+ "the current record will be\npermanantly deleted,\n"
							+ "note that related records will not be effected.",
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
		//COmboBoxes
		else if (e.getSource() == cb_name_editor)
		{
			Editor editor = (Editor)cb_name_editor.getSelectedItem();
			id_editor = editor.getId_editor();
		}
		else if (e.getSource() == cb_listDev)
		{
			Developer developer = (Developer)cb_listDev.getSelectedItem();
			id_developer = developer.getId_developer();
		}
		else if (e.getSource() == cb_platform)
		{
			Platform platform = (Platform)cb_platform.getSelectedItem();
			id_editor = platform.getId_platform();
		}
		else if (e.getSource() == cb_type)
		{
			Type type = (Type)cb_type.getSelectedItem();
			id_type = type.getId_type();
		}
	}

	private void createGame()
	{
		try
		{
			//Put values from text fields and parse into hash table.
			Map<String, Object> createGameMap = new HashMap<String, Object>();
			createGameMap.put("name_game", tf_name_game.getText().toString());
			createGameMap.put("release_date", "1990-11-21");
			createGameMap.put("pic_game", tf_url_image.getText().toString());
			createGameMap.put("summary_game", tf_description.getText().toString());
			createGameMap.put("id_editor", id_editor);
			createGameMap.put("id_developer", id_developer);
			createGameMap.put("id_platform", id_platfom);
			createGameMap.put("id_type", id_type);
			//Parse 
			new GameHandler().add(createGameMap);
		}
		catch (Exception e)
		{
			leds.setGreenLedOff();
			leds.setRedLedOn();
			showMessageDialog(
					null, "Write error ...",
					"Format description", WARNING_MESSAGE);
			leds.setRedLedOff();
			leds.setGreenLedOn();
		}
	}
}
