package stringvars.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



import stringvars.ComResponse;

public class Copy extends CommandWithArgument implements Command {

	

	public Copy(String newString) {
		super(newString);
	}





	public ComResponse executeCommand(File currentFolder) {
		
			StringBuilder text = new StringBuilder();
			ComResponse current= new ComResponse(currentFolder, text );
			text.append("Arguments: \n"+getArgument());
			String[] argumentsArray=getArgument().trim().split(" ");
			String from=argumentsArray[0];
			String to= argumentsArray[1];
		   
			try {
				Copye(from,to);
			} catch (IOException e) {
				e.printStackTrace();
			}
			  return current;
	}


	


	 public void Copye(String fromFileName, String toFileName)
		      throws IOException {
		    File fromFile = new File(fromFileName);
		    File toFile = new File(toFileName);



		    if (toFile.isDirectory())
		      toFile = new File(toFile, fromFile.getName());

		   

		    FileInputStream from = null;
		    FileOutputStream to = null;
		    try {
		      from = new FileInputStream(fromFile);
		      to = new FileOutputStream(toFile);
		      byte[] buffer = new byte[4096];
		      int bytesRead;

		      while ((bytesRead = from.read(buffer)) != -1)
		        to.write(buffer, 0, bytesRead); // write
		    } finally {
		      if (from != null)
		        try {
		          from.close();
		        } catch (IOException e) {
		          ;
		        }
		      if (to != null)
		        try {
		          to.close();
		        } catch (IOException e) {
		          ;
		        }
		    }
		  }
}
