package ca.earthgrazer.codereviewer.model;

public class ReviewFile {
	
	public String fileName = "";
	
	public String fileContent = "";
	
	public String fileDiff = "";
	
	public String fileComment = "";
	
	public ReviewFile() {}

	@Override
	public String toString() {
		return "ReviewFile [fileName=" + fileName + ", fileContent=" + fileContent + ", fileDiff=" + fileDiff
				+ ", fileComment=" + fileComment + "]";
	}
}
