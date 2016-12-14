package cmd;

import exceptions.NoParentException;

public class CMDLayout {
	private Folder currentFolder;
	private Folder root;

	// constructor
	public CMDLayout() {
		root = new Folder("root");
		setCurrentFolder(root);
	}

	// functionality
	public void showFiles() {

	}
	
	public void goUp() throws NoParentException {
		if (currentFolder.getParent() == null){
			throw new NoParentException("You are at root! No parent ");
		} else {
			setCurrentFolder(currentFolder.getParent());
		}
	}
	public void addFolder(String name) {
		currentFolder.addFile(new Folder(name));
	}

	public void renameFile(String name, String newName) {
		for (File f : currentFolder.getContents()) {
			if (f.getName().equals(name)) {
				f.setName(newName);
			}
		}
	}

	public String printCurrentDirectory() {
		return printCurrentDirectory(currentFolder);
	}

	private String printCurrentDirectory(Folder current) {
		if (current.getParent() == null) {
			return "/" + current.getName();
		} else {
			return printCurrentDirectory(current.getParent()) + "/" + current.getName();
		}
	}

	// getters and setters
	public Folder getCurrentFolder() {
		return currentFolder;
	}

	public void setCurrentFolder(Folder currentFolder) {
		this.currentFolder = currentFolder;
	}

	public Folder getRoot() {
		return root;
	}

	public void removeFolder(String name) {
		for(File f : currentFolder.getContents()){
			if (f instanceof Folder && f.getName().equals(name)){
				currentFolder.getContents().remove(f);
				((Folder)f).setParent(null);
			}
		}
	}

}
