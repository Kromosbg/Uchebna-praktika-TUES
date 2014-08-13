package stringvars.commands;

import java.io.File;

import stringvars.ComResponse;


public class Echo extends CommandWithArgument implements Command{

	


	public Echo(String message) {
		super(message);
	}







	public ComResponse executeCommand(File currentFolder) {
		
		StringBuilder text = new StringBuilder();
		ComResponse result= new ComResponse(currentFolder,text);
		
		text.append(getArgument());
		
		return result;	
		
	}
}
