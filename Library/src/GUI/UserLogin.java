package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserLogin implements ActionListener {

	
	JFrame loginFrame,signUpFrame,adminFrame, adminFailed, forgetPasswordFrame;
	JTextField getIDLogin, getIDSignUp, getIDAdmin, confirmPassword, getInfo, enterInfo, enterID, newConfirmPassword;
	JPasswordField getPasswordLogin, getPasswordSignUp, getPasswordAdmin, newPassword;
	JButton submitLogin, submitSignUp, submitAdmin, forgetPassword, signUp, forgetPasswordSubmit;
	
	void loginPage() {
		
		loginFrame = new JFrame("Virtual Library");
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setSize(960,540);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel titlePane = new JPanel();
		titlePane.add(new JLabel("WELCOME USER"));
		
		mainPanel.add(titlePane);
		mainPanel.add(new JPanel());
		
		JPanel pane1 = new JPanel();
	
		getIDLogin = new JTextField(20);
		
		pane1.add(new JLabel("Enter ID: "));
		pane1.add(getIDLogin);
		mainPanel.add(pane1);
		
		JPanel pane2 = new JPanel();
		
		getPasswordLogin = new JPasswordField(20);
		
		pane2.add(new JLabel("Password: "));
		pane2.add(getPasswordLogin);
		char defaultEcho = getPasswordLogin.getEchoChar();

		JCheckBox showPassword = new JCheckBox("Show Password");

		showPassword.addActionListener(e -> {
		    if (showPassword.isSelected()) {
		        getPasswordLogin.setEchoChar((char) 0);
		    } else {
		        getPasswordLogin.setEchoChar(defaultEcho);
		    }
		});

		pane2.add(showPassword);
		mainPanel.add(pane2);
		
		JPanel pane3 = new JPanel();
		submitLogin = new JButton("Submit");
		pane3.add(submitLogin);
		mainPanel.add(pane3);
		
		JPanel pane4 = new JPanel();
		mainPanel.add(pane4);
		
		JPanel pane5 = new JPanel();
		forgetPassword = new JButton("Forget Password");
		forgetPassword.addActionListener(this);
		signUp = new JButton("Sign Up");
		signUp.addActionListener(this);
		pane5.add(forgetPassword);
		pane5.add(signUp);
		mainPanel.add(pane5);
		
		loginFrame.add(mainPanel);
		loginFrame.setVisible(true);
	}
	
	void signUP() {
		
		
		signUpFrame = new JFrame("Sign Up");
		signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signUpFrame.setSize(960,540);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		mainPanel.add(new JPanel().add(new JLabel("SIGN UP")));
		mainPanel.add(new JPanel());
		
		JPanel pane1 = new JPanel();
		
		getIDSignUp = new JTextField(20);
		
		pane1.add(new JLabel("Enter ID: "));
		pane1.add(getIDSignUp);
		mainPanel.add(pane1);
		
		
		JPanel pane2 = new JPanel();
		
		getPasswordSignUp = new JPasswordField(20);
		
		pane2.add(new JLabel("Password: "));
		pane2.add(getPasswordSignUp);
		char defaultEcho = getPasswordSignUp.getEchoChar();

		JCheckBox showPassword = new JCheckBox("Show Password");

		showPassword.addActionListener(e -> {
		    if (showPassword.isSelected()) {
		        getPasswordSignUp.setEchoChar((char) 0);
		    } else {
		        getPasswordSignUp.setEchoChar(defaultEcho);
		    }
		});

		pane2.add(showPassword);
		mainPanel.add(pane2);
		
		JPanel pane3 = new JPanel();
		confirmPassword = new JTextField(20);
		pane3.add(new JLabel("Confirn Password: "));
		pane3.add(confirmPassword);
		mainPanel.add(pane3);
		
		JPanel detailPane = new JPanel();
		detailPane.add(new JLabel("Enter 6 digit pin in-case of forget password:"));
		mainPanel.add(detailPane);
		
		JPanel pane4 = new JPanel();
		getInfo = new JTextField(6);
		pane4.add(getInfo);
		mainPanel.add(pane4);
		
		JPanel pane5 = new JPanel();
		submitSignUp = new JButton("Submit");
		pane5.add(submitSignUp);
		mainPanel.add(pane5);
		
		signUpFrame.add(mainPanel);
		signUpFrame.setVisible(true);
	}
	
	void forgetPassword() {
		
		forgetPasswordFrame = new JFrame("Forget Password");
		forgetPasswordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		forgetPasswordFrame.setSize(960, 540);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel pane1 = new JPanel();
		enterID = new JTextField(20);
		pane1.add(new JLabel("Enter ID: "));
		pane1.add(enterID);
		mainPanel.add(pane1);
		
		JPanel pane2 = new JPanel();
		enterInfo = new JTextField(6);
		pane2.add(new JLabel("Enter The 6 Digit Reset Pin: "));
		pane2.add(enterInfo);
		mainPanel.add(pane2);
		
		JPanel pane3 = new JPanel();
		newPassword = new JPasswordField(20);
		pane3.add(new JLabel("New Password: "));
		pane3.add(newPassword);
		char defaultEcho = getPasswordLogin.getEchoChar();

		JCheckBox showPassword = new JCheckBox("Show Password");

		showPassword.addActionListener(e -> {
		    if (showPassword.isSelected()) {
		        newPassword.setEchoChar((char) 0);
		    } else {
		        newPassword.setEchoChar(defaultEcho);
		    }
		});
		pane3.add(showPassword);
		mainPanel.add(pane3);
		
		JPanel pane4 = new JPanel();
		newConfirmPassword = new JTextField(20);
		pane4.add(new JLabel("Confirm Password: "));
		pane4.add(newConfirmPassword);
		mainPanel.add(pane4);
		
		JPanel pane5 = new JPanel();
		forgetPasswordSubmit = new JButton("Submit");
		pane5.add(forgetPasswordSubmit);
		mainPanel.add(pane5);
		
		forgetPasswordFrame.add(mainPanel);
		forgetPasswordFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == signUp) {
			loginFrame.dispose();
			signUP();
		}
		
		if(e.getSource() == forgetPassword) {
			loginFrame.dispose();
			forgetPassword();
		}
		
	}
	
	
	
}


