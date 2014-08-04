package stringvars.commands;

import java.io.File;

import stringvars.ComResponse;
import stringvars.Command;
import stringvars.CommandCompresor;

public class Md extends CommandCompresor implements Command {

	public String string = "";

	public Md(String argument) {
		string = argument;
	}

	public ComResponse executeCommand(File currentFolder) {
		File newDir = new File(currentFolder.getAbsolutePath() + "\\"
				+ string);
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

