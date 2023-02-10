import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 

public class Signupform extends JFrame implements Serializable {
	// Used for composition
	AdminName l;
	Signupdata_2 k;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 // GUI Items
	 private JPanel contentPane;
	 private JTextField username;
	 private JTextField email;
	 private JPasswordField password;
	 private JPasswordField password_1;
	 private JButton btn1;

	 // Variables
	 public String name;
	 public String mail;
	 public String passwordkey;
	 public String password1;
	 
	 @Override
	public String toString() {
		return "Signupform [name=" + name + ", mail=" + mail + ", passwordkey=" + passwordkey + "]";
	}
	/* Launch the application.
	  */
	 public static void main(String[] args) {
	  EventQueue.invokeLater(new Runnable() {
	   public void run() {
	    try {
	     Signupform frame = new Signupform();
	     // to read the data
	     filehandling.readData();
	     frame.setUndecorated(true); 
	     frame.setVisible(true);
	    
	    } catch (Exception e) {
	     e.printStackTrace();
	    }
	   }
	  });
	 }
	 /* Create the frame.
	  */
	 public Signupform() {
		 // both used for composition
	 	setTitle("Sign Up");
		 this.l = new AdminName();
		 this.k = new Signupdata_2();
		 l.setName(" Mateen ");
		  
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
	  lblNewLabel_4.setIcon(new ImageIcon(Signupform.class.getResource("/images/brain.PNG")));
	  panel.add(lblNewLabel_4);
	  JLabel lblNewLabel_5 = new JLabel("Online Quiz  System");
	  lblNewLabel_5.setVerticalAlignment(SwingConstants.BOTTOM);
	  panel.add(lblNewLabel_5);
	  
	  JLabel Admin = new JLabel("Online Quiz  System");
	  Admin.setVerticalAlignment(SwingConstants.BOTTOM);
	  panel.add(Admin);
	  // used composition for writing the name
	  String k = l.getName();
	  Admin.setText("Made by " + k );
	  
	  username = new JTextField();
	  username.setBounds(388, 60, 282, 34);
	  contentPane.add(username);
	  username.setColumns(10);
	  
	  // username label
	  JLabel lblNewLabel_7 = new JLabel("Username:");
	  lblNewLabel_7.setBounds(388, 21, 58, 14);
	  contentPane.add(lblNewLabel_7);
	  
	  
	  // email label
	  
	  JLabel lblNewLabel_1 = new JLabel("Email:");
	  lblNewLabel_1.setBounds(388, 105, 109, 27);
	  contentPane.add(lblNewLabel_1);
	  
	  email = new JTextField();
	  email.setColumns(10);
	  email.setBounds(388, 143, 282, 34);
	  contentPane.add(email);
	  
	  // password label
	  
	  JLabel lblNewLabel_2 = new JLabel("Password: ");
	  lblNewLabel_2.setBounds(388, 204, 95, 27);
	  contentPane.add(lblNewLabel_2);
	  
	  password = new JPasswordField();
	  password.setBounds(388, 242, 282, 34);
	  contentPane.add(password);
	  
	  // retype password label
	  
	  JLabel lblNewLabel_3 = new JLabel("Retype Password:");
	  
	  password_1 = new JPasswordField();
	  password_1.setBounds(388, 329, 282, 34);
	  contentPane.add(password_1);
	  
	  // Signup button
	  
	  btn1 = new JButton("Sign Up");
	  btn1.addMouseListener(new MouseAdapter() {
		   @Override
		   public void mouseClicked(MouseEvent e) {
			   run();
			  
			  dispose();
			   Login p = new Login();
			   p.setVisible(true);
		   }
		  });
	 
	  
	  btn1.setBounds(496, 398, 89, 23);
	  contentPane.add(btn1);
	  
	  
	  // retype password label
	  
	  JLabel lblNewLabel_2_1 = new JLabel("Retype Password: ");
	  lblNewLabel_2_1.setBounds(388, 291, 95, 27);
	  contentPane.add(lblNewLabel_2_1);

	 }
	 
	
	public Signupform(String name, String mail, String password1) throws HeadlessException {
		super();
		this.name = name;
		this.mail = mail;
		this.password1 = password1;
		
	}
	
	// method used for getting data from text fields and saving them
	
	public void run() {
		char[] pass= password.getPassword();
	 	passwordkey= new String(pass);
	 	char[] pass1= password_1.getPassword();
	 	password1=new String(pass1);
	 	k.setName(username.getText());
	 	k.setEmail(email.getText());
	 	k.setPassword(passwordkey);
	 	name= k.getName();
	 	mail = k.getEmail();
	 	Signupform s = new Signupform(name, mail, password1);
	 	filehandling.signup.add(s );
	 	filehandling.writeData(); 	
	}
}
	