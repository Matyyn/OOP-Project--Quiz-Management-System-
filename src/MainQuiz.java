

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class MainQuiz extends JFrame {

	// GUI items
	
	private JPanel contentPane;
	public static String choice1;
	public static String choice2;
	public static String choice3;
	public static String choice4;
	public static String correctChoice;
	public static String qs;
	public static int qsnumber;
	public static int count=2;
	public static int score=0;
	
	/**
	 * Launch the application.
	 */
	
	int counter;
	
	String textEquals = "";
	
	static JRadioButton  rdbtnNewRadioButton;
	static JRadioButton  rdbtnNewRadioButton_1;
	static JRadioButton  rdbtnNewRadioButton_2;
	static JRadioButton  rdbtnNewRadioButton_3;
	static JLabel lblNewLabel;
	static JLabel lblNewLabel_1;
/**
	 * Create the frame.
	 */
	 public MainQuiz(){
	setTitle("Quiz");
		
		this.setBounds(100, 100, 669, 474);
		this.setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(null);
		getContentPane().add(contentPane);
		lblNewLabel = new JLabel("Question No #");
		lblNewLabel.setBounds(29, 49, 102, 29);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Question");
		lblNewLabel_1.setBounds(29, 107, 606, 23);
		contentPane.add(lblNewLabel_1);
		
		// radio button 1
		
		rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					rdbtnNewRadioButton_1.setSelected(false);
					rdbtnNewRadioButton_2.setSelected(false);
					rdbtnNewRadioButton_3.setSelected(false);
					textEquals = rdbtnNewRadioButton.getText();
				}
			}
		});
		rdbtnNewRadioButton.setBounds(29, 191, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setText(choice1);
		
		// radio button 2
		
		rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
					rdbtnNewRadioButton_2.setSelected(false);
					rdbtnNewRadioButton_3.setSelected(false);
					textEquals = rdbtnNewRadioButton_1.getText();
				}
			
			}
		});
		rdbtnNewRadioButton_1.setBounds(29, 271, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setText(choice2);
		
		// radio button 3
		
		
		rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_2.isSelected()) {
					rdbtnNewRadioButton_1.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
					rdbtnNewRadioButton_3.setSelected(false);
					
					textEquals = rdbtnNewRadioButton_2.getText();
				}
			}
		});
		rdbtnNewRadioButton_2.setBounds(322, 191, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setText(choice3);
		
		
		// radio button 4
		
		rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_3.isSelected()) {
					rdbtnNewRadioButton_1.setSelected(false);
					rdbtnNewRadioButton_2.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
					textEquals = rdbtnNewRadioButton_3.getText();
				}
			}
		});
		rdbtnNewRadioButton_3.setBounds(322, 271, 109, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setText(choice4);
		
		// button to quit
		
		JButton btn1 = new JButton("Quit");

		btn1.setBounds(97, 380, 89, 23);
		contentPane.add(btn1);
		
		// next button
		
		JButton btn2 = new JButton("Next");
		btn2.setBounds(312, 380, 89, 23);
		contentPane.add(btn2);
		
		//invoking method to read first inputs from the text files
		
		setqsnumber(1);
		getqs(1);
		firstlinechoice1(1);
		firstlinechoice2(1);
		firstlinechoice3(1);
		firstlinechoice4(1);
		correctChoiceLoader(1);
		
		
		  btn1.addMouseListener(new MouseAdapter() {
			   @Override
			   public void mouseClicked(MouseEvent e) {
				   showMessageDialog(null, "You quitted the Quiz your Score is: "+ score + " out of 10", "Quiz", ERROR_MESSAGE);
				   System.exit(0);
			   }
			  });
		  
		  //Next button functionality
		  
		  btn2.addMouseListener(new MouseAdapter() {
			   @Override
			   public void mouseClicked(MouseEvent e) {
				 
				   if(textEquals.equals(correctChoice))
				   {
					   score++;
				   }
				   if(count<=10 && (rdbtnNewRadioButton.isSelected() ||rdbtnNewRadioButton_1.isSelected() || rdbtnNewRadioButton_2.isSelected() || rdbtnNewRadioButton_3.isSelected())) {
						try {
							setqsnumber(count);
							firstlinechoice1(count);
							firstlinechoice2(count);
							firstlinechoice3(count);
							firstlinechoice4(count);
							correctChoiceLoader(count);
							getqs(count);
							count++;
						} catch (Exception e1) {
							e1.printStackTrace();
						}
				   }
				   
				   else if(count > 10) {try {
					   WriteObjectToFile("Score.txt",score,true);
					   showMessageDialog(null, "Quiz Ended your Score is: "+ score + " out of 10", "Quiz", ERROR_MESSAGE);
						System.exit(0);}
				   catch (Exception e1) {
						e1.printStackTrace();
					}
				   }
				   
			   }
			  });
			  }
	
	 // methods to read data from the text file and assign them to the radio buttons
	 
	public static void firstlinechoice1(int number) {
			String text = "";
		    int lineNumber;
		    try {
		      FileReader readfile = new FileReader("Choice1.txt");
		      BufferedReader readbuffer = new BufferedReader(readfile);
		      for (lineNumber = 1; lineNumber <= 10; lineNumber++) {
		        if (lineNumber == number) {
		          text = readbuffer.readLine();
		        } else
		          readbuffer.readLine();
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		    rdbtnNewRadioButton.setText(text);
		   
	}
	
	public static void firstlinechoice2(int number) {
		String text = "";
	    int lineNumber;
	    try {
	      FileReader readfile = new FileReader("Choice2.txt");
	      BufferedReader readbuffer = new BufferedReader(readfile);
	      for (lineNumber = 1; lineNumber <= 10; lineNumber++) {
	        if (lineNumber == number) {
	          text = readbuffer.readLine();
	        } else
	          readbuffer.readLine();
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    rdbtnNewRadioButton_1.setText(text);
}
	
	public static void firstlinechoice3(int number) {
		String text = "";
	    int lineNumber;
	    try {
	      FileReader readfile = new FileReader("Choice3.txt");
	      BufferedReader readbuffer = new BufferedReader(readfile);
	      for (lineNumber = 1; lineNumber <= 10; lineNumber++) {
	        if (lineNumber == number) {
	          text = readbuffer.readLine();
	        } else
	          readbuffer.readLine();
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    rdbtnNewRadioButton_2.setText(text);
}
	
	public static void correctChoiceLoader(int number) {
		String text = "";
	    int lineNumber;
	    try {
	      FileReader readfile = new FileReader("Correctones.txt");
	      BufferedReader readbuffer = new BufferedReader(readfile);
	      for (lineNumber = 1; lineNumber <= 10; lineNumber++) {
	        if (lineNumber == number) {
	          text = readbuffer.readLine();
	        } else
	          readbuffer.readLine();
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    correctChoice = text;
}
	
	public static void firstlinechoice4(int number) {
		String text = "";
	    int lineNumber;
	    try {
	      FileReader readfile = new FileReader("Choice4.txt");
	      BufferedReader readbuffer = new BufferedReader(readfile);
	      for (lineNumber = 1; lineNumber <= 10; lineNumber++) {
	        if (lineNumber == number) {
	          text = readbuffer.readLine();
	        } else
	          readbuffer.readLine();
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    rdbtnNewRadioButton_3.setText(text);
}
	
	//method to display the qs
	
	public static void getqs(int number) {
		String text = "";
	    int lineNumber;
	    try {
	      FileReader readfile = new FileReader("Questions.txt");
	      BufferedReader readbuffer = new BufferedReader(readfile);
	      for (lineNumber = 1; lineNumber <= 10; lineNumber++) {
	        if (lineNumber == number) {
	          text = readbuffer.readLine();
	        } else
	          readbuffer.readLine();
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    lblNewLabel_1.setText(text);
	}
	
	public static void setqsnumber(int number) {
		lblNewLabel.setText("Question no# " + number);
	}
	
	// Method to write the data in the text file
	
	public void WriteObjectToFile(String filename,int choice,boolean append) throws IOException {  
		
		File f1 = new File(filename);
		
		FileWriter fw =new FileWriter(f1,append);
		
		PrintWriter pw = new PrintWriter(fw);
		pw.println(choice);
		pw.close();
	}

}
