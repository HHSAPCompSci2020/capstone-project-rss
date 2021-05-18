package rss;

/**
 * Blueprint class that represents an upgrade, which includes its base cost and base production
 * @author Jeremie Park
 *
 */
public class Prestige {

	private double baseCost;
	private double currentCost;
	private int owned;
	private String name, desc;
	
	public Prestige(String name, String desc, double baseCost) {
		this.baseCost = baseCost;
		this.name = name;
		this.desc = desc;
		currentCost = baseCost;
		owned = 0;
	}
	
	/**
	 * Prestige
	 * @post Increases owned by 1, baseCost by an exponential formula, and the currentProduction is updated with the new owned value
	 */
	public void prestige() {
		owned++;
		currentCost = baseCost * Math.pow(2, owned);
	}
	
	/**
	 * Returns the current cost of the upgrade
	 * @return currentCost - cost of the upgrade
	 */
	public double getCost() {
		return currentCost;
	}
	
	/**
	 * Sets a new value for the amount of the ugprade that is owned
	 * @param owned - new value of owned
	 */
	public void setOwned(int owned) {
		this.owned = owned;
	}
	
	/**
	 * Returns amount of upgrade that is currently owned
	 * @return owned - an integer representing the amount of the upgrade that is currently owned
	 */
	public int getOwned() {
		return owned;
	}
	
	/**
	 * String of the upgrade, used for the text on the button
	 * @return - String of the text for the upgrade
	 */
	public String toString() {
		return "<html>" + name + "<br>" + desc + "<br>Cost: " + (int)getCost() + "<br>Prestige Level: " + getOwned();
	}
}
