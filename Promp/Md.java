package stringvars.commands;

import java.io.File;

import stringvars.ComResponse;

public class Md extends CommandWithArgument implements Command {

public Md(String newString) {
		super(newString);
	}

	/*	public String string = "";

	public Md(String argument) {
		string = argument;
	}
*/
	public ComResponse executeCommand(File currentFolder) {
		File newDir = new File(currentFolder.getAbsolutePath() + "\\"
				+ getArgument());
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
