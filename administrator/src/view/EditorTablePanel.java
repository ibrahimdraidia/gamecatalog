/*
 *
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.EditorTableModel;
import model.GameTableModel;

/**
 *
 * @author GamyCats
 */
public class EditorTablePanel extends JPanel
{
	
	private JTable table;
	private JScrollPane scrollPane;
	private LogoPanel leds;

	public EditorTablePanel(LogoPanel logoPanel)
	{
		leds = logoPanel;
		initObject();
	}

	private void initObject()
	{
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		this.setBackground(Color.decode("#303030"));
		//this.add(new TabPanel(leds), BorderLayout.WEST);

		
		table = new JTable(new EditorTableModel());
		

		scrollPane = new JScrollPane(table);
		//boxLayout.add(scrollPane);

		//this.add(boxLayout);
		this.add(scrollPane, BorderLayout.CENTER);
	}
}
