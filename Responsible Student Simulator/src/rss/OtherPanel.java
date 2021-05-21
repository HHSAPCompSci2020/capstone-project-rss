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
	private ArrayList<StressEvent> events = new ArrayList<StressEvent>();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private JButton prestige, sleep;
	protected boolean prestiged;
	
	public OtherPanel(BrainCell brain) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.brain = brain;
		
		events.add(new StressEvent("Watch Youtube Videos", "I'm sure this is a productive use of your time", 1000, 5));
		events.add(new StressEvent("Play A Game", "Maybe one about managing student stress?", 5000, 10));
		events.add(new StressEvent("Eat Dinner", "Don't Starve", 50000, 25));
		events.add(new StressEvent("Talk to Friends", "Meet with actual people in real life", 250000, 50));
		events.add(new StressEvent("Go to the Movies", "I've heard stories about the jedi...", 1000000, 100));
		
		for (int i = 0; i < 5; i++) {
			buttons.add(new JButton(events.get(i).toString()));
		}
		
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).addActionListener(this);
			this.add(buttons.get(i));
		}
		
		prestige = new JButton(brain.prestige.toString());
		sleep = new JButton("<html>Sleep<br>Go to sleep! Replenishes sleep back to 100.");
		
		sleep.addActionListener(this);
		prestige.addActionListener(this);
		
		this.add(prestige);
		this.add(sleep);
		prestiged = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(prestige) && brain.getTotal() >= brain.prestige.getCost()) {
			prestiged = true;
			repaint();
		} else if (e.getSource().equals(sleep)) {
			brain.sleep();
		} else {
			int index = buttons.indexOf(e.getSource());
			if (index >= 0) {
				if (brain.getTotal() >= events.get(index).getCost()) {
					brain.addTotal(-events.get(index).getCost());
					brain.addStress(-events.get(index).getValue());
					brain.addHappiness(events.get(index).getValue());
					updateButtons(index);
					repaint();
				}
			}
		}
	}
	
	public void updateButtons(int index) {
		if (index == -1) {
			prestige.setText(brain.prestige.toString());
		} else {
			buttons.get(index).setText(events.get(index).toString());
		}
	}
	
}
