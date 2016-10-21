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
import view.MainLogoPanel;

/**
 *
 * @author GamyCats
 */
public class MainTabPanel extends JPanel
{
	JTabbedPane tabPanelGame;
	JTabbedPane tabPanelEditor;
	JTabbedPane tabPanelDev;
	JTabbedPane tabPanel;
	JTabbedPane tabPanelDescription;
	MainLogoPanel leds;

	public MainTabPanel(MainLogoPanel logopanel)
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
		
		this.add(tabPanelGame);
		
		tabPanelGame.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
			
				switch (tabPanelGame.getSelectedIndex()) {
				case 0:
					MainCenterPanel.tablePane.removeAll();
					MainCenterPanel.tablePane.add(new TablePanelGame(new MainLogoPanel()), BorderLayout.CENTER);
					MainCenterPanel.tablePane.revalidate();
					break;
				case 1:
					MainCenterPanel.tablePane.removeAll();
					MainCenterPanel.tablePane.add(new TablePanelEditor(new MainLogoPanel()), BorderLayout.CENTER);
					MainCenterPanel.tablePane.revalidate();
					break;
				case 2:
                                        MainCenterPanel.tablePane.removeAll();
					MainCenterPanel.tablePane.add(new TablePanelDev(new MainLogoPanel()), BorderLayout.CENTER);
					MainCenterPanel.tablePane.revalidate();
                                        break;
				case 3: MainCenterPanel.tablePane.removeAll();
					MainCenterPanel.tablePane.add(new TablePanelPlatform(new MainLogoPanel()), BorderLayout.CENTER);
					MainCenterPanel.tablePane.revalidate();
                                        break;
				case 4: break;

				default:
					break;
				}
				
			}
		});
	}
        
        public static void editorRefresh(){
                MainCenterPanel.tablePane.removeAll();
                MainCenterPanel.tablePane.add(new TablePanelEditor(new MainLogoPanel()), BorderLayout.CENTER);
                MainCenterPanel.tablePane.revalidate();
        }
        
        public static void devRefresh(){
                MainCenterPanel.tablePane.removeAll();
                MainCenterPanel.tablePane.add(new TablePanelDev(new MainLogoPanel()), BorderLayout.CENTER);
                MainCenterPanel.tablePane.revalidate();
        }
        
        public static void platformRefresh(){
                MainCenterPanel.tablePane.removeAll();
                MainCenterPanel.tablePane.add(new TablePanelPlatform(new MainLogoPanel()), BorderLayout.CENTER);
                MainCenterPanel.tablePane.revalidate();
        }
}
