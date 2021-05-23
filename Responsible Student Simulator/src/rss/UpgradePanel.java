package rss;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;

/**
 * JPanel that contains all buttons and classes related to the upgrades. The buttons are used to buy upgrades
 * and this class processes upgrade production rate.
 * @author Jeremie Park, Megan Choy
 *
 */
public class UpgradePanel extends JPanel implements ActionListener{

	private ArrayList<Upgrade> upgrades = new ArrayList<Upgrade>();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private BrainCell brain;
	
	/**
	 * Constructs an UpgradePanel with a given BrainCell
	 * @param brain - the BrainCell used to calculate total brain cells and brain cell rate
	 */
	public UpgradePanel(BrainCell brain) {
		setLayout(new GridLayout(3, 4));
		this.brain = brain;
		upgrades.add(new Upgrade("Flip Phone", "These are ancient, do you even know what they are?", 1, 10));
		upgrades.add(new Upgrade("Nokia Phone", "I threw it on the floor, and it broke the floor", 5, 100));
		upgrades.add(new Upgrade("Smart Phone", "How does one use the snapbook?", 20, 1000));
		upgrades.add(new Upgrade("Mini Tablet", "Just a bigger phone", 50, 5000));
		upgrades.add(new Upgrade("Tablet", "Just a phone that's too big", 100, 10000));
		upgrades.add(new Upgrade("Laptop", "No more pocket edition minecraft", 500, 50000));
		upgrades.add(new Upgrade("PC", "Now you need a camera for Zoom", 1000, 100000));
		upgrades.add(new Upgrade("Ultrawide Monitor", "It's for school mom I swear", 5000, 500000));
		upgrades.add(new Upgrade("Desktop Upgrades", "The rgb ram and liquid cooling makes me faster at solving math problems", 10000, 1000000));
		upgrades.add(new Upgrade("Laser Mouse", "Because sometimes you need to hit that kahoot answer with *precision*", 25000, 5000000));
		upgrades.add(new Upgrade("Mechanical Keyboard", "Legends say you can type so fast that you can finish your essay on time", 50000, 10000000));
		upgrades.add(new Upgrade("Hologram Display", "I sense a plot to destroy the Jedi...", 100000, 50000000));
	
		//Add to the buttons to arraylist
		for (int i = 0; i < 12; i++) {
			buttons.add(new JButton(upgrades.get(i).toString()));
		}
		
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).addActionListener(this);
			this.add(buttons.get(i));
	        buttons.get(i).setBackground(new Color(95, 107, 125));
	        buttons.get(i).setForeground(Color.WHITE);
	        buttons.get(i).setFocusPainted(false);
	        buttons.get(i).setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
		}
	}
	
	/**
	 * Checks for a button being pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int index = buttons.indexOf(e.getSource());
		if (brain.getTotal() >= upgrades.get(index).getCost()) {
			buyUpgrade(index);
			updateButtons(index);
			repaint();
		}
	}

	/**
	 *  Calculates the rate of braincell production from upgrades
	 * @return production rate from upgrades
	 */
	public double calculateRate() {
		double rate = 0;
		for (int i = 0; i < upgrades.size(); i++) {
			rate += upgrades.get(i).getProduction();
		}
		brain.setRate(rate);
		return rate;
	}
	
	/**
	 * Buys an upgrade, increasing its "owned" field by one, and subtracts the cost from the brainCellTotal
	 * @param index - index indicating which upgade to buy; each upgrade is assigned an index in the arraylist
	 * @post brain gets its brainCellTotal count decreased by the cost of the upgrade
	 */
	public void buyUpgrade(int index) {
		brain.addTotal(-upgrades.get(index).getCost());
		upgrades.get(index).buy();
	}
	
	/**
	 * Returns all upgrades that are in the UpgradePanel
	 * @return upgrades - an ArrayList containing all upgrades
	 */
	public ArrayList<Upgrade> getUpgrades() {
		return upgrades;
	}
	
	/**
	 * Updates the text of the button of the given index
	 * @param index - index of the button to update
	 */
	public void updateButtons(int index) {
		buttons.get(index).setText(upgrades.get(index).toString());
	}

}
