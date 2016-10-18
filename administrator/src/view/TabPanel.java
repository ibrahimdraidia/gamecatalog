/*
 * 
 */
package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author GamyCats
 */
public class TabPanel extends JPanel
{
	JPanel mainPanel;
	JPanel gridPanel;
	JTabbedPane tabPanel;
	FormPanel formPanel;

	public TabPanel()
	{
		initObjects();
		initPanel();
	}

	private void initObjects()
	{
		this.getParent();
		this.setBackground(Color.decode("#101010"));
		this.setLayout(new GridLayout(1, 1));
		tabPanel = new JTabbedPane();
		this.add(tabPanel);
		formPanel = new FormPanel();
		tabPanel.addTab("Data", formPanel);
	}

	private void initPanel()
	{
	}
}
