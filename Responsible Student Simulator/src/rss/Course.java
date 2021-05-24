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
	
	/**
	 * Get the amount earned after course is taken
	 * @return amount of brain cells earned
	 */
	public double getProduction() {
		return production;
	}
	
	/**
	 * Get the cost of unlocking the course
	 * @return the cost of unlocking the course
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Gets the progress in percentage of how far the course has been taken
	 * @return the progress in percentage
	 */
	public double getProgress() {
		return (double)productionProgress / productionFinish;
	}
	
	/**
	 * Returns true if the course is running and false if it is not
	 * @return true if the course is running and false if it is not
	 */
	public boolean getRunning() {
		return running;
	}
	
	/**
	 * Attempts to buy the course. The course will not unlock if does student does not have enough brain cells
	 * @param brainCellTotal The current amount of brain cells the student has
	 */
	public void buy(double brainCellTotal) {
		if (cost == 0) {
			unlocked = true;
		}
		
		if (brainCellTotal >= cost) {
			unlocked = true;
		}
	}
	
	/**
	 * Returns true if the course is unlocked and able to be taken and false if the course is not bought
	 * @return true if the course is unlocked and able to be taken and false if the course is not bought
	 */
	public boolean getUnlocked() {
		return unlocked;
	}
	
	/**
	 * Sets if the course is unlocked or not, used when prestiged
	 * @param unlock true if the course is unlocked, false if it is not
	 */
	public void setUnlocked(boolean unlock) {
		unlocked = unlock;
	}
	
	/**
	 * Retunrs the name of the course
	 * @return The name of the course
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * String of the course, used on for text on the buttons
	 * @return String with the course name, description, how much it produces, and if it is unlocked
	 */
	public String toString() {
		String s = "<html><i>-" + name + "-</i><br>" + desc + "<br>Production: " + (int)getProduction();
		
		if (unlocked) {
			s += "<br>Unlocked: True";
		} else {
			s += "<br>Locked, Cost: " + (int)cost;
		}
		
		return s;
	}
}
