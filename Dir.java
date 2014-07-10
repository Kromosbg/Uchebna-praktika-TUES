package stringvars;

import java.io.File;
import java.text.SimpleDateFormat;

public class Dir {

	File folderToList = null;
	long l;

	public void runDir() {

		File[] paths = folderToList.listFiles();
		// System.out.println("Current working directory : "
		// + folderToList.getAbsolutePath());
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
	}
}
