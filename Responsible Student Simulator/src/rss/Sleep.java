package rss;

/**
 * Class that represents the sleep level of the student
 * @author Jeremie Park
 *
 */
public class Sleep {
	
	double maxSleep;
	double currentSleep;
	
	public Sleep() {
		currentSleep = 100;
		maxSleep = 100;
	}
	
	public void act(int x) {
		if (currentSleep > 0) {
			currentSleep -= x;
		}
	}
	
	public double getSleep() {
		return currentSleep;
	}
	
	public void setSleep(double amount) {
		currentSleep = amount;
	}
	
	public void addSleep(double amount) {
		currentSleep += amount;
	}
	
}
