package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class MainCenterPanel extends JPanel {

	public static  JPanel tablePane = new JPanel(new BorderLayout());
	public static MainLogoPanel logoPanel;
	
	public MainCenterPanel(MainLogoPanel logoPanel)
	{
		setLayout(new BorderLayout());
		this.add(new MainTabPanel(logoPanel),BorderLayout.WEST);
		MainCenterPanel.tablePane.add(new TablePanelGame(logoPanel),BorderLayout.CENTER);
		this.add(MainCenterPanel.tablePane,BorderLayout.CENTER);
	}
}
