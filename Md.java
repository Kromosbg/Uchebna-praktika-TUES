package stringvars;

import java.io.File;

public class Md {
	String newFolder = "";

	public void md() {
		  File newDir = new File(newFolder);
		  
		  if (!newDir.exists()) {
		    boolean result = false;

		    try{
		        newDir.mkdir();
		        result = true;
		     } catch(SecurityException se){
		       System.out.println("Dir exist");
		     }        
		     if(result) {    
		       System.out.println("DIR created");  
		     }
		     else {
		    	System.out.println("Dir exist");
		     }
		  }
	}	
}

