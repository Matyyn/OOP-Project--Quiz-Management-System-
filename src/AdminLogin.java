

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminLogin extends JFrame {
 
	//GUI items
	
	private JPanel contentPane;
	private JTextField searchbox;
	private JTextField email_search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AdminLogin frame = new AdminLogin();	
				    frame.setVisible(true);
					
				    //Reading data
				    
				    filehandling.readData();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setTitle("Admin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		searchbox = new JTextField();
		searchbox.setBounds(22, 113, 118, 33);
		contentPane.add(searchbox);
		searchbox.setColumns(10);
		
		email_search = new JTextField();
		email_search.setColumns(10);
		email_search.setBounds(325, 113, 118, 33);
		contentPane.add(email_search);
		
		// Search by Name button
		
		JButton search = new JButton("Search");
		search.setBounds(38, 188, 89, 23);
		contentPane.add(search);
		// Search by Name:
		search.addMouseListener(new MouseAdapter() {
			   @Override
			   public void mouseClicked(MouseEvent e) {
				   if(filehandling.isExist(searchbox.getText())){
					   Signupform data = filehandling.getdetails(searchbox.getText());
					   showMessageDialog(null, "Data is displayed on Console", "Data Status", ERROR_MESSAGE);
					   System.out.println("     Search by Name: ");
					   System.out.println("Name: \t"+"Email: \t"+"Password: \t"  );
					   System.out.print(data.name);
					   System.out.print("\t"+data.mail);
					   System.out.print("\t"+data.password1);
				   }
				   else {
					   JFrame f  = new JFrame();
					   JOptionPane.showMessageDialog(f, "user doesnot exist");
				   }
			   }
			  });
		
		
		
		JButton search_1 = new JButton("Search");
		search_1.setBounds(337, 188, 89, 23);
		contentPane.add(search_1);
		
		// Search by Email button:
		
		search_1.addMouseListener(new MouseAdapter() {
			   @Override
			   public void mouseClicked(MouseEvent e) {
				   if(filehandling.isExist(email_search.getText())){
					 
					   Signupform data = filehandling.getdetails(email_search.getText());
					   showMessageDialog(null, "Data is displayed on Console", "Data Status", ERROR_MESSAGE);
					   System.out.println("    Search by Email: ");
					   System.out.println("Name: \t"+"Email: \t"+"Password: \t"  );
					   System.out.print(data.name);
					   System.out.print("\t"+data.mail);
					   System.out.print("\t"+data.password1);
					   System.out.println();
				   
				   }
				   else {
					   JFrame f  = new JFrame();
					   JOptionPane.showMessageDialog(f, "user doesnot exist");
				   }
			   }
			  });
		//Quit button
		
		JButton Quit = new JButton("Quit");
		Quit.setBounds(175, 239, 89, 23);
		contentPane.add(Quit);
		
		Quit.addMouseListener(new MouseAdapter() {
			   @Override
			   public void mouseClicked(MouseEvent e) {
				   System.exit(0);
			   }
			  });
		JLabel lblNewLabel = new JLabel("Search by Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(22, 70, 118, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search by Email: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(325, 70, 118, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblWelcomeToAdmin = new JLabel("Welcome to Admin Panel");
		lblWelcomeToAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWelcomeToAdmin.setBounds(143, 11, 178, 33);
		contentPane.add(lblWelcomeToAdmin);
	}
}
