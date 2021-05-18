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
	
	public BrainCell() {
		brainCellRate = 0;
		totalBrainCells = (double)1100000000;
		sleep = new Sleep();
		stress = new Stress();
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
		stress.addStress(amount);
	}
	
	public double getStress() {
		return stress.getStress();
	}
	
	public void setTotal(double amount) {
		totalBrainCells = amount;
	}
	
	/**
	 * Causes the amount of sleep and stress to decrease; call every second
	 */
	public void act() {
		sleep.act();
		stress.act();
	}
	
}
