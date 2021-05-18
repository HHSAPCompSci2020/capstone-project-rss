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
 * @author Jeremie Park
 *
 */
public class UpgradePanel extends JPanel implements ActionListener{

	private ArrayList<Upgrade> upgrades = new ArrayList<Upgrade>();
	private JButton flipPhone, nokiaPhone, smartPhone, miniTablet, tablet;

	private BrainCell brain;
	
	public UpgradePanel(BrainCell brain) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.brain = brain;
		upgrades.add(new Upgrade(1, 10));
		upgrades.add(new Upgrade(5, 100));
		upgrades.add(new Upgrade(20, 1000));
		upgrades.add(new Upgrade(50, 5000));
		upgrades.add(new Upgrade(100, 10000));
		upgrades.add(new Upgrade(500, 50000));
		upgrades.add(new Upgrade(1000, 100000));
		upgrades.add(new Upgrade(5000, 1000000));
		
		flipPhone = new JButton("<html>Flip Phone<br>These are ancient, do you even know what they are?<br>Cost: ");
		flipPhone.setText(flipPhone.getText() + (int)upgrades.get(0).getCost());
		flipPhone.setText(flipPhone.getText() + "<br>Owned: ");
		flipPhone.setText(flipPhone.getText() + (int)upgrades.get(0).getOwned());
		this.add(flipPhone);
		flipPhone.addActionListener(this);

		nokiaPhone = new JButton("<html>Nokia Phone<br>I threw it on the floor, and it broke the floor<br>Cost: ");
		nokiaPhone.setText(nokiaPhone.getText() + (int)upgrades.get(1).getCost());
		nokiaPhone.setText(nokiaPhone.getText() + "<br>Owned: ");
		nokiaPhone.setText(nokiaPhone.getText() + (int)upgrades.get(1).getOwned());
		this.add(nokiaPhone);
		nokiaPhone.addActionListener(this);
		
		smartPhone = new JButton("<html>Nokia Phone<br>How does one use the snapbook?<br>Cost: ");
		smartPhone.setText(smartPhone.getText() + (int)upgrades.get(2).getCost());
		smartPhone.setText(smartPhone.getText() + "<br>Owned: ");
		smartPhone.setText(smartPhone.getText() + (int)upgrades.get(2).getOwned());
		this.add(smartPhone);
		smartPhone.addActionListener(this);
		
		miniTablet = new JButton("Mini Tablet");
		tablet = new JButton("Tablet");
				
		this.add(smartPhone);
		this.add(miniTablet);
		this.add(tablet);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(flipPhone) && brain.getTotal() >= upgrades.get(0).getCost()) {
			buyUpgrade(0);
			updateButtons(0);
			repaint();
		} else if (e.getSource().equals(nokiaPhone) && brain.getTotal() >= upgrades.get(1).getCost()) {
			buyUpgrade(1);
			updateButtons(1);
			repaint();
		} else if (e.getSource().equals(smartPhone) && brain.getTotal() >= upgrades.get(2).getCost()) {
			buyUpgrade(2);
			updateButtons(2);
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
		if (index == 0) {
			flipPhone.setText("<html>Flip Phone<br>These are ancient, do you even know what they are?<br>Cost: ");
			flipPhone.setText(flipPhone.getText() + (int)upgrades.get(0).getCost());
			flipPhone.setText(flipPhone.getText() + "<br>Owned: ");
			flipPhone.setText(flipPhone.getText() + (int)upgrades.get(0).getOwned());
		} else if (index == 1) {
			nokiaPhone.setText("<html>Nokia Phone<br>I threw it on the floor, and it broke the floor<br>Cost: ");
			nokiaPhone.setText(nokiaPhone.getText() + (int)upgrades.get(1).getCost());
			nokiaPhone.setText(nokiaPhone.getText() + "<br>Owned: ");
			nokiaPhone.setText(nokiaPhone.getText() + (int)upgrades.get(1).getOwned());
		} else if (index == 2) {
			smartPhone.setText("<html>Nokia Phone<br>How does one use the snapbook?<br>Cost: ");
			smartPhone.setText(smartPhone.getText() + (int)upgrades.get(2).getCost());
			smartPhone.setText(smartPhone.getText() + "<br>Owned: ");
			smartPhone.setText(smartPhone.getText() + (int)upgrades.get(2).getOwned());
		}

	}

}
