package ca.earthgrazer.codereviewer.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.earthgrazer.codereviewer.model.ReviewUnit;

@Controller
@RequestMapping("/review")
public class ReviewUnitController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String newReviewPage(Model model) {
		model.addAttribute("ref", UUID.randomUUID().toString());
		return "newreview";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void createReview(@RequestBody ReviewUnit reviewUnit) {
		
	}
}
