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
		lb_platform = new JLabel("Platform : ", JLabel.CENTER);
		//Label text colour
		lb_platform.setForeground(Color.decode(TEXT_COLOUR));

		//Instantiate Text fields and combo boxes
		tf_platform = new JTextField();

		//TextField columns
		tf_platform.setColumns(TEXT_FIELD_WIDTH);

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
		left1.add(lb_platform);
		/**/
		right1.add(tf_platform);
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
