package stringvars;

import java.io.File;

public class Rd {
	String newFolder = "";
	
	 public void rd() {
		 File newDir = new File(newFolder);
		 
		  if (newDir.exists()) {
			  try {		

		 newDir.delete();
		 System.out.println("File deleted successfully");
		}  catch(SecurityException se){
			 System.out.println("No such file");
			
			}
		}
	 }
}
