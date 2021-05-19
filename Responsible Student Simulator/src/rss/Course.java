package rss;
/*
 
 	Author: Jeremie Park, Megan Choy
 	Version: 02
 
 */
/**
 * Course is created with specified amount earned, cost to unlock, and time to take the course.
 * @author Jeremie Park, Megan Choy
 * Version: 02
 */
public class Course {
	
	private double production, cost;
	protected static boolean inProduction; //If any of the courses are producing 
	private boolean running; // If this specific course is running
	private int productionProgress;
	private int productionFinish;
	private String name, desc;
	private boolean unlocked;
	
	/**
	 * Creates a Course with a name, description, production, cost, and time
	 * @param name Name of the course
	 * @param desc Description of the course
	 * @param production The amount earned after the course is taken
	 * @param cost The amount it costs to unlock the course
	 * @param time The time it takes to take the course
	 */
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
	
	/**
	 * Increases the progress of the course
	 * @pre startProduction() so that progress can be made
	 */
	public void run() {
		if (running) {
			productionProgress++;
		}
	}
	
	/**
	 * Starts the production
	 * @post run() has to be called in order to actually progress
	 */
	public void startProduction() {
		inProduction = true;
		running = true;
	}
	
	/**
	 * Ends production
	 */
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
	
	public String getName() {
		return name;
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
