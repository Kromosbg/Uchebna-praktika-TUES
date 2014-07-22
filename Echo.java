package stringvars.commands;

import java.io.File;

import stringvars.Command;


public class Echo implements Command{
	
	public String message;
	

	public Echo(String echo) {
		echo=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public File executeCommand(File currentFolder) {
		System.out.println(message);	
		return currentFolder;
	}

}
