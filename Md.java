package stringvars.commands;

import java.io.File;

import stringvars.Command;

public class Md implements Command {

	public String newFolder = "";

	public Md(String folder) {
		newFolder = folder;
	}

	public String getNewFolder() {
		return newFolder;
	}

	public void setNewFolder(String newFolder) {
		this.newFolder = newFolder;
	}

	public File executeCommand(File currentFolder) {
		File newDir = new File(currentFolder.getAbsolutePath() + "\\"
				+ newFolder);
		if (!newDir.exists()) {

			newDir.mkdir();

			System.out.println("DIR created");
		} else {
			System.out.println("Dir exist");
		}

		return currentFolder;
	}
}
