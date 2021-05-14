import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

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
		
		nokiaPhone = new JButton("Nokia Phone");
		smartPhone = new JButton("Smart Phone");
		miniTablet = new JButton("Mini Tablet");
		tablet = new JButton("Tablet");
				
		flipPhone.addActionListener(this);
		
		this.add(flipPhone);
		this.add(nokiaPhone);
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
		upgrades.get(index).buy();
		brain.addTotal(-upgrades.get(index).getCost());
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
		}

	}

}
