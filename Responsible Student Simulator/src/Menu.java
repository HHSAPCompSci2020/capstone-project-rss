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
	private BrainCell brainCell;
	
	public Menu (Main window, BrainCell brainCell) {
		super(new BorderLayout());
		this.window = window;
		this.brainCell = brainCell;
		
		JLabel brainRates = new JLabel("Brain Cells: " + "\n Brain Cell Rates: ", JLabel.CENTER);
	
		add(brainRates, BorderLayout.PAGE_START);

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
