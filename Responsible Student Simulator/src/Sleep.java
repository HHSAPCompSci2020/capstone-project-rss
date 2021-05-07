/*
 
 	Represents the sleep level of the student.
 
 	Author: Jeremie Park
 	Version: 1
 
 */

public class Sleep {
	
	double maxSleep;
	double currentSleep;
	
	public void act() {
		return;
	}
	
	public double getSleep() {
		return currentSleep;
	}
	
	public void addSleep(double amount) {
		currentSleep += amount;
	}
	
	public void sleep() {
		currentSleep = 100;
	}
	
}
