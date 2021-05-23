package rss;

public class Happiness {

	double currentHappiness;
	double maxHappiness;
	
	public Happiness() {
		currentHappiness = 50;
		maxHappiness = 100;
	}
	
	public double getHappiness() {
		return currentHappiness;
	}
	
	public void setHappiness(double amount) {
		currentHappiness = amount;
	}
	
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
