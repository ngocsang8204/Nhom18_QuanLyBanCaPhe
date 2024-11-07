package Run;

import java.awt.EventQueue;

import GUI.Login;

public class App {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private Login frame;

			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
	}
}
