package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import General.PasswordKey;
import General.ReadWrite;

public class UserLogin implements ActionListener {

	
	JFrame loginFrame,signUpFrame,adminFrame, adminFailed, forgetPasswordFrame;
	JTextField getIDLogin, getIDSignUp, getIDAdmin, confirmPassword, getInfo, enterInfo, enterID, newConfirmPassword;
	JPasswordField getPasswordLogin, getPasswordSignUp, getPasswordAdmin, newPassword;
	JButton submitLogin, submitSignUp, submitAdmin, forgetPassword, signUp, forgetPasswordSubmit;
	
	BackgroundWork bgw = new BackgroundWork();
	
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
		getPasswordLogin.addActionListener(this);
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
		submitLogin.addActionListener(this);
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
		submitSignUp.addActionListener(this);
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
		forgetPasswordSubmit.addActionListener(this);
		pane5.add(forgetPasswordSubmit);
		mainPanel.add(pane5);
		
		forgetPasswordFrame.add(mainPanel);
		forgetPasswordFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == signUp) {
			loginFrame.dispose();
			signUP();
		}
		
		if(e.getSource() == forgetPassword) {
			loginFrame.dispose();
			forgetPassword();
		}
	
		if(e.getSource() == submitLogin) {
			
			String getPasswordQuery = "SELECT pass FROM login WHERE id = ?";
			
			try(Connection con = ReadWrite.connect(); 
				PreparedStatement ps = con.prepareStatement(getPasswordQuery)) {
				
				ps.setString(1, getIDLogin.getText());
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					
					char[] passArr = getPasswordLogin.getPassword();
					String passStr = new String(passArr);
					java.util.Arrays.fill(passArr, '0');
					
					if(PasswordKey.decryption(rs.getString("pass")).equals(passStr)) {
						
						// GO TO MAIN PAGE
						
					} 	else {
							JOptionPane.showMessageDialog(loginFrame, "Incorrect Password", "Wrong Information", JOptionPane.ERROR_MESSAGE);
					}
					
				} 	else {
					JOptionPane.showMessageDialog(loginFrame, "Non Exsisting User ID", "Wrong Information", JOptionPane.ERROR_MESSAGE);
					}
				
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
 		}
		
		if(e.getSource() == submitSignUp) {
			
			if(getIDSignUp.getText().equals("")) {
				JOptionPane.showMessageDialog(signUpFrame , "Enter ID information", "Missing Information", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			else if(bgw.duplicateID(getIDSignUp.getText())) {
				JOptionPane.showMessageDialog(signUpFrame , "The ID already exist", "Repeating Information", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(getPasswordSignUp.getPassword().length<8) {
				JOptionPane.showMessageDialog(signUpFrame , "Too small Password", "Not secure Enough", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(getInfo.getText().length()!=6) {
				JOptionPane.showMessageDialog(signUpFrame , "Enter PIN as per Instructions", "Wrong Information", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			char[] passwordArr = getPasswordSignUp.getPassword();
			String passwordStr = new String(passwordArr);
			java.util.Arrays.fill(passwordArr, '0');	
			
			if(passwordStr.equals(confirmPassword.getText())) {
				
				String newUserQuery = "INSERT INTO login(id, pass, pin) VALUES (?, ?, ?)";
					
				try(Connection con = ReadWrite.connect(); 
					PreparedStatement signUpStatement = con.prepareStatement(newUserQuery)) {
					
					signUpStatement.setString(1, getIDSignUp.getText());
					signUpStatement.setString(2, PasswordKey.encryption(confirmPassword.getText()));
					signUpStatement.setString(3, getInfo.getText());
					
					int rows = signUpStatement.executeUpdate();
					
					if(rows>0) {
						JOptionPane.showMessageDialog(null, "User Sign-UP Succesful");
						
						// GO TO MAIN PAGE
					} else {
						JOptionPane.showMessageDialog(null, "User Sign-UP Failed");
					}
					
				}catch(SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "User Sign-UP Failed");
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Password and Confim Password does not match");
				return;
			}
			
		}
		
		if(e.getSource() == forgetPasswordSubmit) {
			
			if(enterID.getText().isEmpty()) {
				JOptionPane.showMessageDialog(forgetPasswordFrame, "Provide your ID", "Information Not Given", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			else if(!bgw.duplicateID(enterID.getText())) {
				JOptionPane.showMessageDialog(forgetPasswordFrame, "ID does not exist", "Wrong Information", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(enterInfo.getText().length()!=6) {
				JOptionPane.showMessageDialog(forgetPasswordFrame, "THe PIN doesn't match required condition", "Insufficient Information", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(newPassword.getPassword().length<8) {
				JOptionPane.showMessageDialog(forgetPasswordFrame, "Password must be atleast 8 characters long", "Weak Password", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(newConfirmPassword.getText().isEmpty()) {
				JOptionPane.showMessageDialog(forgetPasswordFrame, "Confirm Password Field can't be empty", "No data Provided", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			char[] newPassArr = newPassword.getPassword();
			String newPassStr = new String(newPassArr);
			java.util.Arrays.fill(newPassArr, '0');
				
			if(newPassStr.equals(newConfirmPassword.getText())) {
					
				String newPasswordQuery = "UPDATE login SET pass = ? WHERE id = ? AND pin = ?"; 
					
				try(Connection con = ReadWrite.connect();
						PreparedStatement setNewPass = con.prepareStatement(newPasswordQuery)) {
						
					setNewPass.setString(1, newPassStr);
					setNewPass.setString(2, enterID.getText());
					setNewPass.setString(3, enterInfo.getText());
						
					int rows = setNewPass.executeUpdate();
						
					if(rows>0) {
						JOptionPane.showMessageDialog(forgetPasswordFrame, "Password changed Succesfully", "Update Succesful", JOptionPane.INFORMATION_MESSAGE);
						forgetPasswordFrame.dispose();
						loginPage();
					}else {
						JOptionPane.showMessageDialog(forgetPasswordFrame, "Password change unsuccessful", "Update Failure", JOptionPane.INFORMATION_MESSAGE);
					}
								
				}catch(SQLException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Forget Password Failed");	
				}
			}else {
					JOptionPane.showMessageDialog(forgetPasswordFrame, "Password and Confirm Password does not match", "Wrong Information", JOptionPane.WARNING_MESSAGE);
			}
		}
	}	
}

class BackgroundWork {
	
	boolean duplicateID(String id) {
		
		String checkIDQuery = "SELECT * FROM login where id = ?";
		
		try(Connection con = ReadWrite.connect();
			PreparedStatement checkDuplicity = con.prepareStatement(checkIDQuery)) {

			checkDuplicity.setString(1, id);
			ResultSet checkID = checkDuplicity.executeQuery();
			return checkID.next();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}


