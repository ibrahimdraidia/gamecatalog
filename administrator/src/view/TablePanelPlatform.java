/*
 *
 */
package view;

import db.DeveloperHandler;
import db.PlatformHandler;
import entity.Developer;
import entity.Platform;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Nicolas
 */
public class TablePanelPlatform extends JPanel
{
	
	//private JTable table;
	private JScrollPane scrollPane;
	private MainLogoPanel leds;
        
    private JList platformJList;
    private DefaultListModel listModel;
    
 // entity id's
 	public static int id_platform = 0;

	public TablePanelPlatform(MainLogoPanel logoPanel)
	{
		leds = logoPanel;
		initObject();
	}

	private void initObject()
	{
            
                this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		this.setBackground(Color.decode("#303030"));
                            
                ArrayList<Platform> listPlatform =  (ArrayList<Platform>) new PlatformHandler().getAll();
                listModel = new DefaultListModel();
                
                if(!listPlatform.isEmpty())
		{
			for (int i = 0; i < listPlatform.size(); i++) {
				if(listPlatform.get(i) != null)
				{
					listModel.addElement(listPlatform.get(i));
				}
			}
		}
                
                platformJList = new JList(listModel);
                platformJList.addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						FormPanelPlatform.tf_platform.setText(platformJList.getSelectedValue().toString());
						id_platform = listPlatform.get(platformJList.getSelectedIndex()).getId_platform();
					}
				});
                scrollPane = new JScrollPane(platformJList);
		
		this.add(scrollPane, BorderLayout.CENTER);
		
               
	}
}

