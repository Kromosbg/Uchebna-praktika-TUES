package stringvars;

import java.util.Scanner;
import java.io.File;

public class Newterminal extends Dir {
	
		public static void main(String[] args) {

		File currentFolder = null;
		
			String cmd="";
			String workingDir =  System.getProperty("user.dir"); 
			currentFolder = new File(workingDir);
			
			while (!cmd.equals("exit")) {	
			System.out.print( currentFolder.getAbsolutePath() + "> ");
		
			Scanner userInput = new Scanner(System.in);
			cmd = userInput.next();
			

			if(cmd.equals("echo")) {
				Echo print=new Echo();
				print.message=userInput.nextLine();
				print.executeCommand();
			}
			
			if(cmd.equals("dir")) {
				Dir newDir = new Dir();
				newDir.folderToList = currentFolder;
				newDir.runDir();
			}
			
			if(cmd.equals("cd")) {
				Cd newCd = new Cd(userInput.next());				
				currentFolder=newCd.executeCommand(currentFolder);
			}

			
			
			if(cmd.equals("md") || cmd.equals("mkdir")) {
				Md newMd = new Md();
				newMd.newFolder=currentFolder.getAbsolutePath() + "\\" + userInput.next();
				newMd.md();
			}
			if(cmd.equals("rd") || cmd.equals("rmdir")) {
				Rd newRd = new Rd();
				newRd.newFolder=currentFolder.getAbsolutePath() + "\\" + userInput.next();
				newRd.rd();
			}
			if(cmd.equals("cls")){
				Cls.cls();
			}
			if(!cmd.equals("cls") && !cmd.equals("cd") && !cmd.equals("dir") && !cmd.equals("echo") && !cmd.equals("rd") && !cmd.equals("rmdir") && !cmd.equals("md")&& !cmd.equals("mkdir") && !cmd.equals("cd..") ) {
				System.out.println(cmd);
				System.out.print("  is not recognized as an internal or external command,operable program or batch file");
				System.out.println( currentFolder.getAbsolutePath() + "> ");
			}
		}
	}
}
