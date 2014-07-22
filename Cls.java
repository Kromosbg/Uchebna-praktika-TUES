package stringvars.commands;

import java.io.File;

import stringvars.Command;

public class Cls implements Command{

	public File executeCommand(File currentFolder) {
		for( int i = 0; i < 25; i++ ) {
		    System.out.println("");
		}
		return currentFolder;
	}
}
