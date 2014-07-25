package stringvars.commands;

import java.io.File;

import stringvars.ComResponse;
import stringvars.Command;

public class Cd implements Command {

	private String newFolder = "";
	

	public Cd(String folder) {
		newFolder = folder;
	}

	public String getNewFolder() {
		return newFolder;
	}

	public void setNewFolder(String newFolder) {
		this.newFolder = newFolder;
	}

	public ComResponse executeCommand(File currentFolder) {
		
		
		if ("..".equals(newFolder) ) {
			File resultFolder = new File(currentFolder.getParent());
			StringBuilder text = new StringBuilder();
			currentFolder = resultFolder;
			ComResponse current= new ComResponse(currentFolder, text );
			return current;
		} else { 
			File resultFolder = new File(currentFolder.getAbsolutePath() + "\\"	+ newFolder);
			if (resultFolder.exists()) {
				currentFolder =resultFolder;
				StringBuilder text = new StringBuilder();
			//	text.append("do u see this");
				ComResponse result= new ComResponse(resultFolder, text);
				return result;
			} else {
				StringBuilder text = new StringBuilder();
				text.append("The system cannot find the path specified");
				File result1 = new File(currentFolder.getAbsolutePath());
				currentFolder = result1;
				ComResponse resultat= new ComResponse(currentFolder, text);
				
				return resultat;
			}			
		}
	}
}
