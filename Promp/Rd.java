package stringvars.commands;

import java.io.File;

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
		
	public File executeCommand(File currentFolder) {
	
		 File newDir = new File(currentFolder.getAbsolutePath() + "\\"
					+ newFolder);
		 
		  if (newDir.exists()) {
			  try {		

		 newDir.delete();
		 System.out.println("File deleted successfully");
		}  catch(SecurityException se){
			 System.out.println("No such file");
			
			}
		}
		return  currentFolder;
	 }
}

