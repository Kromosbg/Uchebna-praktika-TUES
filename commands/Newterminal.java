package stringvars;

import java.util.Scanner;
import java.io.File;


public class Newterminal{
	                             
		public void executeCommand() throws Exception {
 
		
			String cmd="";
			String workingDir =  System.getProperty("user.dir"); 
			File currentFolder = new File(workingDir);
			CommandManager manager=new CommandManager();
			
			while (!cmd.equals("exit")) {	
			System.out.print( currentFolder.getAbsolutePath() + "> ");
		
			Scanner userInput = new Scanner(System.in);
			cmd = userInput.next();
			
			String argument = userInput.nextLine().trim();
			try {
			Command command=manager.getCommand(cmd,argument);
			currentFolder=command.executeCommand(currentFolder);	
			} catch (BadCommandException e) {
				System.out.println(cmd);
				System.out.print("  is not recognized as an internal or external command,operable program or batch file");
				System.out.println( currentFolder.getAbsolutePath() + "> ");

			}		
			
		}
	}
}
