/*
 *
 */
package view;

import db.DeveloperHandler;
import entity.Developer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Nicolas
 */
public class TablePanelDev extends JPanel
{
	
	//private JTable table;
	private JScrollPane scrollPane;
	private MainLogoPanel leds;
        
        private JList devJList;
        private DefaultListModel listModel;

	public TablePanelDev(MainLogoPanel logoPanel)
	{
		leds = logoPanel;
		initObject();
	}

	private void initObject()
	{
            
                this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		this.setBackground(Color.decode("#303030"));
                            
                ArrayList<Developer> listDev =  (ArrayList<Developer>) new DeveloperHandler().getAll();
                listModel = new DefaultListModel();
                
                if(!listDev.isEmpty())
		{
			for (int i = 0; i < listDev.size(); i++) {
				if(listDev.get(i) != null)
				{
					listModel.addElement(listDev.get(i));
				}
			}
		}
                
                devJList = new JList(listModel);
                
                scrollPane = new JScrollPane(devJList);
		
		this.add(scrollPane, BorderLayout.CENTER);
		
               
	}
}

