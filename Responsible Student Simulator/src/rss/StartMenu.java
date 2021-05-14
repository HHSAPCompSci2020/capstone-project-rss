package rss;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartMenu extends JPanel implements ActionListener{

	Window window;
	
	public StartMenu(Window window) {
		this.window = window;
		
		JButton button = new JButton("Press me!");
		button.addActionListener(this);
		add(button);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		window.goToMenu();
	}

}
