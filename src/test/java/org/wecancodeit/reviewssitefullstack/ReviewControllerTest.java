package org.wecancodeit.reviewssitefullstack;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class ReviewControllerTest {

	@InjectMocks
	private ReviewController underTest;

	@Mock
	private Review reviewOne;

	@Mock
	private Review reviewTwo;

	@Mock
	private ReviewRepository reviewRepo;

	@Mock
	private Category categoryOne;

	@Mock
	private Category categoryTwo;

	@Mock
	private CategoryRepository categoryRepo;

	@Mock
	private Model model;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddSingleCourseToModel() throws ReviewNotFoundException {
		long testReviewId = 1;
		when(reviewRepo.findById(testReviewId)).thenReturn(Optional.of(reviewOne));

		underTest.findOneReview(testReviewId, model);
		verify(model).addAttribute("reviews-headpage", reviewOne);
	}

	@Test
	public void shouldAddAllReviewsToModel() {
		Collection<Review> allReviews = Arrays.asList(reviewOne, reviewTwo);
		when(reviewRepo.findAll()).thenReturn(allReviews);

		underTest.findAllReviews(model);
		verify(model).addAttribute("reviews-headpage", allReviews);
	}

	@Test
	public void shouldAddSingleCategoryToModel() throws CategoryNotFoundException {
		long testCategoryId = 1;
		when(categoryRepo.findById(testCategoryId)).thenReturn(Optional.of(categoryOne));

		underTest.findOneCategory(testCategoryId, model);
		verify(model).addAttribute("categories-headpage", categoryOne);
	}

	@Test
	public void shouldAddAllCategoriesToModel() {
		Collection<Category> allCategories = Arrays.asList(categoryOne, categoryTwo);
		when(categoryRepo.findAll()).thenReturn(allCategories);

		underTest.findAllCategories(model);
		verify(model).addAttribute("categories-headpage", allCategories);
	}

}
