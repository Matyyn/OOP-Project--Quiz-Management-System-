
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.*;
import static javax.swing.JOptionPane.*;

public class Login extends JFrame implements Serializable{

 // GUI items
 private JPanel contentPane;
 private JTextField username;
 private JPasswordField password;
 private JButton SignUp;
 
 // variables
 private String name;
 private String passwordkey;
 
 public Login() {
	 
  setTitle("Login");
  // Reading the data from the files
  filehandling.readData();
  
  
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 791, 487);
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  JPanel panel = new JPanel();
  panel.setBackground(Color.CYAN);
  panel.setBounds(5, 5, 341, 443);
  contentPane.add(panel);
  JLabel lblNewLabel_4 = new JLabel("");
  lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
  
  // putting image
  lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/images/brain.PNG")));
  panel.add(lblNewLabel_4);
  JLabel lblNewLabel_5 = new JLabel("Online Quiz  System");
  lblNewLabel_5.setVerticalAlignment(SwingConstants.BOTTOM);
  panel.add(lblNewLabel_5);
  username = new JTextField();
  username.setBounds(388, 118, 282, 34);
  contentPane.add(username);
  username.setColumns(10);
  
  // username label
  
  JLabel lblNewLabel = new JLabel("UserName:");
  lblNewLabel.setBounds(388, 60, 109, 22);
  contentPane.add(lblNewLabel);
  
  // password label
  JLabel lblNewLabel_2 = new JLabel("Password: ");
  lblNewLabel_2.setBounds(388, 190, 95, 27);
  contentPane.add(lblNewLabel_2);
  password = new JPasswordField();
  password.setBounds(388, 242, 282, 34);
  contentPane.add(password);
  
  // Signup Button
  
  SignUp = new JButton("Sign Up");
  SignUp.addMouseListener(new MouseAdapter() {
	   @Override
	   public void mouseClicked(MouseEvent e) {
		   dispose();
		   Signupform p = new Signupform();
		   p.setVisible(true);
	   }
	  });
  SignUp.setBounds(476, 385, 89, 23);
  contentPane.add(SignUp);
  
  // create new Account label
  
  JLabel lblNewLabel_1_1 = new JLabel("              Create a new Account  ");
  lblNewLabel_1_1.setBounds(424, 334, 196, 40);
  contentPane.add(lblNewLabel_1_1);
  
  // Login button
  
  JButton login = new JButton("Log In");
  login.setBounds(476, 300, 89, 23);
  contentPane.add(login);
  login.addMouseListener(new MouseAdapter() {
	   @Override
	   public void mouseClicked(MouseEvent e) {
		   login_check();
		   dispose();
	   }
	  });
 }
  
 // Search name method

	public boolean searchname() {
		char[] pass1= password.getPassword();
	 	passwordkey= "";
	 	for(int i = 0 ; i < pass1.length ; i++) {
	 		passwordkey += pass1[i];
	 	}
		name=username.getText();
		boolean b = filehandling.Search(name, passwordkey);
		return b;
	}
	
// Admin login check method
	
	public boolean admin() {
		char[] pass1= password.getPassword();
	 	passwordkey= new String(pass1);
		name=username.getText();
		if(name.equals("admin")&& passwordkey.equals("admin"))
		{
			
			 return true;
		}
		else {
			return false;
		}
	}
	
	
// method to check and move to next panel
	
 public void login_check() {
	 if(searchname()) {
		dispose();
		 MainQuiz  p = new MainQuiz();
		p.setVisible(true);
		
	 }
	 else if(admin()) { 
		 showMessageDialog(null, "Admin Login", "login", ERROR_MESSAGE);
		 dispose();
		 AdminLogin k = new AdminLogin();
		 k.setVisible(true);	
		  
	 }
	 else {
		 showMessageDialog(null, "Login doesnot match", "login", ERROR_MESSAGE);
	 }
 }
}