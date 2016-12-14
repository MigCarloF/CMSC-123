package cmd;

import java.util.LinkedList;
import java.util.List;

public class Folder extends File {
	private List<File> contents;
	private Folder parent;

	public Folder(String name) {
		setName(name);
		contents = new LinkedList<File>();
	}

	public void addFile(File f){
		contents.add(f);
	}
	public Folder getParent() {
		return parent;
	}

	public void setParent(Folder parent) {
		this.parent = parent;
	}
	
	public List<File> getContents() {
		return contents;
	}
}
