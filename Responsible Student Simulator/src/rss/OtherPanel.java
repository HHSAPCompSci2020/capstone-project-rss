package rss;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

/**
 * JPanel that contians buttons for prestige, sleep, and stress events
 * @author Jeremie Park
 *
 */
public class OtherPanel extends JPanel implements ActionListener{

	private BrainCell brain;
	private JButton prestige, sleep;
	private JButton example;
	private boolean canPrestige;
	protected boolean prestiged;
	
	public OtherPanel(BrainCell brain) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.brain = brain;
		prestige = new JButton("<html><b>PRESTIGE</b><br>Reset ALL currnet progress to gain a permanent production modifier bonus.<br> Cost: 1,000,000,000 <br>Current Modifier: 1 </html>");
		sleep = new JButton("<html>Sleep<br>Go to sleep! Replenishes sleep back to 100.");
		example = new JButton("example button for stress event");
		
		sleep.addActionListener(this);
		prestige.addActionListener(this);
		example.addActionListener(this);
		
		this.add(prestige);
		this.add(sleep);
		this.add(example);
		canPrestige = false;
		prestiged = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(prestige) && canPrestige) {
			prestiged = true;
		} else if (e.getSource().equals(sleep)) {
			brain.sleep();
		} else if (e.getSource().equals(example)) {
			if (brain.getTotal() >= 1000) {
				if (brain.getStress() > 0) {
					brain.addTotal(-1000);
				}
				brain.addStress(-10);
			}
		}
		
	}
	
}
