package stringvars.commands;

import java.io.File;
import java.text.SimpleDateFormat;

import stringvars.ComResponse;

public class Dir  implements Command{



	public ComResponse executeCommand(File currentFolder) {
		File[] paths = currentFolder.listFiles();	
		StringBuilder text = new StringBuilder("  ");
		
		for (File path : paths) { 
			
			//System.out.println(path);

			
			SimpleDateFormat sdf = new SimpleDateFormat("  dd/MM/yyyy  HH:mm:ss  ");
			
			text.append("\n");
			text.append(path);
		
		


			text.append(sdf.format(path.lastModified()));
			//System.out.println(path);
		}
		
		ComResponse command= new ComResponse(currentFolder, text);
		return command;

	}
}
