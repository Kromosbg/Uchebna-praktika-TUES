package stringvars;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.xentio.terminal.protocol.Protocol;

import stringvars.commands.Command;

public class Newterminal {

	public void run(String[] args) {
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(5000);

			Socket clientSocket = serverSocket.accept();
			
			
			PrintStream outputStream =  new PrintStream(clientSocket.getOutputStream()); //System.out;
			InputStream inputStream = clientSocket.getInputStream();//System.in;

			Scanner userInput = new Scanner(inputStream);

			String commandName = "";
			String workingDir = System.getProperty("user.dir");
			File currentFolder = new File(workingDir);
			CommandManager commandManager = new CommandManager();

			while (!commandName.equals("shutdown")) {
				
				outputStream.println(currentFolder.getAbsolutePath() + "> ");
				outputStream.println(Protocol.END_OF_COMMAND_STRING);
		
				commandName = userInput.next();
		
				
				String argument = userInput.nextLine().trim();
				try {
					Command command = commandManager.getCommand(commandName,argument);

					ComResponse response = command.executeCommand(currentFolder);
					currentFolder = response.getCurrentfolder();
					outputStream.println(response.getText());
				} catch (BadCommandException e) {
					outputStream.println(commandName);
					outputStream.print("  is not recognized as an internal or external command,operable program or batch file");
					outputStream.println(currentFolder.getAbsolutePath() + "> ");
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
