package stringvars.commands;

import java.io.File;
import java.text.SimpleDateFormat;

import stringvars.Command;

public class Dir implements Command{


	public File executeCommand(File currentFolder) {
		long l;
		File[] paths = currentFolder.listFiles();	
		
		for (File path : paths) {
			System.out.print(path);

			SimpleDateFormat sdf = new SimpleDateFormat("  dd/MM/yyyy HH:mm:ss  ");
			System.out.print(sdf.format(path.lastModified()));

			l = path.length();
			if (path.isDirectory()) {
				System.out.println("This is Folder");
			} else {
				System.out.println("length: " + l + " bytes");

			}
		}
		return currentFolder;
	}
}
