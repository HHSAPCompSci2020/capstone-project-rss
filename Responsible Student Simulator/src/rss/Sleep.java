package rss;

/**
 * Class that represents the sleep level of the student
 * @author Jeremie Park
 *
 */
public class Sleep {
	
	double currentSleep;
	
	/**
	 * Constructs a Sleep object with default value of 100 current sleep
	 */
	public Sleep() {
		currentSleep = 100;
	}
	
	/**
	 * Decreases currentSleep by a given amount x; to be called every second
	 * @param x - amount of sleep to decrease
	 */
	public void act(int x) {
		if (currentSleep > 0) {
			currentSleep -= x;
		}
	}
	
	/**
	 * Returns the amount of current sleep
	 * @return - a double containing sleep
	 */
	public double getSleep() {
		return currentSleep;
	}
	
	/**
	 * Sets the currentSleep to a given amount
	 * @param amount - double containing the amount of sleep to assign to currenSleep
	 */
	public void setSleep(double amount) {
		currentSleep = amount;
	}
	
	/**
	 * Adds a given amount to currentSleep
	 * @param amount - double containing the amount to add to currentSleep
	 */
	public void addSleep(double amount) {
		currentSleep += amount;
	}
	
}
