package rss;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
	Image angrythonk, thonk, bonkthonk;
	CoursePanel coursePanel;
	
	public Menu (Window window, BrainCell brain, CoursePanel coursePanel) {
		this.window = window;
		this.brain = brain;
		this.coursePanel = coursePanel;
		angrythonk = new ImageIcon("angry_thonk.png").getImage();
		thonk = new ImageIcon("thonk.png").getImage();
		bonkthonk = new ImageIcon("bonkthonk.png").getImage();
	}
	
	  public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g); 
	    
	    int width = super.getWidth();
		int height = getHeight();
		
		double xRatio = width/800.0;
		double yRatio = height/600.0;
		
	    rate = brain.getRate();
	    total = brain.getTotal();
	    sleep = brain.getSleep();
	    stress = brain.getStress();

	    g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
	    
	    setBackground(Color.WHITE);
	    g.setColor(Color.BLACK);
	    //TODO figure out how to center these
		g.drawString("Brain Cells: " + (int)total, 500, 20);
		g.drawString("Brain Cell Rate: " + (int)rate, 490, 40);

		bars(g);
		outlines(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.scale(xRatio, yRatio);
		
		if (stress > 50)
			g2.drawImage(angrythonk, 0, 50, (int)(300 * xRatio), (int)(600 * yRatio), this);
		else if (sleep < 50)
			g2.drawImage(bonkthonk, 0, 50, (int)(300 * xRatio), (int)(600 * yRatio), this);
		else
			g2.drawImage(thonk, 0, 50, (int)(300 * xRatio), (int)(600 * yRatio), this);
	  }
	
	public void repaint() {
		super.repaint();
	}
	
	private void bars(Graphics g) {
		int xTopLeft = 5;
		int yTopLeft = 280;
		
		//Green bar that dwindles down
	    g.setColor(Color.GREEN);
	    g.fillRect(xTopLeft, yTopLeft, (int)sleep, 10);
	    g.fillRect(xTopLeft, yTopLeft+20, (int)stress, 10);
	    
	    //Outlines for the sleep and stress bars
	    g.setColor(Color.BLACK);
	    g.drawRect(xTopLeft, yTopLeft, 100, 10);
	    g.drawRect(xTopLeft, yTopLeft+20, 100, 10);
	    g.drawString("Sleep: " + (int)sleep, xTopLeft + 105, yTopLeft + 10);
	    g.drawString("Stress: " + (int)stress, xTopLeft + 105, yTopLeft + 30);

//	    //Course progress bar
//	    g.setColor(Color.GREEN);
//	    g.fillRect(400, yTopLeft, (int)coursePanel.getRunningCourse().getProgress() * 100, 10);
//	    g.setColor(Color.BLACK);
//	    g.drawRect(400, yTopLeft, 100, 10);
	}
	
	private void outlines(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 300, 250);
		g.drawRect(0, 250, 300, 100);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
	}

}
