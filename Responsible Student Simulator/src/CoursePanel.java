import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CoursePanel extends JPanel implements ActionListener{

	private ArrayList<Course> courses = new ArrayList<Course>();
	private BrainCell brainCell;
	private Course math, science, english, history;
	
	public CoursePanel(BrainCell brainCell) {
		this.brainCell = brainCell;
		
		math = new Course("Algebra", 100, 50, 5);
		courses.add(math);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
