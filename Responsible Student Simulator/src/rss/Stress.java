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
		currentStress++;
	}
	
	public double getStress() {
		return currentStress;
	}
	
	public void setStress(double amount) {
		currentStress = amount;
	}
	
	public void addStress(double amount) {
		currentStress += amount;
	}
	
}
