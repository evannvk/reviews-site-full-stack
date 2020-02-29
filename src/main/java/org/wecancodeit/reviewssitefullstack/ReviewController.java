package org.wecancodeit.reviewssitefullstack;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {


	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private CategoryRepository categoryRepo;

	@GetMapping("/reviews")
	public String findAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews"; // src/main/resources/templates + template name + .html
	}

	@GetMapping("/review")
	public String findOneReview(@RequestParam(value="id") long id, Model model) throws ReviewNotFoundException {
		Optional<Review> review = reviewRepo.findById(id);
		
		if(review.isPresent()) {
			model.addAttribute("reviews", review.get());
			return ("review");
		}
		throw new ReviewNotFoundException();
	}
	
	@GetMapping("/categories")
	public String findAllCategories(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "categories";
	}
	
	@GetMapping("/category")
	public String findOneCategory(@RequestParam(value="id") Long id, Model model) throws CategoryNotFoundException {
		Optional<Category> category = categoryRepo.findById(id);
		
		if(category.isPresent()) {
			model.addAttribute("category", category.get());
			return("category");
		}
		throw new CategoryNotFoundException();
	}

}
