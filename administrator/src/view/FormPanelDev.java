/*
 *
 */
package view;

import db.DeveloperHandler;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author GamyTits
 */
public class FormPanelDev extends JPanel implements ActionListener
{
	private final String TEXT_COLOUR = "#AAAAAA";
	private JPanel gridPanelTextField;
	private JPanel gridPanelButton;

	//Developer
	private JLabel     lb_listDev;
	private JTextField tf_listDev;

	//Buttons
	private JButton filter;
	private JButton create;
	private JButton update;
	private JButton delete;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	Constructor
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	public FormPanelDev()
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
				null, "In the dev zone ...", TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION,
				new Font("Dialog", 1, 12),
				new Color(250, 250, 250)));
		gridPanelTextField = new JPanel(new GridLayout(8, 2, 2, 5));
		gridPanelTextField.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		gridPanelButton = new JPanel(new GridLayout(1, 4, 9, 8));


		//Instantiane lables, annotate.
		lb_listDev = new JLabel("Developer : ", JLabel.CENTER);
		//Label text colour
		lb_listDev.setForeground(Color.decode(TEXT_COLOUR));

		//Instantiate Text fields and combo boxes
		tf_listDev = new JTextField();

		//Buttons
		filter = new JButton("filter");
		create = new JButton("new");
		update = new JButton("update");
		delete = new JButton("delete");

		// Add the grid to the main panel.
		this.add(gridPanelTextField, BorderLayout.CENTER);
		this.add(gridPanelButton, BorderLayout.SOUTH);

		// Add lables text fields and comboboxes
		gridPanelTextField.add(lb_listDev);
		gridPanelTextField.add(tf_listDev);

		// Add buttons
		gridPanelButton.add(filter);
		gridPanelButton.add(create);
		gridPanelButton.add(update);
		gridPanelButton.add(delete);

		// Pannel background colours
		this.setBackground(Color.decode("#404040"));
		gridPanelTextField.setBackground(Color.decode("#404040"));
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

		}
		else if (e.getSource() == create)
		{
			//Put values from text fields and parse into hash table.
			Map<String, Object> createDeveloperMap = new HashMap<String, Object>();
			createDeveloperMap.put("name_dev", tf_listDev.getText().toString());
			//Parse
			new DeveloperHandler().add(createDeveloperMap);
		}
		else if (e.getSource() == update)
		{
			//Put values from text fields and parse into hash table.
			Map<String, Object> createDeveloperMap = new HashMap<String, Object>();
//			createDeveloperMap.update("name_dev", tf_listDev.getText().toString());
			//Parse
			new DeveloperHandler().add(createDeveloperMap);
		}
		else if (e.getSource() == delete)
		{

		}
	}
}
