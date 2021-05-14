package rss;
/*
 
 	Author: Jeremie Park
 	Version: 02
 
 */

public class BrainCell {
	
	private double brainCellRate;
	private double totalBrainCells;
	private double prestigeLevel;
	protected Sleep sleep;
	protected Stress stress;
	
	public BrainCell() {
		brainCellRate = 0;
		totalBrainCells = 100;
		prestigeLevel = 0;
		sleep = new Sleep();
		stress = new Stress();
	}
	
	public double getRate() {
		double finalRate = brainCellRate;
		double multipliers = 1;
		multipliers += prestigeLevel;
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
	
	public void prestige() {
		prestigeLevel++;
	}
	
	public void setRate(double amount) {
		brainCellRate = amount;
	}
	
	public void sleep() {
		sleep.setSleep(100);
	}
	
	/**
	 * Causes the amount of sleep and stress to decrease; call every second
	 */
	public void act() {
		if (sleep.getSleep() > 0) {
			sleep.addSleep(-1);
		}
		if (stress.getStress() > 0) {
			stress.addStress(-1);
		}

	
	}
	
}
