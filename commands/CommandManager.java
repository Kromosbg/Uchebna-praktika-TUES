package stringvars;

import stringvars.commands.Cd;
import stringvars.commands.Cls;
import stringvars.commands.Command;
import stringvars.commands.Copy;
import stringvars.commands.Delete;
import stringvars.commands.Dir;
import stringvars.commands.Echo;
import stringvars.commands.Md;
import stringvars.commands.Move;
import stringvars.commands.Rd;

public class CommandManager  {


	public Command getCommand(String cmd,String argument) throws BadCommandException {

		if (cmd.equals("echo")) {
			Echo echo = new Echo(argument);
			return echo;
		}

		if (cmd.equals("move")){
			Move move = new Move(argument);
			return move;
		}
		
		if (cmd.equals("dir")) {
			Dir newDir = new Dir();
			return newDir;
		}

		if (cmd.equals("delete")) {
			Delete newDelete = new Delete(argument);
			return newDelete;
		}

		if (cmd.equals("copy")) {
			Copy newCopy = new Copy(argument);
			return newCopy;
		}

		if (cmd.equals("cd")) {
			Cd newCd = new Cd(argument);
			return newCd;
		}
		if (cmd.equals("cd..")) {
			Cd newCd = new Cd("..");
			return newCd;
		}

		if (cmd.equals("md") || cmd.equals("mkdir")) {
			Md newMd = new Md(argument);
			return newMd;
		}

		if (cmd.equals("rd") || cmd.equals("rmdir")) {
			Rd newRd = new Rd(argument);
			return newRd;
		}
		if (cmd.equals("cls")) {
			Cls newCls = new Cls();
			return newCls;

		}

		throw new BadCommandException();
	}
}
