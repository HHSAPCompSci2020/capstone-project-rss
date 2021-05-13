/*
 
 	Author: Jeremie Park
 	Version: 01
 
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
		currentProduction = baseProduction;
		currentCost = baseCost;
		owned = 0;
	}
	
	public void buy() {
		currentCost = baseCost * Math.pow(1.15, owned);
		owned++;
	}
	
	public double getProduction() {
		return currentProduction;
	}
	
	public double getCost() {
		return currentCost;
	}
	
}
