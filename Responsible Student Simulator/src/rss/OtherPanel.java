package rss;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

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
	
	/**
	 * Constructs a panel containing prestige, sleep, and stress buttons, with a given BrainCell
	 * @param brain - the BrainCell used to gather total brain cell counts and the brain cell rate
	 */
	public OtherPanel(BrainCell brain) {
		setLayout(new GridLayout(3, 3));
		this.brain = brain;
		
		events.add(new StressEvent("Watch Youtube Videos", "I'm sure this is a productive use of your time", 1000, 5, 2));
		events.add(new StressEvent("Play A Game", "Maybe one about managing student stress?", 2000, 10, 5));
		events.add(new StressEvent("Eat Dinner", "Don't Starve", 5000, 25, 10));
		events.add(new StressEvent("Talk to Friends", "Meet with actual people in real life", 50000, 50, 40));
		events.add(new StressEvent("Go to the Movies", "I've heard stories about the jedi...", 250000, 100, 100));
		
		for (int i = 0; i < 5; i++) {
			buttons.add(new JButton(events.get(i).toString()));
		}
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).addActionListener(this);
			this.add(buttons.get(i));
	        buttons.get(i).setBackground(new Color(95, 107, 125));
	        buttons.get(i).setForeground(Color.WHITE);
	        buttons.get(i).setFocusPainted(false);
	        buttons.get(i).setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
		}
		
		prestige = new JButton(brain.prestige.toString());
		sleep = new JButton("<html><i>-Sleep-</i><br>Go to sleep! Replenishes sleep back to 100.");
		
        prestige.setBackground(new Color(95, 107, 125));
        prestige.setForeground(Color.WHITE);
        prestige.setFocusPainted(false);
        prestige.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
        sleep.setBackground(new Color(95, 107, 125));
        sleep.setForeground(Color.WHITE);
        sleep.setFocusPainted(false);
        sleep.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
		
		sleep.addActionListener(this);
		prestige.addActionListener(this);
		this.add(prestige);
		this.add(sleep);
		prestiged = false;
	}
	
	/**
	 * Checks for buttons being pressed
	 */
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
					brain.addHappiness(events.get(index).getHappiness());
					updateButtons(index);
					repaint();
				}
			}
		}
	}
	
	/**
	 * Updates the text of a button with a given index; if the index is -1, the prestige button will update, instead of any stress event buttons
	 * @param index - the index of the button in the ArrayList of buttons
	 */
	public void updateButtons(int index) {
		if (index == -1) {
			prestige.setText(brain.prestige.toString());
		} else {
			buttons.get(index).setText(events.get(index).toString());
		}
	}
	
}
