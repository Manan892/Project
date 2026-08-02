package GUI;

import javax.swing.*;

public class AdminLogin{
	
	JFrame adminFrame, adminFailed;
	JTextField getIDAdmin;
	JPasswordField getPasswordAdmin;
	JButton submitAdmin;
	
void adminPage() {
		
		adminFrame = new JFrame("Hello Admin");
		adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminFrame.setSize(960, 540);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel pane1 = new JPanel();
		pane1.add(new JLabel("Enter ID: "));
		getIDAdmin = new JTextField(9);
		pane1.add(getIDAdmin);
		mainPanel.add(pane1);
		
		JPanel pane2 = new JPanel();
		pane2.add(new JLabel("Password: "));
		getPasswordAdmin = new JPasswordField(20);
		pane2.add(getPasswordAdmin);
		mainPanel.add(pane2);
		
		JPanel pane3 = new JPanel();
		submitAdmin = new JButton("Submit");
		submitAdmin.addActionListener(e -> {

		    String id = getIDAdmin.getText();
		    String password = new String(getPasswordAdmin.getPassword());

		    if (id.isEmpty() || password.isEmpty()) {
		        JOptionPane.showMessageDialog(
		            adminFrame,
		            "Please enter both ID and Password.",
		            "Missing Information",
		            JOptionPane.WARNING_MESSAGE
		        );
		        return;
		    }

		    if (id.equals("SudoAdmin") && password.equals("Let's_Add_B@@ks")) {
		        
		    	//GO TO ADMIN PAGE
		    	
		    	
		    } else {
		    	
		    	adminFrame.dispose(); 
		    	
		        JOptionPane.showMessageDialog(
		            adminFrame,
		            "Invalid ID or Password!",
		            "Login Failed",
		            JOptionPane.ERROR_MESSAGE
		        );
		    }

		});
		pane3.add(submitAdmin);
		mainPanel.add(pane3);
		
		adminFrame.add(mainPanel);
		adminFrame.setVisible(true);
	}

	void adminFailed() {
		
		adminFailed = new JFrame();
		adminFailed.setSize(480, 270);
		adminFailed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel msg = new JPanel();
		msg.add(new JLabel("Wrong Credentials!!"));
		
		adminFailed.add(msg);
		adminFailed.setVisible(true);
	}
	
}
