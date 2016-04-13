package ca.earthgrazer.codereviewer.repository;

import java.util.List;

import ca.earthgrazer.codereviewer.model.ReviewFile;

public interface ReviewRepository {

	String createReviewUnit(List<ReviewFile> fileList);
	
	List<ReviewFile> getReviewUnit(String refId);
}
