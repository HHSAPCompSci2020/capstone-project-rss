/*
 
 	Author: Jeremie Park
 	Version: 02
 
 */

public class BrainCell {
	
	double brainCellRate = 0;
	double totalBrainCells = 0;
	double prestigeLevel = 0;
	
	public BrainCell() {
		brainCellRate = 0;
		totalBrainCells = 0;
		prestigeLevel = 0;
	}
	
	public double getRate() {
		return brainCellRate;
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
	
}
