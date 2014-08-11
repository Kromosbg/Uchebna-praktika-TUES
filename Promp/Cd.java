package stringvars.commands;

import java.io.File;

import stringvars.ComResponse;

public class Cd extends CommandWithArgument implements Command {



	public Cd(String newString) {
		super(newString);
	}

	public ComResponse executeCommand(File currentFolder) {
		StringBuilder text = new StringBuilder();
		
		if ("..".equals(getArgument()) ) {
			File resultFolder = new File(currentFolder.getParent());
			currentFolder = resultFolder;
			ComResponse current= new ComResponse(currentFolder, text );
			return current;
		} else { 
			File resultFolder = new File(currentFolder.getAbsolutePath() + "\\"	+ getArgument());
			if (resultFolder.exists()) {
				currentFolder =resultFolder;
				ComResponse result= new ComResponse(resultFolder, text);
				return result;
			} else {
				text.append("The system cannot find the path specified");
				File result1 = new File(currentFolder.getAbsolutePath());
				currentFolder = result1;
				ComResponse resultat= new ComResponse(currentFolder, text);
				
				return resultat;
			}			
		}
	}
}
