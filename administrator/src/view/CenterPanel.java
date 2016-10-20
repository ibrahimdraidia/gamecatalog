package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class CenterPanel extends JPanel {

	public static  JPanel tablePane = new JPanel(new BorderLayout());
	
	public CenterPanel()
	{
		setLayout(new BorderLayout());
		add(new TabPanel(null),BorderLayout.WEST);
		CenterPanel.tablePane.add(new GameTablePanel(null),BorderLayout.CENTER);
		add(CenterPanel.tablePane,BorderLayout.CENTER);
	}
}
