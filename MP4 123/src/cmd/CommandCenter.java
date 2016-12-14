package cmd;

import exceptions.InvalidInputException;
import exceptions.NoParentException;
import exceptions.NotEnoughArgumentsException;

public class CommandCenter {
	private CMDLayout layout;
	private String command;
	private String name1;
	private String name2;
	private String[] validOneArgCommands;
	private String[] validTwoArgCommands;

	public CommandCenter() {
		layout = new CMDLayout();
		validOneArgCommands = new String[] { "mkdir", "rmdir", "cd", "edit", "rm", "show", "ls", "whereis" };
		validTwoArgCommands = new String[] { "rn", "mv", "cp" };
	}

	public void perform(String input) throws InvalidInputException, NotEnoughArgumentsException {
		resetInputs();
		String[] inputs = input.split("\\s+");
		
		if (inputs.length == 0){
			showCurrentFolder();
		}
		
		else if (inputs.length == 1) {
			command = inputs[0];
			switch (command) {
			case "":
				showCurrentFolder();
				break;
			case "ls":
				for (File f : layout.getCurrentFolder().getContents()) {
					System.out.println(f.getName());
				}
				break;
			case "cd..":
				try{
					layout.goUp();
				}catch(NoParentException e){
					System.out.println(e.getMessage());
				}
				break;
			default:
				for(String s : validOneArgCommands) {
					if (s.equals(command)){
						throw new NotEnoughArgumentsException(command + " requires one more argument to execute");
					}
				}
				for(String s : validTwoArgCommands) {
					if (s.equals(command)){
						throw new NotEnoughArgumentsException(command + " requires two more arguments to execute");
					}
				}
				throw new InvalidInputException(command + " is not recognized as an internal or external command, text file or doc file");
			}
		}
		
		else if (inputs.length == 2) {
			command = inputs[0];
			name1 = inputs[1];
			switch (command) {
			case "mkdir":
				layout.addFolder(name1);
				break;
			case "rmdir":
				layout.removeFolder(name1);
				break;
			case "cd":// TODO
				System.out.println("changed dir to " + name1);
				break;
			case "edit":// TODO
				System.out.println("editing " + name1);
				break;
			case "rm":// TODO
				System.out.println("removed " + name1);
				break;
			case "show":// TODO
				System.out.println("showing " + name1);
				break;
			case "ls":// TODO
				System.out.println("showing all " + name1);
				break;
			case "whereis":// TODO
				System.out.println("here is " + name1);
				break;
			default:
				for(String s : validTwoArgCommands) {
					if (s.equals(command)){
						throw new NotEnoughArgumentsException(command + " requires one more argument to execute");
					}
				}
				throw new InvalidInputException(command + " is not recognized as an internal or external command, text file or doc file");
			}
		} else if (inputs.length == 3) {
			command = inputs[0];
			name1 = inputs[1];
			name2 = inputs[2];
			switch (command) {
			case "rn":// TODO
				System.out.println("Renamed " + name1 + " to " + name2);
				break;
			case "mv":// TODO
				System.out.println("Moved " + name1 + " to " + name2);
				break;
			case "cp":// TODO
				System.out.println("Copied " + name1 + " as " + name2);
				break;
			default:
				throw new InvalidInputException(command + " is not recognized as an internal or external command, text file or doc file");
			}
		} else {
			throw new InvalidInputException(command + " is not recognized as an internal or external command, text file or doc file");
		}
	}

	private void resetInputs() {
		name1 = "";
		name2 = "";
		command = "";

	}

	public String showCurrentFolder() {
		return layout.printCurrentDirectory();
	}
}
