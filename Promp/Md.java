package stringvars.commands;

import java.io.File;

import stringvars.ComResponse;
import stringvars.Command;

public class Rd implements Command{
	public String newFolder = "";
	
	public Rd(String argument) {
		newFolder = argument;
	}

	public String getNewFolder() {
		return newFolder;
	}

	public void setNewFolder(String newFolder) {
		this.newFolder = newFolder;
	}
		
	public ComResponse executeCommand(File currentFolder) {
	
		 File newDir = new File(currentFolder.getAbsolutePath() + "\\"
					+ newFolder);
		  	
		  if (newDir.exists()) {
				

		 newDir.delete();
		 StringBuilder text = new StringBuilder("");
		 text.append("File deleted successfully");
		  }   else {
	
			 StringBuilder text = new StringBuilder("");
			 text.append("No such file"); 
		  
		}
		StringBuilder text = new StringBuilder();
		ComResponse sb= new ComResponse(currentFolder , text);
		return sb;
		  
}
}
