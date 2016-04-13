package ca.earthgrazer.codereviewer.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.earthgrazer.codereviewer.model.ReviewFile;
import ca.earthgrazer.codereviewer.service.ReviewManagementService;

@Controller
@RequestMapping("/review")
public class ReviewUnitController {
	
	private static final Logger log = LoggerFactory.getLogger(ReviewUnitController.class);
	
	@Autowired private ReviewManagementService reviewService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String newReviewPage(Model model) {
		model.addAttribute("ref", UUID.randomUUID().toString());
		return "newreview";
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody String createReview(@RequestBody List<ReviewFile> files) throws UnsupportedEncodingException {
		log.debug(files.toString());
		
		return URLEncoder.encode(reviewService.createReviewUnit(files), "UTF-8");
	}
	
	@RequestMapping(value="/{ref}", method=RequestMethod.GET)
	public String getReview(@PathVariable String ref, Model model) {
		List<ReviewFile> files = reviewService.getReviewUnit(ref);
		
		model.addAttribute("files", files);
		
		return "viewreview";
	}
}
