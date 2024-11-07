package GUI;

import java.awt.Color;
import java.awt.Label;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CaiDat extends JPanel {

	/**
	 * Create the panel.
	 */
	public CaiDat() {
		this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setBounds(0, 0, 1600, 954);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 172, 83);
        add(panel);
        
        JLabel lblNewLabel = new JLabel("JPanel Cài đặt");
        panel.add(lblNewLabel);
	}

}
