package stringvars.commands;

import java.io.File;

import stringvars.ComResponse;

public class Rd extends CommandWithArgument implements Command{

	public Rd(String newString) {
		super(newString);
	}



	public ComResponse executeCommand(File currentFolder) {
			StringBuilder text = new StringBuilder();
			
		 File newDir = new File(currentFolder.getAbsolutePath() + "\\" + toString());
			

		  if (newDir.exists()) {
				
		 newDir.delete();
		 
		 text.append("File deleted successfully");
		  }   else {
	

			 text.append("No such file"); 
		  
		}
		
		ComResponse sb= new ComResponse(currentFolder , text);
		return sb;
		  
}
}
