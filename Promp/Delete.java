package stringvars.commands;

import java.io.File;
//import java.nio.file.Path;
//import java.nio.file.Paths;














import stringvars.ComResponse;

public class Delete extends CommandWithArgument implements Command {
   


	public Delete(String newString) {
		super(newString);
	}

	public ComResponse executeCommand(File currentFolder) {
		

		StringBuilder text = new StringBuilder();
		ComResponse current= new ComResponse(currentFolder, text );
		
		try{	 		
			
	 		File delfile = new File(getArgument());
	 		//delfile.delete();
	 		System.out.println("deleting: "+getArgument());
    		if(delfile.delete()){
    			text.append(delfile.getName() + " is deleted!");
    		}else{
    			text.append("Delete operation is failed.");
    		}
    		
    	}catch(Exception e){
 
    		e.printStackTrace();
 
    	}
		
	 	return current;
	}
}
