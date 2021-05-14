import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class UpgradeButton extends JButton implements ActionListener {
	
	private Upgrade upgrade;
	
	public UpgradeButton(Upgrade upgrade, String text) {
		super(text);
		this.upgrade = upgrade;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		upgrade.buy();
		System.out.println("test");
		
	}
	
}
