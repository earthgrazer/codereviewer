package ca.earthgrazer.codereviewer.service;

import java.util.List;

import ca.earthgrazer.codereviewer.model.ReviewFile;

public interface ReviewManagementService {
	
	String createReviewUnit(List<ReviewFile> fileList);
	
	List<ReviewFile> getReviewUnit(String refId);
}
