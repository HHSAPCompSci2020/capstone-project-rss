package rss;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
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
	private JButton flipPhone, nokiaPhone, smartPhone, miniTablet, tablet, laptop, pc, monitor, laserMouse, mechanicalKeybaord, hologramDisplay;
	private BrainCell brain;
	
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
		upgrades.add(new Upgrade("Laser Mouse", "Because sometimes you need to hit that kahoot answer with *precision*", 10000, 1000000));
		upgrades.add(new Upgrade("Mechanical Keyboard", "Legends say you can type so fast that you actually have time to finish your APUSH exam", 1000000, 5000000));
		upgrades.add(new Upgrade("Hologram Display", "I sense a plot to destroy the Jedi...", 1000000, 10000000));
	
		//Add to the buttons to arraylist
		for (int i = 0; i < 11; i++) {
			buttons.add(new JButton(upgrades.get(i).toString()));
		}
		
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).addActionListener(this);
			this.add(buttons.get(i));
		}
	}
	
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
	private void updateButtons(int index) {
		buttons.get(index).setText(upgrades.get(index).toString());
	}

}
