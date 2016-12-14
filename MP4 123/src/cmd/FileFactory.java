package cmd;

public class FileFactory {
	
	public static File makeFile(String command, String name){
		if(command.equals("mkdir")){
			return new Folder(name);
		}
		else if(command.equals("edit")){
			return new TextFile(name);
		}
		return null;
	}
}
