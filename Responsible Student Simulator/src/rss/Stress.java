package rss;

/**
 * Class that represents the stress level of the student
 * @author Jeremie Park
 *
 */
public class Stress {
	
	double currentStress;
	
	/**
	 * Constructs a Stress object with default value of 0 current stress
	 */
	public Stress() {
		currentStress = 0;
	}
	
	public void act() {
		if (currentStress >= 0.2) {
			currentStress -= 0.2;
		}
	}
	
	/**
	 * Returns the amount of current stress
	 * @return - a double containing stress
	 */
	public double getStress() {
		return currentStress;
	}
	
	/**
	 * Sets the currentStress to a given amount
	 * @param amount - double containing the amount of stress to assign to currentStress
	 */
	public void setStress(double amount) {
		currentStress = amount;
	}
	
	/**
	 * Adds a given amount to currentStress. If sum is less than 0, sets currentStress to 0. If sum is greater than 100, sets currentStress to 100.
	 * @param amount - double containing the amount to add to currentStress
	 */
	public void addStress(double amount) {
		if (currentStress + amount > 100) {
			currentStress = 100;
		} else if (currentStress + amount < 0) {
			currentStress = 0;
		} else {
			currentStress += amount;
		}
	}
	
}
