package rss;
/*
 
 	Author: Jeremie Park, Megan Choy
 	Version: 02
 
 */
public class Course {
	
	private double production, cost;
	protected boolean inProduction;
	private int productionProgress;
	private int productionFinish;
	private String name, desc;
	private boolean unlocked;
	
	public Course(String name, String desc, double production, double cost, double time) {
		this.cost = cost;
		this.production = production;
		this.name = name;
		this.desc = desc;
		inProduction = false;
		productionFinish = (int)(time * 60);
		productionProgress = 0;
		unlocked = false;
	}
	
	public void run() {
		if (inProduction) {
			productionProgress++;
		}
	}
	
	public void startProduction() {
		inProduction = true;
	}
	
	public void endProduction() {
		productionProgress = 0;
		inProduction = false;
	}
	
	public double getProduction() {
		return production;
	}
	
	public double getCost() {
		return cost;
	}
	
	public double getProgress() {
		return (double)productionProgress / productionFinish;
	}
	
	public void buy(double brainCellTotal) {
		if (cost == 0) {
			unlocked = true;
		}
		
		if (brainCellTotal >= cost) {
			unlocked = true;
		}
	}
	
	public boolean getUnlocked() {
		return unlocked;
	}
	
	public String toString() {
		String s = "<html>" + name + "<br>" + desc + "<br>Production: " + (int)getProduction();
		
		if (unlocked) {
			s += "<br>Unlocked: True";
		} else {
			s += "<br>Locked, Cost: " + (int)cost;
		}
		
		return s;
	}
}
