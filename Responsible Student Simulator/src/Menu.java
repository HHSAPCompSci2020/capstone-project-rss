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
	
	public Menu (Main window) {
		super(new BorderLayout());
		this.window = window;
		
		JLabel brainCell = new JLabel("Brain Cells: " + "\n Brain Cell Rates: ", JLabel.CENTER);
	
		add(brainCell, BorderLayout.PAGE_START);

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
