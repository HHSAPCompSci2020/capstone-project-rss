import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

public class Main extends JFrame {
	
	private JPanel cardPanel;
	private JSplitPane splitPane;
	private JTabbedPane tabbedPane;
	
	private StartMenu startMenu;    
	private Menu menu;
	private UpgradePanel upgradePanel;
	private CoursePanel coursePanel;
	private BrainCell brainCell;
	
	public Main(String title) {
		super(title);
		setBounds(500, 50, 800, 1000);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
//	    cardPanel = new JPanel();
//	    CardLayout cl = new CardLayout();
//	    cardPanel.setLayout(cl);
	    
	    brainCell = new BrainCell();
	    startMenu = new StartMenu(this);    
	    menu = new Menu(this, brainCell);
	    upgradePanel = new UpgradePanel(brainCell);
	    coursePanel = new CoursePanel(brainCell);
	    	

	    
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
	
	/**
	 * Updates the total brain cell count with the passive income; call every second
	 */
	public void calculate() {
		brainCell.addTotal(brainCell.getRate());
	}
	
	public void prestige() {
		brainCell.prestige();
		for (int i = 0; i < upgradePanel.getUpgrade().size(); i++) {
			upgradePanel.getUpgrade().get(i).setOwned(0);
		}
		
	}
}