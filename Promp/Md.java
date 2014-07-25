package stringvars.commands;

import java.io.File;

import stringvars.ComResponse;
import stringvars.Command;

public class Md implements Command {

	public String newFolder = "";

	public Md(String folder) {
		newFolder = folder;
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
		if (!newDir.exists()) {

			newDir.mkdir();
			StringBuilder text = new StringBuilder("");
			text.append("Dir created");
		} else {
			StringBuilder text = new StringBuilder("");
			text.append("Dir exists");
		}
		
		StringBuilder text = new StringBuilder("");
		ComResponse sb= new ComResponse(currentFolder , text);
		return sb;

	
	}
}
