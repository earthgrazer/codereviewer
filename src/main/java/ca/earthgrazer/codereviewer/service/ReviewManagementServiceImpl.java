package ca.earthgrazer.codereviewer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.earthgrazer.codereviewer.model.ReviewFile;
import ca.earthgrazer.codereviewer.repository.ReviewRepository;

@Service
public class ReviewManagementServiceImpl implements ReviewManagementService {

	@Autowired private ReviewRepository reviewRepo;
	
	Map<String, List<ReviewFile>> reviewMap = new HashMap<>();
	
	@Override
	public String createReviewUnit(List<ReviewFile> fileList) {
		// filter out empty files
		List<ReviewFile> filteredList = fileList.stream()
												.filter(f -> !f.fileName.isEmpty() || 
															 !f.fileContent.isEmpty() ||
															 !f.fileDiff.isEmpty() ||
															 !f.fileComment.isEmpty())
												.collect(Collectors.toList());
		
		return reviewRepo.createReviewUnit(filteredList);
	}

	@Override
	public List<ReviewFile> getReviewUnit(String refId) {
		return reviewRepo.getReviewUnit(refId);
	}

}
