package stringvars.commands;

import java.io.File;

import stringvars.ComResponse;

public interface Command {
	public ComResponse executeCommand(File currentFolder);
}
