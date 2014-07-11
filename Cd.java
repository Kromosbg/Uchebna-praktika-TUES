package stringvars;

import java.io.File;

public class Cd implements Command {

	private String newFolder = "";
	

	public Cd(String folder) {
		newFolder = folder;
	}

	public String getNewFolder() {
		return newFolder;
	}

	public void setNewFolder(String newFolder) {
		this.newFolder = newFolder;
	}

	public File executeCommand(File currentFolder) {

		if ("..".equals(newFolder)) {
			File resultFolder = new File(currentFolder.getParent());
			return resultFolder;
		} else {
			File resultFolder = new File(currentFolder.getAbsolutePath() + "\\"
					+ newFolder);
			if (resultFolder.exists()) {
				return resultFolder;
			} else {
				System.out.println("The system cannot find the path specified");
			}
			return currentFolder;
		}
	}
}
