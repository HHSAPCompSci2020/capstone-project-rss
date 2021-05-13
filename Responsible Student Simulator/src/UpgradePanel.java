import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JPanel;

public class UpgradePanel extends JPanel implements ActionListener{

	private ArrayList<Upgrade> upgrades = new ArrayList<Upgrade>();

	private BrainCell brain;
	
	public UpgradePanel(BrainCell brain) {
		this.brain = brain;
		upgrades.add(new Upgrade(1, 10));
		upgrades.add(new Upgrade(5, 100));
		upgrades.add(new Upgrade(20, 1000));
		upgrades.add(new Upgrade(50, 5000));
		upgrades.add(new Upgrade(100, 10000));
		upgrades.add(new Upgrade(500, 50000));
		upgrades.add(new Upgrade(1000, 100000));
		upgrades.add(new Upgrade(5000, 1000000));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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

}
