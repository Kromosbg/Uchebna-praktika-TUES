package stringvars.commands;

import java.io.File;

import stringvars.ComResponse;
import stringvars.Command;

public class Move implements Command {
	
	private String argument;
	public Move(String newArgument){
		argument = newArgument;
		
	}
	@Override
	public ComResponse executeCommand(File currentFolder) {
		Copy copy=new Copy(argument);
		copy.executeCommand(currentFolder);
		String firstArgument=argument.split(" ")[0]; 
		Delete delete=new Delete(firstArgument);
		return delete.executeCommand(currentFolder);
	}

}
