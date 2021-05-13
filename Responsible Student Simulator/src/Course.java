/*
 
 	Author: 
 	Version:
 
 */
public class Course {
	
	private int level;
	private double baseProduction, baseCost;
	private double currentProduction, currentCost;
	
	public Course(double baseProduction, double baseCost) {
		this.baseCost = baseCost;
		this.baseProduction = baseProduction;
		level = 1;
		currentProduction = baseProduction;
		currentCost = baseProduction;
	}
	
	
}
