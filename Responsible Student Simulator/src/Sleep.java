/*
 
 	Represents the sleep level of the student.
 
 	Author: Jeremie Park
 	Version: 1
 
 */

public class Sleep {
	
	double maxSleep;
	double currentSleep;
	
	public Sleep() {
		currentSleep = 100;
		maxSleep = 100;
	}
	
	public void act() {
		if (currentSleep > 0) {
			currentSleep--;
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
