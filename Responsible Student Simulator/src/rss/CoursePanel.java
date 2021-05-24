package rss;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Contains all buttons and classes related to courses and used to start
 * production for courses and displaying buttons
 * 
 * @author Jeremie Park, Megan Choy
 *
 */
public class CoursePanel extends JPanel implements ActionListener {

	private ArrayList<Course> courses = new ArrayList<Course>();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private JButton mathButton, scienceButton, englishButton, historyButton;
	private BrainCell brainCell;
	private Course math, science, english, history;

	public CoursePanel(BrainCell brainCell) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.brainCell = brainCell;

		math = new Course("Algebra", "maffs?", 100, 0, 5);
		science = new Course("Biology", "cells studying themselves", 10000, 1000, 7);
		english = new Course("American Literature", "genocide", 50000, 5000, 10);
		history = new Course("World History", "zzzzz", 100000, 20000, 18);
		courses.add(math);
		courses.add(science);
		courses.add(english);
		courses.add(history);

		mathButton = new JButton(math.toString());
		scienceButton = new JButton(science.toString());
		englishButton = new JButton(english.toString());
		historyButton = new JButton(history.toString());

		buttons.add(mathButton);
		buttons.add(scienceButton);
		buttons.add(englishButton);
		buttons.add(historyButton);

		for (int i = 0; i < buttons.size(); i++) {
	        buttons.get(i).setBackground(new Color(95, 107, 125));
	        buttons.get(i).setForeground(Color.WHITE);
	        buttons.get(i).setFocusPainted(false);
	        buttons.get(i).setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
		}
		
		mathButton.addActionListener(this);
		scienceButton.addActionListener(this);
		englishButton.addActionListener(this);
		historyButton.addActionListener(this);

		this.add(mathButton);
		this.add(scienceButton);
		this.add(englishButton);
		this.add(historyButton);

	}

	/**
	 * Checks for a button being pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		int index = buttons.indexOf(e.getSource());
		courses.get(index);
		//System.out.println("index: " + index);
		if (Course.inProduction) {
//			System.out.println("still in production");
			return;
		} else if (courses.get(index).getUnlocked() && courses.get(index).getProgress() == 0) { // If course is unlocked and nothing is in production
//				System.out.println("start");
			courses.get(index).startProduction();
		} else if (!courses.get(index).getUnlocked()) { // If unlocked, try to buy
//				System.out.println("attempt to buy");
			courses.get(index).buy(brainCell.getTotal());
			if (courses.get(index).getUnlocked()) {
				brainCell.addTotal(-courses.get(index).getCost());
			}
			buttons.get(index).setText(courses.get(index).toString());
		} 
	}

	/**
	 * Returns the ArrayList of Courses used in this panel
	 * @return ArrayList of Courses used in the panel
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	/**
	 * Returns the course that is running, if null then no courses are running
	 * @return Course that is running
	 */
	public Course getRunningCourse() {
		
		if (Course.inProduction) {
			for (int i = 0; i < courses.size(); i++) {
				if (courses.get(i).getRunning()) {
					return courses.get(i);
				}
			}
		}
		return null;
	}

	/**
	 * Updates the text of the button of the given index
	 * @param index - index of the button to update
	 */
	public void updateButtons(int index) {
		buttons.get(index).setText(courses.get(index).toString());
	}
}
