package rss;

/**
 * Blueprint class that represents an upgrade, which includes its base cost and base production
 * @author Jeremie Park
 *
 */
public class Upgrade {

	private double baseCost;
	private double currentCost;
	private double baseProduction;
	private double currentProduction;
	private int owned;
	private String name, desc;
	
	/**
	 * Creates an Upgrade with given parameters which will be displayed on the button
	 * @param name - the name of the upgrade
	 * @param desc - the description of the upgrade
	 * @param baseProduction - initial production rate of the upgrade
	 * @param baseCost - initial cost of the upgrade
	 */
	public Upgrade(String name, String desc, double baseProduction, double baseCost) {
		this.baseCost = baseCost;
		this.baseProduction = baseProduction;
		this.name = name;
		this.desc = desc;
		currentProduction = 0;
		currentCost = baseCost;
		owned = 0;
	}
	
	/**
	 * Buys an upgrade
	 * @post Increases owned by 1, baseCost by an exponential formula, and the currentProduction is updated with the new owned value
	 */
	public void buy() {
		owned++;
		currentCost = baseCost * Math.pow(1.15, owned);
		currentProduction = baseProduction * owned;
	}
	
	/**
	 * Returns the current production
	 * @return currentProduction - production of the upgrade accounting for the amount owned
	 */
	public double getProduction() {
		return currentProduction;
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
		currentProduction = owned * baseProduction;
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
		return "<html>" + name + "<br>" + desc + "<br>Cost: " + (int)getCost() + "<br>Owned: " + getOwned();
	}
}
