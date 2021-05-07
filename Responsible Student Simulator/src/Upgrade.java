
public class Upgrade {

	double baseCost;
	double currentCost;
	double baseProduction;
	int owned;
	
	public Upgrade(double baseProduction, double baseCost) {
		this.baseCost = baseCost;
		this.baseProduction = baseProduction;
		currentCost = baseCost;
		owned = 0;
	}
	
	public void buy() {
		return;
	}
	
	public void levelUp() {
		
	}
	
}
