package rss;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

/**
 * JPanel that contians buttons for prestige
 * @author Jeremie Park
 *
 */
public class OtherPanel extends JPanel implements ActionListener{

	private BrainCell brain;
	private JButton prestige, sleep;
	private boolean canPrestige;
	protected boolean prestiged;
	
	public OtherPanel(BrainCell brain) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.brain = brain;
		prestige = new JButton("<html><b>PRESTIGE</b><br>Reset ALL currnet progress to gain a permanent production modifier bonus.<br> Cost: 1,000,000,000 <br>Current Modifier: 1 </html>");
		sleep = new JButton("<html>Sleep<br>Go to sleep! Replenishes sleep back to 100.");
		
		sleep.addActionListener(this);
		
		this.add(prestige);
		this.add(sleep);
		canPrestige = false;
		prestiged = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(prestige) && canPrestige) {
			prestiged = true;
		} else if (e.getSource().equals(sleep)) {
			
			brain.sleep();
		}
		
	}
	
}
