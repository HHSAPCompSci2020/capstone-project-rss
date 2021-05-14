/*
 
 	Author: Megan Choy
 	Version: 01
 
 */
public class Course {
	
	private int level;
	private double baseProduction, baseCost;
	private double currentProduction, currentCost;
	protected boolean inProduction;
	private int productionProgress;
	private int productionFinish;
	private String name;
	
	public Course(String name, double baseProduction, double baseCost, double time) {
		this.baseCost = baseCost;
		this.baseProduction = baseProduction;
		level = 1;
		currentProduction = baseProduction;
		currentCost = baseProduction;
		this.name = name;
		inProduction = false;
		productionFinish = (int)(time * 60);
		productionProgress = 0;
		
	}
	
	public void run() {
		if (inProduction) {
			productionProgress++;
		}
	}
	
	public int getLevel() {
		return level;
	}
	
	public void levelUp() {
		currentCost = baseCost * Math.pow(1.15, level);
		level++;
		currentProduction = baseProduction * level;
	}
	
	public void startProduction() {
		inProduction = true;
	}
	
	public void endProduction() {
		productionProgress = 0;
		inProduction = false;
	}
	
	public double getProduction() {
		currentProduction = level * baseProduction;
		return currentProduction;
	}
	
	public double getCost() {
		return currentCost;
	}
	
	public double getProgress() {
		return (double)productionProgress / productionFinish;
	}
}
