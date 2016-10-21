package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class MainCenterPanel extends JPanel {

	public static  JPanel tablePane = new JPanel(new BorderLayout());
	
	public MainCenterPanel()
	{
		setLayout(new BorderLayout());
		add(new MainTabPanel(null),BorderLayout.WEST);
		MainCenterPanel.tablePane.add(new TablePanelGame(null),BorderLayout.CENTER);
		add(MainCenterPanel.tablePane,BorderLayout.CENTER);
	}
}
