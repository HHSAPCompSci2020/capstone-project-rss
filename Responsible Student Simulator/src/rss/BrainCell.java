package rss;
/*
 
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
	
	public BrainCell() {
		brainCellRate = 0;
		totalBrainCells = 0;
		sleep = new Sleep();
		stress = new Stress();
		happiness = new Happiness();
		prestige = new Prestige("Prestige", "Reset ALL currnet progress to gain a permanent production modifier bonus.", 1000000000);
	}
	
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
	
	public double getTotal() {
		return totalBrainCells;
	}
	
	public void addTotal(double addAmount) {
		totalBrainCells += addAmount;
	}
	
	public void addRate(double addAmount) {
		brainCellRate += addAmount;
	}
	
	public void setRate(double amount) {
		brainCellRate = amount;
	}
	
	public void sleep() {
		sleep.setSleep(100);
	}
	
	public double getSleep() {
		return sleep.getSleep();
	}
	
	public void addStress(double amount) {
		stress.addStress(amount * (prestige.getOwned() + 1));
	}
	
	public double getStress() {
		return stress.getStress();
	}
	
	public double getHappiness() {
		return happiness.getHappiness();
	}
	
	public void addHappiness(double amount) {
		happiness.addHappiness(amount);
	}
	
	public void setTotal(double amount) {
		totalBrainCells = amount;
	}
	
	/**
	 * Causes the amount of sleep and stress to decrease; call every second
	 */
	public void act() {
		sleep.act(prestige.getOwned()+1);
		stress.act();
	}
	
}
