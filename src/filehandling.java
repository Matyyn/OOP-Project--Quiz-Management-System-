
import java.io.EOFException;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class filehandling {

  public static ArrayList<Signupform> signup = new ArrayList<Signupform>();

  // method for reading data
  
  public static void readData()
  {
	  signup = new ArrayList<Signupform>();
	try 
	{ 
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Accounts.txt"));
		while (true)
		{ 
			Signupform a = (Signupform) objectInputStream.readObject(); 
			signup.add(a);
		} 
	} 
    
    catch (ClassNotFoundException e)
    {
      e.getStackTrace();
    }
    catch(IOException e)
    {
      
    }
  }
  
  // method for writing data
  
  public static void writeData()
  {
    try
    {
      FileOutputStream file = new FileOutputStream("Accounts.txt");
      ObjectOutputStream oos = new ObjectOutputStream(file);
      for(int i = 0; i<signup.size(); i++)
      {
        oos.writeObject(signup.get(i));
      }
      oos.close();
    }
    catch(IOException e)
    {
      System.out.println("Error while saving the data");
      e.printStackTrace();
    }
    
    System.out.println("Data has been saved");
  }
  
  // method for searching data
  
  public static boolean Search(String Name,String password) {
	    for(int i = 0; i< signup.size(); i++)
	    {
	      if(Name.equals(signup.get(i).name) && password.equals(signup.get(i).password1))
	      {
	        return true;
	      }
	    }
	    return false;
	  }
  
  // method for checking data if it exists
  
  public static boolean isExist(String Name) {
	    for(int i = 0; i< signup.size(); i++)
	    {
	      if(Name.equals(signup.get(i).name) )
	      {
	        return true;
	      }
	    }
	    return false;
	  }
  
  // method for getting the details of the specific data
  
  public static Signupform getdetails(String Name) {
	    for(int i = 0; i< signup.size(); i++)
	    {
	      if(Name.equals(signup.get(i).name) )
	      {
	        return signup.get(i);
	      }
	    }
	    return null;
	  }
    
  }
