package rss;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
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
	private JButton flipPhone, nokiaPhone, smartPhone, miniTablet, tablet, laptop, pc;

	private BrainCell brain;
	
	public UpgradePanel(BrainCell brain) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.brain = brain;
		upgrades.add(new Upgrade("Flip Phone", "These are ancient, do you even know what they are?", 1, 10));
		upgrades.add(new Upgrade("Nokia Phone", "I threw it on the floor, and it broke the floor", 5, 100));
		upgrades.add(new Upgrade("Smart Phone", "How does one use the snapbook?", 20, 1000));
		upgrades.add(new Upgrade("Mini Tablet", "Just a bigger phone", 50, 5000));
		upgrades.add(new Upgrade("Tablet", "Just a phone that's too big", 100, 10000));
		upgrades.add(new Upgrade("Laptop", "No more pocket edition minecraft", 500, 50000));
		upgrades.add(new Upgrade("PC", "Now you need a camera for Zoom", 1000, 100000));
//		upgrades.add(new Upgrade(5000, 1000000));
		
		flipPhone = new JButton(upgrades.get(0).toString());
//		flipPhone.setText(flipPhone.getText() + (int)upgrades.get(0).getCost());
//		flipPhone.setText(flipPhone.getText() + "<br>Owned: ");
//		flipPhone.setText(flipPhone.getText() + (int)upgrades.get(0).getOwned());


		nokiaPhone = new JButton(upgrades.get(1).toString());
//		nokiaPhone.setText(nokiaPhone.getText() + (int)upgrades.get(1).getCost());
//		nokiaPhone.setText(nokiaPhone.getText() + "<br>Owned: ");
//		nokiaPhone.setText(nokiaPhone.getText() + (int)upgrades.get(1).getOwned());
		
		smartPhone = new JButton(upgrades.get(2).toString());
//		smartPhone.setText(smartPhone.getText() + (int)upgrades.get(2).getCost());
//		smartPhone.setText(smartPhone.getText() + "<br>Owned: ");
//		smartPhone.setText(smartPhone.getText() + (int)upgrades.get(2).getOwned());
		
		miniTablet = new JButton(upgrades.get(3).toString());
		tablet = new JButton(upgrades.get(4).toString());
		laptop = new JButton(upgrades.get(5).toString());
		pc = new JButton(upgrades.get(6).toString());
	
		//Add to the buttons arraylist
		buttons.add(flipPhone);
		buttons.add(nokiaPhone);
		buttons.add(smartPhone);
		buttons.add(miniTablet);
		buttons.add(tablet);
		buttons.add(laptop);
		buttons.add(pc);
	
		//add to actionlistener
		flipPhone.addActionListener(this);
		nokiaPhone.addActionListener(this);
		smartPhone.addActionListener(this);
		miniTablet.addActionListener(this);
		tablet.addActionListener(this);
		laptop.addActionListener(this);
		pc.addActionListener(this);

		//add to panel
		this.add(flipPhone);
		this.add(nokiaPhone);
		this.add(smartPhone);
		this.add(miniTablet);
		this.add(tablet);
		this.add(laptop);
		this.add(pc);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
//		if (e.getSource().equals(flipPhone) && brain.getTotal() >= upgrades.get(0).getCost()) {
//			buyUpgrade(0);
//			updateButtons(0);
//			repaint();
//		} else if (e.getSource().equals(nokiaPhone) && brain.getTotal() >= upgrades.get(1).getCost()) {
//			buyUpgrade(1);
//			updateButtons(1);
//			repaint();
//		} else if (e.getSource().equals(smartPhone) && brain.getTotal() >= upgrades.get(2).getCost()) {
//			buyUpgrade(2);
//			updateButtons(2);
//			repaint();
//		}
		
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
	 * 
	 * @param index - index indicating which upgade to buy; each upgrade is assigned an index in the arraylist
	 */
	public void buyUpgrade(int index) {
		brain.addTotal(-upgrades.get(index).getCost());
		upgrades.get(index).buy();
	}
	
	public ArrayList<Upgrade> getUpgrades() {
		return upgrades;
	}
	
	private void updateButtons(int index) {
//		if (index == 0) {
//			flipPhone.setText("<html>Flip Phone<br>These are ancient, do you even know what they are?<br>Cost: ");
//			flipPhone.setText(flipPhone.getText() + (int)upgrades.get(0).getCost());
//			flipPhone.setText(flipPhone.getText() + "<br>Owned: ");
//			flipPhone.setText(flipPhone.getText() + (int)upgrades.get(0).getOwned());
//		} else if (index == 1) {
//			nokiaPhone.setText("<html>Nokia Phone<br>I threw it on the floor, and it broke the floor<br>Cost: ");
//			nokiaPhone.setText(nokiaPhone.getText() + (int)upgrades.get(1).getCost());
//			nokiaPhone.setText(nokiaPhone.getText() + "<br>Owned: ");
//			nokiaPhone.setText(nokiaPhone.getText() + (int)upgrades.get(1).getOwned());
//		} else if (index == 2) {
//			smartPhone.setText("<html>Nokia Phone<br>How does one use the snapbook?<br>Cost: ");
//			smartPhone.setText(smartPhone.getText() + (int)upgrades.get(2).getCost());
//			smartPhone.setText(smartPhone.getText() + "<br>Owned: ");
//			smartPhone.setText(smartPhone.getText() + (int)upgrades.get(2).getOwned());
//		}

		buttons.get(index).setText(upgrades.get(index).toString());
	}

}
