package rss;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * JPanel that gets refreshed to show the totals from BrainCell, sleep,
 * happiness, and stress
 * 
 * @author Jeremie Park, Megan Choy
 *
 */
public class Menu extends JPanel implements ActionListener {

	Window window;
	BrainCell brain;
	double rate, total, stress, sleep, happiness;
	Graphics g;
	Image angrythonk, thonk, bonkthonk;
	CoursePanel coursePanel;
	UpgradePanel upgradePanel;

	/**
	 * Creates a Menu that updates values from BrainCell, CoursePanel, and
	 * UpgradePanel classes provided
	 * 
	 * @param window       The window that Menu is being drawn on
	 * @param brain        The BrainCell class used
	 * @param coursePanel  The CoursePanel class used
	 * @param upgradePanel The UpgradePanel class used
	 */
	public Menu(Window window, BrainCell brain, CoursePanel coursePanel, UpgradePanel upgradePanel) {
		this.window = window;
		this.brain = brain;
		this.coursePanel = coursePanel;
		this.upgradePanel = upgradePanel;
		angrythonk = new ImageIcon("angry_thonk.png").getImage();
		thonk = new ImageIcon("thonk.png").getImage();
		bonkthonk = new ImageIcon("bonkthonk.png").getImage();
	}

	/**
	 * Paints the Menu with udpated values
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int width = super.getWidth();
		int height = getHeight();

		double xRatio = width / 800.0;
		double yRatio = height / 600.0;

		rate = brain.getRate();
		total = brain.getTotal();
		sleep = brain.getSleep();
		stress = brain.getStress();
		happiness = brain.getHappiness();

		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));

		setBackground(Color.WHITE);
		g.setColor(Color.BLACK);
		// TODO figure out how to center these
		g.drawString("Brain Cells: " + (int) total, 500, 20);
		g.drawString("Brain Cell Rate: " + (int) rate, 490, 40);

		bars(g);
		outlines(g);
		warnings(g);

		Graphics2D g2 = (Graphics2D) g;
		studentImages(g2, xRatio, yRatio);
		deskImages(g2, xRatio, yRatio);

	}

	/**
	 * Repaints the Menu to update values
	 */
	public void repaint() {
		super.repaint();
	}

	private void bars(Graphics g) {
		int xTopLeft = 5;
		int yTopLeft = 265;

		// Bars that dwindles down and changes color
		if (sleep < 10) {
			g.setColor(Color.RED);
		} else if (sleep < 30) {
			g.setColor(Color.YELLOW);
		} else {
			g.setColor(Color.GREEN);
		}
		g.fillRect(xTopLeft, yTopLeft, (int) sleep, 10);

		if (stress > 90) {
			g.setColor(Color.RED);
		} else if (stress > 70) {
			g.setColor(Color.YELLOW);
		} else {
			g.setColor(Color.GREEN);
		}
		g.fillRect(xTopLeft, yTopLeft + 20, (int) stress, 10);

		if (happiness < 10)
			g.setColor(Color.RED);
		else if (happiness < 30)
			g.setColor(Color.YELLOW);
		else
			g.setColor(Color.GREEN);
		g.fillRect(xTopLeft, yTopLeft + 60, (int) happiness, 10);

		// Outlines for the sleep and stress bars
		g.setColor(Color.BLACK);
		g.drawRect(xTopLeft, yTopLeft, 100, 10);
		g.drawRect(xTopLeft, yTopLeft + 20, 100, 10);
		g.drawRect(xTopLeft, yTopLeft + 60, 100, 10);
		g.drawString("Sleep: " + (int) sleep, xTopLeft + 105, yTopLeft + 10);
		g.drawString("Stress: " + (int) stress, xTopLeft + 105, yTopLeft + 30);
		g.drawString("Happiness: " + (int) happiness, xTopLeft + 105, yTopLeft + 70);
		// Course progress bar
		Course running = coursePanel.getRunningCourse();
//	    System.out.println(running);

		if (running != null) {
//	    	System.out.println("drawing");
			g.setColor(Color.GREEN);
			g.fillRect(xTopLeft, yTopLeft + 40, (int) (running.getProgress() * 100), 10);
			g.setColor(Color.BLACK);
			g.drawString("Course: " + running.getName(), xTopLeft + 105, yTopLeft + 50);
		} else {
			g.drawString("Course: none", xTopLeft + 105, yTopLeft + 50);
		}

		g.setColor(Color.BLACK);
		g.drawRect(xTopLeft, yTopLeft + 40, 100, 10);
	}

