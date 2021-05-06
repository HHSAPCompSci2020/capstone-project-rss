import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
	
	public Main(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    setVisible(true);
	    
	}

	public static void main(String[] args)
	{
		Main w = new Main("Responsible Student Simulator");
	}
}