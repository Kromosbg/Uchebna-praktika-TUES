package stringvars;

import java.io.File;


public class Back {
	String ch;
	
	public File back() {
		File resultFolder=new File(ch);
		ch = resultFolder.getParent();
		resultFolder=new File(ch);
		return resultFolder;
	}
}   
