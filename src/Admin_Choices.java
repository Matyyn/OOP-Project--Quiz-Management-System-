import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Admin_Choices  {
	
	public Admin_Choices() {
		
		// Object array to add choices for radio button 1
		
		Choice1 [] array1 =new Choice1[10];
		array1 [0] = new Choice1("Moscow"); 
		array1 [1] = new Choice1("H2O"); 
		array1 [2] = new Choice1("Neptune"); 
		array1 [3] = new Choice1("Zardari"); 
		array1 [4] = new Choice1("Zardari"); 
		array1 [5] = new Choice1("Ali Hussain"); 
		array1 [6] = new Choice1("On Earth"); 
		array1 [7] = new Choice1("Karachi"); 
		array1 [8] = new Choice1("No idea"); 
		array1 [9] = new Choice1("Pakistani Rupee"); 
		for(int i=0;i<array1.length;i++) {
			String outputtext =array1[i].getC1();
			try {
				WriteObjectToFile("Choice1.txt",outputtext,true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		
		//Object array to add choices for radio button 2
		
		Choice2 [] array2 =new Choice2[10];
		array2 [0] = new Choice2("Berlin"); 
		array2 [1] = new Choice2("H2"); 
		array2 [2] = new Choice2("Jupiter"); 
		array2 [3] = new Choice2("Imran Khan"); 
		array2 [4] = new Choice2("Elon Musk"); 
		array2 [5] = new Choice2("Neil Armstrong"); 
		array2 [6] = new Choice2("Sindh"); 
		array2 [7] = new Choice2("Islamabad"); 
		array2 [8] = new Choice2("10000"); 
		array2 [9] = new Choice2("Qatari Dinar"); 
		for(int i=0;i<array2.length;i++) {
			String outputtext =array2[i].getC2();
			try {
				WriteObjectToFile("Choice2.txt",outputtext,true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	

		//Object array to add choices for radio button 3
		
		
		Choice3 [] array3 =new Choice3[10];
		array3 [0] = new Choice3("Talagang"); 
		array3 [1] = new Choice3("H"); 
		array3 [2] = new Choice3("Mars"); 
		array3 [3] = new Choice3("Arif Alvi"); 
		array3 [4] = new Choice3("Jeff Bezos"); 
		array3 [5] = new Choice3("No one Landed yet"); 
		array3 [6] = new Choice3("Punjab"); 
		array3 [7] = new Choice3("Quetta"); 
		array3 [8] = new Choice3("20"); 
		array3 [9] = new Choice3("US Dollar"); 
		for(int i=0;i<array3.length;i++) {
			String outputtext = array3[i].getC3();
			try {
				WriteObjectToFile("Choice3.txt",outputtext,true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//Object array to add choices for radio button 4
		
		Choice4 [] array4 =new Choice4[10];
		array4 [0] = new Choice4("Sukkur"); 
		array4 [1] = new Choice4("F"); 
		array4 [2] = new Choice4("Pluto"); 
		array4 [3] = new Choice4("Nawaz Sharif"); 
		array4 [4] = new Choice4("Shahid Khan"); 
		array4 [5] = new Choice4("He is not Born yet"); 
		array4 [6] = new Choice4("Kashmir"); 
		array4 [7] = new Choice4("Peshawar"); 
		array4 [8] = new Choice4("100000"); 
		array4 [9] = new Choice4("UK Pound"); 
		for(int i=0;i<array4.length;i++) {
			String outputtext = array4[i].getC4();
			try {
				WriteObjectToFile("Choice4.txt",outputtext,true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Correctchoices [] array5 =new Correctchoices[10];
		array5 [0] = new Correctchoices("Moscow"); 
		array5 [1] = new Correctchoices("H2O"); 
		array5 [2] = new Correctchoices("Pluto"); 
		array5 [3] = new Correctchoices("Arif Alvi"); 
		array5 [4] = new Correctchoices("Jeff Bezos"); 
		array5 [5] = new Correctchoices("Neil Armstrong"); 
		array5 [6] = new Correctchoices("Sindh"); 
		array5 [7] = new Correctchoices("Karachi"); 
		array5 [8] = new Correctchoices("10000"); 
		array5 [9] = new Correctchoices("Qatari Dinar"); 
		for(int i=0;i<array5.length;i++) {
			String outputtext = array5[i].getCorrect();
			try {
				WriteObjectToFile("Correctones.txt",outputtext,true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// method to write the data in the file
	
	public void WriteObjectToFile(String filename,String choice,boolean append) throws IOException {  
		
		File f1 = new File(filename);
		
		FileWriter fw =new FileWriter(f1,append);
		
		PrintWriter pw = new PrintWriter(fw);
		pw.println(choice);
		pw.close();
	}
}
