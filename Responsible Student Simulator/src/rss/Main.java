package rss;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
	
	private JPanel cardPanel;
	private JSplitPane splitPane;
	private JTabbedPane tabbedPane;
	
	private StartMenu startMenu;    
	private Menu menu;
	private UpgradePanel upgradePanel;
	private CoursePanel coursePanel;
	private OtherPanel otherPanel;
	private BrainCell brainCell;
	private Timer timer;
	
	public Main(String title) {
		super(title);
		setBounds(500, 50, 800, 1000);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
//	    cardPanel = new JPanel();
//	    CardLayout cl = new CardLayout();
//	    cardPanel.setLayout(cl);
	    
	    brainCell = new BrainCell();
	    startMenu = new StartMenu(this);    
	    menu = new Menu(this, brainCell.getTotal(), brainCell.getRate(), brainCell.stress.getStress(), brainCell.sleep.getSleep());
	    upgradePanel = new UpgradePanel(brainCell);
	    coursePanel = new CoursePanel(brainCell);
	    otherPanel = new OtherPanel(brainCell);
	    	

	    
	    tabbedPane = new JTabbedPane();
//	    tabbedPane.setTabPlacement(JTabbedPane.LEFT);
	    tabbedPane.add("Upgrades", upgradePanel);
	    tabbedPane.add("Courses", coursePanel);
	    tabbedPane.add("Other", otherPanel);

	    
	    splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menu, tabbedPane);

//	    cardPanel.add(startMenu,"1");
//	    cardPanel.add(splitPane,"2");
	    
//	    add(cardPanel);
	    add(splitPane);
	    setVisible(true);
	    
		timer = new Timer(17, new ActionListener() {
			int counter = 0;
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	counter++;
		    	if (counter % 60 == 0) {
		    	 	upgradePanel.calculateRate();
			    	brainCell.act();
			    	calculate();
			    	counter = 0;
		    	}
		    	
		    	if (coursePanel.getCourses().get(0).inProduction) {
		    		coursePanel.getCourses().get(0).run();
		    	}
		    	if (coursePanel.getCourses().get(0).getProgress() == 1) {
		    		System.out.println("end");
		    		coursePanel.getCourses().get(0).endProduction();
		    		brainCell.addTotal(coursePanel.getCourses().get(0).getProduction());
		    	}
		    	
		    	menu.repaint(brainCell.getTotal(), brainCell.getRate(), brainCell.stress.getStress(), brainCell.sleep.getSleep());
		        repaint();
		    }
		});
		
		timer.start();
	    
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
		for (int i = 0; i < upgradePanel.getUpgrades().size(); i++) {
			upgradePanel.getUpgrades().get(i).setOwned(0);
		}
		
	}
}