package stringvars;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.xentio.terminal.protocol.Protocol;

import stringvars.commands.Command;

public class Newterminal {

	public void run(String[] args) {

		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(5000);
			String commandName = "";
			while (!commandName.equals("shutdown")) {

				Socket clientSocket = serverSocket.accept();

				PrintStream outputStream = new PrintStream(
						clientSocket.getOutputStream()); // System.out;
				InputStream inputStream = clientSocket.getInputStream();// System.in;

				Scanner userInput = new Scanner(inputStream);
				String workingDir = System.getProperty("user.dir");
				File currentFolder = new File(workingDir);
				
				while (!commandName.equals("shutdown")
						&& !commandName.equals("exit")) {

					
					CommandManager commandManager = new CommandManager();

					outputStream
							.println(currentFolder.getAbsolutePath() + "> ");
					outputStream.println(Protocol.END_OF_COMMAND_STRING);

					commandName = userInput.next();
					System.out.println("command: " + commandName);

					String argument = userInput.nextLine().trim();
					System.out.println("argument: " + argument);
					try {
						Command command = commandManager.getCommand(
								commandName, argument);

						ComResponse response = command
								.executeCommand(currentFolder);
						currentFolder = response.getCurrentfolder();
						outputStream.println(response.getText());
					} catch (BadCommandException e) {
						outputStream.println(commandName);
						outputStream
								.println("  is not recognized as an internal or external command,operable program or batch file");
						outputStream.println(currentFolder.getAbsolutePath()
								+ "> ");
					}
				}

			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
