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
	protected boolean prestiged;
	
	public OtherPanel(BrainCell brain) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.brain = brain;
		
		prestige = new JButton(brain.prestige.toString());
		sleep = new JButton("<html>Sleep<br>Go to sleep! Replenishes sleep back to 100.");
		example = new JButton("example button for stress event");
		
		sleep.addActionListener(this);
		prestige.addActionListener(this);
		example.addActionListener(this);
		
		this.add(prestige);
		this.add(sleep);
		this.add(example);
		prestiged = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(prestige) && brain.getTotal() >= brain.prestige.getCost()) {
			prestiged = true;
			repaint();
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
	
	public void updateButtons() {
		prestige.setText(brain.prestige.toString());
	}
	
}
