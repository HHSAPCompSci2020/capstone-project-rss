import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*
 
 	Author:
 	Version:
 
 */
public class Menu extends JPanel implements ActionListener {

	Main window;
	JLabel brainRates;
	double rate, total, stress, sleep;
	
	public Menu (Main window, double total, double rate, double stress, double sleep) {
		super(new BorderLayout());
		this.window = window;
		this.total = total;
		this.rate = rate;
		this.sleep = sleep;
		this.stress = stress;
		
		brainRates = new JLabel("Brain Cells: " + total + "\n Brain Cell Rate: " + rate + "\n Stress Level: " + stress + "\n Sleep Level: " + sleep, JLabel.CENTER);
		
		add(brainRates, BorderLayout.PAGE_START);
		


	}
	
	public void repaint(double total, double rate, double stress, double sleep) {
		brainRates.setText("Brain Cells: " + total + "\n Brain Cell Rate: " + rate + "\n Stress Level: " + stress + "\n Sleep Level: " + sleep);
		super.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
	}

}
