package ca.earthgrazer.codereviewer.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public @ResponseBody String createReview(@RequestBody List<ReviewFile> files, HttpServletResponse response) {
		log.debug(files.toString());
		
		String refId = reviewService.createReviewUnit(files);
		
		return refId;
	}
}