	private void outlines(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 300, 250);
		g.drawRect(0, 250, 300, 100);
	}

	private void studentImages(Graphics2D g2, double xRatio, double yRatio) {

		g2.scale(xRatio, yRatio);

		if (stress > 50)
			g2.drawImage(angrythonk, 0, 50, (int) (300 * xRatio), (int) (600 * yRatio), this);
		else if (sleep < 50)
			g2.drawImage(bonkthonk, 0, 50, (int) (300 * xRatio), (int) (600 * yRatio), this);
		else
			g2.drawImage(thonk, 0, 50, (int) (300 * xRatio), (int) (600 * yRatio), this);

	}

	private void deskImages(Graphics2D g2, double xRatio, double yRatio) {

		ArrayList<Image> images = new ArrayList<Image>();
		images.add(new ImageIcon("flipPhone.png").getImage());
		images.add(new ImageIcon("nokia.png").getImage());
		images.add(new ImageIcon("smartphone.png").getImage());
		images.add(new ImageIcon("minitablet.png").getImage());
		images.add(new ImageIcon("tablet.png").getImage());

		ArrayList<Upgrade> upgrades = upgradePanel.getUpgrades();

		g2.drawImage(new ImageIcon("desk.png").getImage(), 313, 100, (int) (500 * xRatio), (int) (800 * yRatio), this);

		int phone = 5; // Number of phone upgrades
		for (int i = phone - 1; i >= 0; i--) {
			if (upgrades.get(i).getOwned() > 0) {
				g2.drawImage(images.get(i), 430, 355, (int) (75 * xRatio), (int) (150 * yRatio), this);
				i = -1;
			}
		}

//		ArrayList<Image> computerImages = new ArrayList<Image>();
//		computerImages.add(new ImageIcon("laptop.png").getImage());
//		computerImages.add(new ImageIcon("pc.png").getImage());
//		
//		int computer = 2;
//		for (int i = computer -1; i >= 0; i--) {
//			if (upgrades.get(i).getOwned() > 0) {
//				g2.drawImage(computerImages.get(i), 450, 355, (int)(75 * xRatio), (int)(150 * yRatio), this);
//				i = -1;
//			}
//		}
		if (upgrades.get(8).getOwned() > 0) {
			g2.drawImage(new ImageIcon("desktopupgrades.png").getImage(), 620, 315, (int) (112.5 * xRatio),
					(int) (225 * yRatio), this);
		} else if (upgrades.get(6).getOwned() > 0) {
			g2.drawImage(new ImageIcon("pc.png").getImage(), 620, 315, (int) (112.5 * xRatio), (int) (225 * yRatio),
					this);
		} else if (upgrades.get(5).getOwned() > 0) {
			g2.drawImage(new ImageIcon("laptop.png").getImage(), 620, 330, (int) (75 * xRatio), (int) (150 * yRatio),
					this);
		}

		if (upgrades.get(11).getOwned() > 0) {
			g2.drawImage(new ImageIcon("hologram.png").getImage(), 470, 190, (int) (187.5 * xRatio),
					(int) (375 * yRatio), this);
		} else if (upgrades.get(7).getOwned() > 0) {
			g2.drawImage(new ImageIcon("ultrawide.png").getImage(), 470, 225, (int) (187.5 * xRatio),
					(int) (375 * yRatio), this);
		}

		if (upgrades.get(9).getOwned() > 0) {
			g2.drawImage(new ImageIcon("mouse.png").getImage(), 590, 365, (int) (75 * xRatio), (int) (150 * yRatio),
					this);
		}
		if (upgrades.get(10).getOwned() > 0) {
			g2.drawImage(new ImageIcon("keyboard.png").getImage(), 520, 375, (int) (75 * xRatio), (int) (150 * yRatio),
					this);
		}

	}

	private void warnings(Graphics g) {
		g.setColor(Color.RED);
		if (sleep < 30) {
			g.drawString("Brain cell rate is decreased because of low sleep!", 350, 60);
		} else if (stress > 70) {
			g.drawString("Brain cell rate is decreased because of high stress!", 350, 60);
		} else if (happiness < 30) {
			g.drawString("Brain cell rate is decreased because of unhappiness!", 350, 60);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
