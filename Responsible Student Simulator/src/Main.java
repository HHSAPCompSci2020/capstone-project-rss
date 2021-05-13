import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class Main extends JFrame {
	
	private JPanel cardPanel;
	private JSplitPane splitPane;
	private JTabbedPane tabbedPane;
	
	private StartMenu startMenu;    
	private Menu menu;
	private UpgradePanel upgradePanel;
	private CoursePanel coursePanel;
	
	public Main(String title) {
		super(title);
		setBounds(500, 50, 800, 1000);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
//	    cardPanel = new JPanel();
//	    CardLayout cl = new CardLayout();
//	    cardPanel.setLayout(cl);
	    
	    startMenu = new StartMenu(this);    
	    menu = new Menu(this);
	    coursePanel = new CoursePanel();
	    	
	    tabbedPane = new JTabbedPane();
//	    tabbedPane.setTabPlacement(JTabbedPane.LEFT);
	    tabbedPane.add("Upgrades", upgradePanel);
	    tabbedPane.add("Courses", coursePanel);

	    
	    splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menu, tabbedPane);

//	    cardPanel.add(startMenu,"1");
//	    cardPanel.add(splitPane,"2");
	    
//	    add(cardPanel);
	    add(splitPane);
	    setVisible(true);
	    
	}

	public static void main(String[] args)
	{
		Main w = new Main("Responsible Student Simulator");
	}
	
	public void goToMenu() {
		((CardLayout)cardPanel.getLayout()).next(cardPanel);
//		menu.requestFocus();
	}
}