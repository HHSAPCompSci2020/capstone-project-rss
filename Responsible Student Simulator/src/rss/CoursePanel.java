package rss;

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
	private JButton mathButton, scienceButton;
	private BrainCell brainCell;
	private Course math, science, english, history;

	public CoursePanel(BrainCell brainCell) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.brainCell = brainCell;

		math = new Course("Algebra", "maffs?", 100, 0, 5);
		science = new Course("Biology", "cells studying themselves", 500, 10, 10);
		courses.add(math);
		courses.add(science);

		mathButton = new JButton(math.toString());
		scienceButton = new JButton(science.toString());
//		mathButton.setText(mathButton.getText() + (int)courses.get(0).getProduction());
//		mathButton.setText(mathButton.getText() + "<br>Unlocked: ");
//		mathButton.setText(mathButton.getText() + courses.get(0).getUnlocked());
		buttons.add(mathButton);
		buttons.add(scienceButton);

		mathButton.addActionListener(this);
		scienceButton.addActionListener(this);

		this.add(mathButton);
		this.add(scienceButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int index = buttons.indexOf(e.getSource());
		courses.get(index);
		//			System.out.println("index: " + index);
		if (Course.inProduction) {
			return;
		} else if (courses.get(index).getUnlocked() && courses.get(index).getProgress() == 0) { // If course is unlocked and nothing is in production
				System.out.println("start");
			courses.get(index).startProduction();
		} else if (!courses.get(index).getUnlocked()) { // If unlocked, try to buy
				System.out.println("attempt to buy");
			courses.get(index).buy(brainCell.getTotal());
			buttons.get(index).setText(courses.get(index).toString());
		} 
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

}
