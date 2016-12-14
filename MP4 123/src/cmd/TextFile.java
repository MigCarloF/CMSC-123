package cmd;

public class TextFile extends File {
	private String contents;

	public TextFile(String name) {
		setName(name);
		setContents("");
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
