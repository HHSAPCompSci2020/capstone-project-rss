package rss;

public class StressEvent {

	private double cost;
	private double value;
	private String name, desc;
	
	public StressEvent(String name, String desc, double cost, double value) {
		this.cost = cost;
		this.value = value;
		this.name = name;
		this.desc = desc;
	}
	
	public double getCost() {
		return cost;
	}
	
	public double getValue() {
		return value;
	}
	
	public String toString() {
		return "<html>" + name + "<br>" + desc + "<br>Cost: " + (int)getCost() + "<br>Decreases Stress by: " + (int)getValue();
	}
	
	
}
