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
	
	public Upgrade(double baseProduction, double baseCost) {
		this.baseCost = baseCost;
		this.baseProduction = baseProduction;
		currentProduction = 0;
		currentCost = baseCost;
		owned = 0;
	}
	
	public void buy() {
		currentCost = baseCost * Math.pow(1.15, owned);
		owned++;
		currentProduction = baseProduction * owned;
	}
	
	public double getProduction() {
		return currentProduction;
	}
	
	public double getCost() {
		return currentCost;
	}
	
	public void setOwned(int owned) {
		this.owned = owned;
	}
	
	public int getOwned() {
		return owned;
	}
	
}
