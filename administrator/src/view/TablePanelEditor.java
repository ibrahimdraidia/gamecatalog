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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
    
    public static int id_editor = 0;

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
                editorJList.addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						id_editor = listEditor.get(editorJList.getSelectedIndex()).getId_editor();
						FormPanelEditor.tf_name_editor.setText(editorJList.getSelectedValue().toString());
					}
				});
                
                scrollPane = new JScrollPane(editorJList);
		
		this.add(scrollPane, BorderLayout.CENTER);
		
               
            
	}
}
