/*
 * Platform TabPane
 */
package view;

import db.PlatformHandler;
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
 * @author GamyWits
 */
public class FormPanelPlatform extends JPanel implements ActionListener
{
	private final String TEXT_COLOUR = "#AAAAAA";
	private JPanel gridPanelTextField;
	private JPanel gridPanelButton;

	//Platform
	private JLabel     lb_platform;
	private JTextField tf_platform;

	//Buttons
	private JButton filter;
	private JButton create;
	private JButton update;
	private JButton delete;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	Constructor
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	public FormPanelPlatform()
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
				null, "Platforms, say no more", TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION,
				new Font("Dialog", 1, 12),
				new Color(250, 250, 250)));
		gridPanelTextField = new JPanel(new GridLayout(8, 2, 2, 5));
		gridPanelTextField.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		gridPanelButton = new JPanel(new GridLayout(1, 4, 9, 8));


		//Instantiane lables, annotate.
		lb_platform = new JLabel("Platform : ", JLabel.CENTER);
		//Label text colour
		lb_platform.setForeground(Color.decode(TEXT_COLOUR));

		//Instantiate Text fields and combo boxes
		tf_platform = new JTextField();

		//Buttons
		filter = new JButton("filter");
		create = new JButton("new");
		update = new JButton("update");
		delete = new JButton("delete");

		// Add the grid to the main panel.
		this.add(gridPanelTextField, BorderLayout.CENTER);
		this.add(gridPanelButton, BorderLayout.SOUTH);

		// Add lables text fields and comboboxes
		gridPanelTextField.add(lb_platform);
		gridPanelTextField.add(tf_platform);

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
			Map<String, Object> createPlatformMap = new HashMap<String, Object>();
			createPlatformMap.put("name_platform", tf_platform.getText().toString());
			//Parse 
			new PlatformHandler().add(createPlatformMap);
		}
		else if (e.getSource() == update)
		{
			//Put values from text fields and parse into hash table.
			Map<String, Object> createPlatformMap = new HashMap<String, Object>();
			createPlatformMap.put("name_platform", tf_platform.getText().toString());
			//Parse 
			new PlatformHandler().add(createPlatformMap);
		}
		else if (e.getSource() == delete)
		{

		}
	}
}
