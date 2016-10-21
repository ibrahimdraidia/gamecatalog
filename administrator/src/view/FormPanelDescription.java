/*
 * Pannel description
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author GamyGits
 */
public class FormPanelDescription extends JPanel implements ActionListener
{
	private final String TEXT_COLOUR = "#AAAAAA";
	private final String TEXT_FIELD = "#404040";
	private final String HEADDER = "Gc";
	private JPanel containerPanel;
	private JPanel gridPanelText;
	private JPanel gridPanelButton;
	//Description
	private JLabel     lb_description;
	private JTextArea  ta_description;
	//Buttons
	private JButton filter;
	private JButton create;
	private JButton update;
	private JButton delete;
	private MainLogoPanel leds;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	Constructor
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	public FormPanelDescription(MainLogoPanel logoPanel)
	{
		leds = logoPanel;
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
		gridPanelButton = new JPanel(new GridLayout(1, 4, 9, 8));
		gridPanelButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));

		//Instantiane lables, annotate.
		lb_description = new JLabel("Description : ", JLabel.CENTER);
		//Label text colour
		lb_description.setForeground(Color.decode(TEXT_COLOUR));

		//Instantiate Text fields and combo boxes
		ta_description = new JTextArea(15, 24);
		ta_description.setLineWrap(true);
		JScrollPane panMsg = new JScrollPane(ta_description);

		//Buttons
		filter = new JButton("filter");
		create = new JButton("new");
		update = new JButton("update");
		delete = new JButton("delete");
		//Button colour
		filter.setBackground(Color.red);

		// Add the grid to the main panel.
		containerPanel.add(panMsg);
		this.add(containerPanel, BorderLayout.CENTER);
		this.add(gridPanelButton, BorderLayout.SOUTH);

		// Add buttons
		gridPanelButton.add(filter);
		gridPanelButton.add(create);
		gridPanelButton.add(update);
		gridPanelButton.add(delete);

		// Pannel background colours
		this.setBackground(Color.decode(TEXT_FIELD));
		this.setBackground(Color.decode(TEXT_FIELD));
		containerPanel.setBackground(Color.decode(TEXT_FIELD));
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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == filter)
		{
			
		}
		else if (e.getSource() == create)
		{
			if (ta_description.getText().trim().length() != 0)
			{
				VerifyRegex check = new VerifyRegex(3, ta_description.getText().toString());
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
			if (ta_description.getText().trim().length() != 0)
			{
				VerifyRegex check = new VerifyRegex(3, ta_description.getText().toString());
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

			Object[] options =
			{
				"Yes",
				"No"
			};

			n = JOptionPane.showOptionDialog(FormPanelDescription.this,
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
		try
		{
			//Put values from text fields and parse into hash table.
			Map<String, Object> createGameMap = new HashMap<String, Object>();
			createGameMap.put("summary_game", ta_description.getText().toString());
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
