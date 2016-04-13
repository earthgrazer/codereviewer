package ca.earthgrazer.codereviewer.model;

public class ReviewFile {
	
	public String fileName;
	
	public String fileContent;
	
	public String fileDiff;
	
	public ReviewFile() {}

	@Override
	public String toString() {
		return "File [fileName=" + fileName + ", fileContent=" + fileContent + ", fileDiff=" + fileDiff + "]";
	}
}
