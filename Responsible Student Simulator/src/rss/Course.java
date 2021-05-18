package rss;
/*
 
 	Author: Jeremie Park, Megan Choy
 	Version: 02
 
 */
public class Course {
	
	private double production, cost;
	protected static boolean inProduction; //If any of the courses are producing 
	private boolean running; // If this specific course is running
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
		if (running) {
			productionProgress++;
		}
	}
	
	public void startProduction() {
		inProduction = true;
		running = true;
	}
	
	public void endProduction() {
		productionProgress = 0;
		inProduction = false;
		running = false;
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
	
	public boolean getRunning() {
		return running;
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
