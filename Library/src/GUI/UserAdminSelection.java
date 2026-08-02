package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserAdminSelection implements ActionListener{

	JFrame f;
	JButton user, admin;
	
	void homePage() {
		
		f = new JFrame("Welcome to Virtual Library");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(960, 540);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		
		JPanel titlePane = new JPanel();
		titlePane.add(new JLabel("Welcmoe to Virtual Library"));
		mainPanel.add(titlePane);
		
		JPanel pane1 = new JPanel();
		user = new JButton("User");
		user.addActionListener(this);
		pane1.add(user);
		mainPanel.add(pane1);
		
		JPanel pane2 = new JPanel();
		
		admin = new JButton("Admin");
		admin.addActionListener(this);
		pane2.add(admin);
		mainPanel.add(pane2);		
		
		f.add(mainPanel);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == user) {
			f.dispose();
			new UserLogin().loginPage();
		}
		
		if(e.getSource() == admin) {
			f.dispose();
			new AdminLogin().adminPage();
		}
		
	}
	
	public static void main(String args[]) {
		new UserAdminSelection().homePage();
	}
}
