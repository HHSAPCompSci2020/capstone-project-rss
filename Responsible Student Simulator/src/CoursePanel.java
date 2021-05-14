import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CoursePanel extends JPanel implements ActionListener{

	private ArrayList<Course> courses = new ArrayList<Course>();
	private JButton mathButton;
	private BrainCell brainCell;
	private Course math, science, english, history;
	
	public CoursePanel(BrainCell brainCell) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.brainCell = brainCell;
		
		math = new Course("Algebra", 100, 50, 5);
		courses.add(math);
		
		mathButton = new JButton("<html>Flip Phone<br>maffs?<br>Cost: ");
		mathButton.setText(mathButton.getText() + (int)courses.get(0).getCost());
		mathButton.setText(mathButton.getText() + "<br>Level: ");
		mathButton.setText(mathButton.getText() + (int)courses.get(0).getLevel());
		
		mathButton.addActionListener(this);
		
		this.add(mathButton);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("test");
		if (e.getSource().equals(mathButton)) {
			if (math.getProgress() == 0) {
				System.out.println("start");
				math.startProduction();
			}
		}
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
		
}

