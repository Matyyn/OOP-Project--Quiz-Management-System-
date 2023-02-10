import java.util.*;
import java.io.*;
public class Questions {
	
	public String qs;
	
	public Questions() {
		qs="";
	}
	public Questions(String question) {
		qs= question;
	}
	public String getQs() {
		return qs;
	}
	public void setQs(String qs) {
		this.qs = qs;
	}
	@Override
	public String toString() {
		return "Questions [qs=" + qs + "]";
	}
	public void Question() {
	
		// Class array for the questions
		
		Questions [] array = new Questions[10];
		array[0]= new Questions("What is the capital of Russia? ");
		array[1]= new Questions("What is the formula of Water? ");
		array[2]= new Questions("Which is the farthest Planet? ");
		array[3]= new Questions("Who is the President of Pakistan? ");
		array[4]= new Questions("Who is the Richest Person in the World? ");
		array[5]= new Questions("Who landed on Moon first? ");
		array[6]= new Questions("Where  is Karachi located? ");
		array[7]= new Questions("What is previous capital of Pakistan? ");
		array[8]= new Questions("What is the result of 19999 + 001 / 2 ? ");
		array[9]= new Questions("Which is the richest currency in the World? ");
		
		for(int i=0;i<array.length;i++) {
			String outputtext ="Question: "+array[i].getQs();
			try {
				WriteObjectToFile(outputtext,true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	// method to write data into the text file
	
	public void WriteObjectToFile(String s,boolean append) throws IOException {  
	
	File f1 = new File("Questions.txt");
	
	FileWriter fw =new FileWriter(f1,append);
	
	PrintWriter pw = new PrintWriter(fw);
	pw.println(s);
	pw.close();

}}