package stringvars.commands;

//import java.io.File;
import java.io.File;
//import java.util.Scanner;

import stringvars.ComResponse;
import stringvars.Command;


public class Echo implements Command{
	
//	Scanner userInput = new Scanner(System.in);
	public String message = "";
	

	public Echo(String echo) {
		message=echo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ComResponse executeCommand(File currentFolder) {
		StringBuilder text = new StringBuilder(message);
		ComResponse result= new ComResponse(currentFolder,text);
		return result;	
		
	}
}
