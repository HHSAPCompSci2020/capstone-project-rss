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

public class Window extends JFrame {
	
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
		
	public Window(String title) {
		super(title);
		setBounds(500, 50, 800, 1000);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
//	    cardPanel = new JPanel();
//	    CardLayout cl = new CardLayout();
//	    cardPanel.setLayout(cl);
	    
	    brainCell = new BrainCell();
	    startMenu = new StartMenu(this);    
	    upgradePanel = new UpgradePanel(brainCell);
	    coursePanel = new CoursePanel(brainCell);
	    otherPanel = new OtherPanel(brainCell);
	    menu = new Menu(this, brainCell, coursePanel);
	    	
	    tabbedPane = new JTabbedPane();
//	    tabbedPane.setTabPlacement(JTabbedPane.LEFT);
	    tabbedPane.add("Courses", coursePanel);
	    tabbedPane.add("Upgrades", upgradePanel);
	    tabbedPane.add("Other", otherPanel);

	    
	    splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menu, tabbedPane);
	    splitPane.setDividerLocation(355);

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
		    	
		    	if (Course.inProduction) {
			    	for (int i = 0; i < coursePanel.getCourses().size(); i++) {
			    		//No current other course is running, but this one should be
			    		if (coursePanel.getCourses().get(i).getRunning()) {
			    			coursePanel.getCourses().get(i).run();
			    		}
			    		
				    	if (coursePanel.getCourses().get(i).getProgress() == 1) {
				    		System.out.println("end");
				    		brainCell.addStress((i+1) * 10);
				    		System.out.println(brainCell.getStress());
				    		coursePanel.getCourses().get(i).endProduction();
			    			brainCell.addTotal(coursePanel.getCourses().get(i).getProduction());
				    	}
			    	}
		    	}
		    	
		    	if (otherPanel.prestiged) {
		    		prestige();
		    		otherPanel.prestiged = false;
		    	}
		    	
		    	menu.repaint();
		        repaint();
		    }
		});
		
		timer.start();
	    
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
		brainCell.prestige.prestige();
		brainCell.setTotal(0);
		for (int i = 0; i < upgradePanel.getUpgrades().size(); i++) {
			upgradePanel.getUpgrades().get(i).setOwned(0);
			upgradePanel.updateButtons(i);
		}
		upgradePanel.calculateRate();
		
	}
}