package rss;

/**
 * Class that represents a stress event
 * @author Jeremie
 *
 */
public class StressEvent {

	private double cost;
	private double value;
	private double happiness;
	private String name, desc;
	
	/**
	 * Constructs a StressEvent class with given parameters; displayed on OtherPanel
	 * @param name - Name of the event
	 * @param desc - Description of the event
	 * @param cost - Brain Cell Cost of the event
	 * @param value - Amount of stress that the StressEvent subtracts
	 * @param happiness - Amount of happiness that the StressEvent adds
	 */
	public StressEvent(String name, String desc, double cost, double value, double happiness) {
		this.cost = cost;
		this.value = value;
		this.name = name;
		this.desc = desc;
		this.happiness = happiness;
	}
	
	/**
	 * Returns the cost of the event
	 * @return - a double containing the cost of the event
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Returns the value of the event
	 * @return - a double containing the value of the event
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Returns the happiness of the event
	 * @return - a double containing the happiness of the event
	 */
	public double getHappiness() {
		return happiness;
	}
	
	/**
	 * Converts the StressEvent to a string; used for the text on the buttons for a StressEvent on OtherPanel
	 * @return - String with name, desc, cost, value, and happiness on separated lines
	 */
	public String toString() {
		return "<html><i>-" + name + "-</i><br>" + desc + "<br>Cost: " + (int)getCost() + "<br>Decreases Stress by: " + (int)getValue() + "<br> Increases Hapiness By: " + (int)getHappiness();
	}
	
	
}
