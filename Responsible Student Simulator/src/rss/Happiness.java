package rss;

public class Happiness {

	double currentHappiness;
	
	/**
	 * Constructs a happiness class with default value of 50 current happiness
	 */
	public Happiness() {
		currentHappiness = 50;
	}
	
	/**
	 * Returns the amount of current happiness
	 * @return - a double containing currentHappiness
	 */
	public double getHappiness() {
		return currentHappiness;
	}
	
	/**
	 * Sets the currentHappiness to a given amount
	 * @param amount - double containing the amount of happiness to assign to currentHappiness
	 */
	public void setHappiness(double amount) {
		currentHappiness = amount;
	}
	
	/**
	 * Adds a given amount to currentHappiness. If sum is less than 0, sets currentHappiness to 0. If sum is greater than 100, sets currentHappiness to 100.
	 * @param amount - double containing the amount to add to currentSleep
	 */
	public void addHappiness(double amount) {
		if (currentHappiness + amount > 100) {
			currentHappiness = 100;
		} else if (currentHappiness + amount < 0) {
			currentHappiness = 0;
		} else {
			currentHappiness += amount;
		}
	}
	
}
