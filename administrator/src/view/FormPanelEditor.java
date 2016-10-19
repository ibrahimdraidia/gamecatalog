/*
 * Editor TabPane
 */
package view;

import db.EditorHandler;
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
 * @author GamyGits
 */
public class FormPanelEditor extends JPanel implements ActionListener
{
	private final String TEXT_COLOUR = "#AAAAAA";
	private JPanel panelTextField;
	private JPanel panelButton;
	//Editor
	private JLabel     lb_name_editor;
	private JTextField tf_name_editor;
	//Buttons
	private JButton filter;
	private JButton create;
	private JButton update;
	private JButton delete;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	Constructor
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	public FormPanelEditor()
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
				null, "Edit baby !", TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION,
				new Font("Dialog", 1, 12),
				new Color(250, 250, 250)));
		panelTextField = new JPanel(new GridLayout(8, 2, 2, 2));
		panelTextField.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		panelButton = new JPanel(new GridLayout(1, 3, 9, 2));

		//Instantiane lables
		lb_name_editor = new JLabel("Editor : ", JLabel.CENTER);

		//Set label text colour.
		lb_name_editor.setForeground(Color.decode(TEXT_COLOUR));

		//Instantiate Text fields and combo boxes
		tf_name_editor = new JTextField();

		//Buttons
		filter = new JButton("Filter");
		create = new JButton("new");
		update = new JButton("update");
		delete = new JButton("delete");

		// Add the grid to the main panel.
		this.add(panelTextField, BorderLayout.CENTER);
		this.add(panelButton, BorderLayout.SOUTH);

		// Add lables text fields and comboboxes
		panelTextField.add(lb_name_editor);
		panelTextField.add(tf_name_editor);

		// Add buttons
		panelButton.add(filter);
		panelButton.add(create);
		panelButton.add(update);
		panelButton.add(delete);

		// Colours
		this.setBackground(Color.decode("#404040"));
		panelTextField.setBackground(Color.decode("#404040"));
		panelButton.setBackground(Color.decode("#404040"));
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
			Map<String, Object> createEditorMap = new HashMap<String, Object>();
			createEditorMap.put("name_editor", tf_name_editor.getText().toString());
			//Parse hashtable into handeler class.
			new EditorHandler().add(createEditorMap);
		}
		else if (e.getSource() == update)
		{
			//Put values from text fields and parse into hash table.
			Map<String, Object> createEditorMap = new HashMap<String, Object>();
			createEditorMap.put("name_editor", tf_name_editor.getText().toString());
			//Parse hashtable into handeler class.
			new EditorHandler().add(createEditorMap);
		}
		else if (e.getSource() == delete)
		{
		}
	}
}
