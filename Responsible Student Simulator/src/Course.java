/*
 
 	Author: Megan Choy
 	Version: 01
 
 */
public class Course {
	
	private int level;
	private double baseProduction, baseCost;
	private double currentProduction, currentCost;
	private String name;
	
	public Course(String name, double baseProduction, double baseCost, double time) {
		this.baseCost = baseCost;
		this.baseProduction = baseProduction;
		level = 1;
		currentProduction = baseProduction;
		currentCost = baseProduction;
		this.name = name;
	}
	
	public void run() {
		
	}
	
	public void levelUp() {
		currentCost = baseCost * Math.pow(1.15, level);
		level++;
		currentProduction = baseProduction * level;
	}
	
	public double getProduction() {
		return currentProduction;
	}
	
	public double getCost() {
		return currentCost;
	}
}
