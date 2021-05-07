/*
 	
 	Represents the stress level of the student.
 	
 	Author: Jeremie Park
 	Version: 01
 
 */

public class Stress {
	
	double currentStress;
	double maxStress;
	
	public Stress() {
		currentStress = 0;
		maxStress = 100;
	}
	
	public void act() {
		return;
	}
	
	public double getStress() {
		return currentStress;
	}
	
	public void addStress(double amount) {
		currentStress += amount;
	}
	
}
