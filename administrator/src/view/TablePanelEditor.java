/*
 *
 */
package view;

import db.EditorHandler;
import entity.Editor;
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
 * @author GamyCats
 */
public class TablePanelEditor extends JPanel
{
	
	//private JTable table;
	private JScrollPane scrollPane;
	private MainLogoPanel leds;
        
        private JList editorJList;
        private DefaultListModel listModel;

	public TablePanelEditor(MainLogoPanel logoPanel)
	{
		leds = logoPanel;
		initObject();
	}

	private void initObject()
	{
            
                this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		this.setBackground(Color.decode("#303030"));
                            
                ArrayList<Editor> listEditor =  (ArrayList<Editor>) new EditorHandler().getAll();
                listModel = new DefaultListModel();
                
                if(!listEditor.isEmpty())
		{
			for (int i = 0; i < listEditor.size(); i++) {
				if(listEditor.get(i) != null)
				{
					listModel.addElement(listEditor.get(i));
				}
			}
		}
                
                editorJList = new JList(listModel);
                
                scrollPane = new JScrollPane(editorJList);
		
		this.add(scrollPane, BorderLayout.CENTER);
		
               
            
	}
}
