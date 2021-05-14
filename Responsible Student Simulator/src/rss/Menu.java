package rss;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * JPanel that gets refreshed to show the totals from BrainCell, sleep, and stress
 * @author Jeremie Park, Megan Choy
 *
 */
public class Menu extends JPanel implements ActionListener {

	Window window;
	BrainCell brain;
	double rate, total, stress, sleep;
	Graphics g;
	
	public Menu (Window window, BrainCell brain) {
		this.window = window;
		this.brain = brain;
	}
	
	  public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g); 
	    setBackground(Color.WHITE);
	    g.setColor(Color.BLACK);
		g.drawString("Brain Cells: " + (int)brain.getTotal() + "\n Brain Cell Rate: " + (int)brain.getRate() + "\n  Stress Level: " + (int)brain.stress.getStress() + "\n  Sleep Level: " + (int)brain.sleep.getSleep(), 5, 20);

	    
	  }
	
	public void repaint() {
		super.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
	}

}
