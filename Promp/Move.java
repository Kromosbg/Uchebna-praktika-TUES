package stringvars.commands;

import java.io.File;

import stringvars.ComResponse;

public class Move extends CommandWithArgument implements Command {

	public Move(String newString) {
		super(newString);
	}

	public ComResponse executeCommand(File currentFolder) {
		Copy copy=new Copy(getArgument());
		copy.executeCommand(currentFolder);
		String firstArgument=getArgument().split(" ")[0]; 
		Delete delete=new Delete(firstArgument);
		return delete.executeCommand(currentFolder);
	}

}
