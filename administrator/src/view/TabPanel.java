/*
 * Opens FormPanelGame, FormPanelEditor, FormPanelDev and FormPanelPlatform
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.View;
import view.LogoPanel;

/**
 *
 * @author GamyCats
 */
public class TabPanel extends JPanel
{
	JTabbedPane tabPanelGame;
	JTabbedPane tabPanelEditor;
	JTabbedPane tabPanelDev;
	JTabbedPane tabPanel;
	JTabbedPane tabPanelDescription;
	LogoPanel leds;

	public TabPanel(LogoPanel logopanel)
	{
		leds = logopanel;
		initGamePanel();
	}

	private void initGamePanel()
	{
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
		this.setBackground(Color.decode("#303030"));

		// Tab panels
		tabPanelGame = new JTabbedPane();
		//New pages
		tabPanelGame.addTab("Game", new FormPanelGame(leds));
		tabPanelGame.addTab("Editor", new FormPanelEditor(leds));
		tabPanelGame.addTab("Dev", new FormPanelDev(leds));
		tabPanelGame.addTab("Platform", new FormPanelPlatform(leds));
		tabPanelGame.addTab("Description", new FormPanelDescription(leds));
		
		this.add(tabPanelGame);
		
		tabPanelGame.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
			
				switch (tabPanelGame.getSelectedIndex()) {
				case 0:
					CenterPanel.tablePane.removeAll();
					CenterPanel.tablePane.add(new GameTablePanel(new LogoPanel()), BorderLayout.CENTER);
					CenterPanel.tablePane.revalidate();
					break;
				case 1:
					CenterPanel.tablePane.removeAll();
					CenterPanel.tablePane.add(new EditorTablePanel(new LogoPanel()), BorderLayout.CENTER);
					CenterPanel.tablePane.revalidate();
					break;
				case 2:
                                        CenterPanel.tablePane.removeAll();
					CenterPanel.tablePane.add(new DevTablePanel(new LogoPanel()), BorderLayout.CENTER);
					CenterPanel.tablePane.revalidate();
                                        break;
				case 3: CenterPanel.tablePane.removeAll();
					CenterPanel.tablePane.add(new PlatformTablePanel(new LogoPanel()), BorderLayout.CENTER);
					CenterPanel.tablePane.revalidate();
                                        break;
				case 4: break;

				default:
					break;
				}
				
			}
		});
	}
        
        public static void editorRefresh(){
                CenterPanel.tablePane.removeAll();
                CenterPanel.tablePane.add(new EditorTablePanel(new LogoPanel()), BorderLayout.CENTER);
                CenterPanel.tablePane.revalidate();
        }
        
        public static void devRefresh(){
                CenterPanel.tablePane.removeAll();
                CenterPanel.tablePane.add(new DevTablePanel(new LogoPanel()), BorderLayout.CENTER);
                CenterPanel.tablePane.revalidate();
        }
        
        public static void platformRefresh(){
                CenterPanel.tablePane.removeAll();
                CenterPanel.tablePane.add(new PlatformTablePanel(new LogoPanel()), BorderLayout.CENTER);
                CenterPanel.tablePane.revalidate();
        }
}
