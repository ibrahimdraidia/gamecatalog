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

/**
 *
 * @author GamyCats
 */
public class TablePanel extends JPanel
{
	private DefaultTableModel data;
	private JTable table;
	private JScrollPane scrollPane;
	private LogoPanel leds;

	public TablePanel(LogoPanel logoPanel)
	{
		leds = logoPanel;
		initObject();
	}

	private void initObject()
	{
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		this.setBackground(Color.decode("#303030"));
		this.add(new TabPanel(leds), BorderLayout.WEST);

		
		// Table
		String[] cols = {"Game", "Editor", "Dev", "Platform", "Type", "Date",
				"Image url", "Description"};
		data = new DefaultTableModel(cols, 0);
		table = new JTable(data);

		// Add a row.
		Object[] mess = {"JC Rigal", "jcrigal@free.fr", "hello world", 12};
		data.addRow(mess);

		scrollPane = new JScrollPane(table);
		//boxLayout.add(scrollPane);

		//this.add(boxLayout);
		this.add(scrollPane, BorderLayout.CENTER);
	}
}
