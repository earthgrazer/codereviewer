package ca.earthgrazer.codereviewer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import ca.earthgrazer.codereviewer.model.ReviewFile;

@Service
public class ReviewManagementServiceImpl implements ReviewManagementService {

	Map<String, List<ReviewFile>> reviewMap = new HashMap<>();
	
	@Override
	public String createReviewUnit(List<ReviewFile> fileList) {
		String refId = UUID.randomUUID().toString();
		
		reviewMap.put(refId, fileList);
		
		return refId;
	}

	@Override
	public List<ReviewFile> getReviewUnit(String refId) {
		return reviewMap.get(refId);
	}

}
