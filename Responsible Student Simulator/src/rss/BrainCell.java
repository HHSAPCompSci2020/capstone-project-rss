package rss;

/*
 
 	Contains values relating to braincells, such as the total amount and production rate
 	Author: Jeremie Park
 	Version: 02
 
 */
public class BrainCell {
	
	private double brainCellRate;
	private double totalBrainCells;
	protected Prestige prestige;
	private Sleep sleep;
	private Stress stress;
	private Happiness happiness;
	
	/**
	 * Constructs a BrainCell with default values for all of its fields
	 */
	public BrainCell() {
		brainCellRate = 0;
		totalBrainCells = 10000000000000.0;
		sleep = new Sleep();
		stress = new Stress();
		happiness = new Happiness();
		prestige = new Prestige("Prestige", "Reset ALL currnet progress to gain a permanent production modifier bonus.", 1000000000);
	}
	
	/**
	 * Returns brainCellRate
	 * @return a double containing the current rate of braincell production
	 */
	public double getRate() {
		double finalRate = brainCellRate;
		double multipliers = 1;
		multipliers += prestige.getOwned();
		if (sleep.getSleep() < 30) {
			multipliers -= 0.2;
		} 
		if (sleep.getSleep() < 10) {
			multipliers -= 0.3;
		}
		if (stress.getStress() > 70) {
			multipliers -= 0.2;
		}
		if (stress.getStress() > 90) {
			multipliers -= 0.3;
		}
		if (happiness.getHappiness() < 10) {
			multipliers -= 0.3;
		}
		if (happiness.getHappiness() < 30) {
			multipliers -= 0.2;
		}
		if (happiness.getHappiness() > 70) {
			multipliers += 0.2;
		}
		if (happiness.getHappiness() > 90) {
			multipliers += 0.3;
		}
		return finalRate * multipliers;
	}
	
	/**
	 * Gets the total amount of brain cells
	 * @return a double containing the current total brain cell count
	 */
	public double getTotal() {
		return totalBrainCells;
	}
	
	/**
	 * Adds a given amount to the total brain cell count
	 * @param addAmount - a double containing the amount of brain cells to add to total
	 */
	public void addTotal(double addAmount) {
		totalBrainCells += addAmount;
	}
	
	/**
	 * Adds a given rate to the current brain cell prodcution rate
	 * @param addAmount - the amount to add to brainCellRate
	 */
	public void addRate(double addAmount) {
		brainCellRate += addAmount;
	}
	
	/**
	 * Sets a given rate to the current brain cell prodcution rate
	 * @param amount - the amount to assign to brainCellRate
	 */
	public void setRate(double amount) {
		brainCellRate = amount;
	}
	
	/**
	 * Replenishes sleep to 100
	 */
	public void sleep() {
		sleep.setSleep(100);
	}
	
	/**
	 * Gets the current amount of sleep
	 * @return - a double containing the current amount of sleep
	 */
	public double getSleep() {
		return sleep.getSleep();
	}
	
	/**
	 * Adds a given amount of stress to the current amount of stress
	 * @param amount - a double containing the amount of stress to add
	 */
	public void addStress(double amount) {
		stress.addStress(amount * (prestige.getOwned() + 1));
	}
	
	/**
	 * Gets the current amount of stress
	 * @return - a double containing the current amount of stress
	 */
	public double getStress() {
		return stress.getStress();
	}
	
	/**
	 * Gets the current amount of happiness
	 * @return - a double containing the current amount of happiness
	 */
	public double getHappiness() {
		return happiness.getHappiness();
	}
	
	/**
	 * Adds a given amount of happiness to the current amount of happiness
	 * @param amount - a double containing the amount of happiness to add
	 */
	public void addHappiness(double amount) {
		happiness.addHappiness(amount);
	}
	
	/**
	 * Sets a given rate to the current brain cell count
	 * @param amount - the amount to assign to totalBrainCells
	 */
	public void setTotal(double amount) {
		totalBrainCells = amount;
	}
	
	/**
	 * Causes the amount of sleep and stress to decrease; called every second
	 */
	public void act() {
		sleep.act(prestige.getOwned()+1);
		stress.act();
	}
	
}
