import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CoursePanel extends JPanel implements ActionListener{

	private ArrayList<Course> courses = new ArrayList<Course>();
	private BrainCell brainCell;

	
	public CoursePanel(BrainCell brainCell) {
		this.brainCell = brainCell;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
