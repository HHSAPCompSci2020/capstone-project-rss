package rss;

public class StressEvent {

	private double cost;
	private double value;
	private double happiness;
	private String name, desc;
	
	public StressEvent(String name, String desc, double cost, double value, double happiness) {
		this.cost = cost;
		this.value = value;
		this.name = name;
		this.desc = desc;
		this.happiness = happiness;
	}
	
	public double getCost() {
		return cost;
	}
	
	public double getValue() {
		return value;
	}
	
	public double getHappiness() {
		return happiness;
	}
	
	public String toString() {
		return "<html>" + name + "<br>" + desc + "<br>Cost: " + (int)getCost() + "<br>Decreases Stress by: " + (int)getValue() + "<br> Increases Hapiness By: " + (int)getHappiness();
	}
	
	
}
