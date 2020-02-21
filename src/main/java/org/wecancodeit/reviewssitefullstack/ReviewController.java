package org.wecancodeit.reviewssitefullstack;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviewssitefullstack.ReviewNotFoundException;
import org.wecancodeit.reviewssitefullstack.ReviewRepository;

@Controller
public class ReviewController {


	@Resource
	private ReviewRepository reviewRepo;

	@GetMapping("/reviews")
	public String findAllReviews(Model model) {
		model.addAttribute("reviewsModel", reviewRepo.findAllReviews());
		return "reviews-headpage"; // src/main/resources/templates + template name + .html
	}

	@GetMapping("/review")
	public String findOneReview(@RequestParam Long id, Model model) throws ReviewNotFoundException {
		if (reviewRepo.findOneReview(id) == null) {
			throw new ReviewNotFoundException();
		}
		model.addAttribute("reviewModel", reviewRepo.findOneReview(id));
		return "review-template.html";
	}

}
