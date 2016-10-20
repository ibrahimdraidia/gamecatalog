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

import model.GameTableModel;

/**
 *
 * @author GamyCats
 */
public class GameTablePanel extends JPanel
{
	
	private JTable table;
	private JScrollPane scrollPane;
	private LogoPanel leds;

	public GameTablePanel(LogoPanel logoPanel)
	{
		leds = logoPanel;
		initObject();
	}

	private void initObject()
	{
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		this.setBackground(Color.decode("#303030"));
		
		table = new JTable(new GameTableModel());
		

		scrollPane = new JScrollPane(table);
		
		this.add(scrollPane, BorderLayout.CENTER);
	}
}
