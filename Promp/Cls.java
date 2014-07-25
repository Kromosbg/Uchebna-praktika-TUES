package stringvars.commands;

import java.io.File;

import stringvars.ComResponse;
import stringvars.Command;

public class Cls implements Command{
	
	
	public ComResponse executeCommand(File resultFolder) {
		StringBuilder text = new StringBuilder("");
		for( int i = 0; i < 100; i++ ) {
			text.append("\n");
		}
	
	
		ComResponse sb= new ComResponse(resultFolder, text);
		return sb;
		}
	}
