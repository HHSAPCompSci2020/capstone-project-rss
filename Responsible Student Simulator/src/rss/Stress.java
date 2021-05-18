package rss;

/**
 * Class that represents the stress level of the student
 * @author Jeremie Park
 *
 */
public class Stress {
	
	double currentStress;
	double maxStress;
	
	public Stress() {
		currentStress = 0;
		maxStress = 100;
	}
	
	public void act() {
		if (currentStress >= 0.2) {
			currentStress -= 0.2;
		}
	}
	
	public double getStress() {
		return currentStress;
	}
	
	public void setStress(double amount) {
		currentStress = amount;
	}
	
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
