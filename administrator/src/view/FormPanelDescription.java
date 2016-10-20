/*
 * Pannel description
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

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

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	Constructor
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	public FormPanelDescription()
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
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
