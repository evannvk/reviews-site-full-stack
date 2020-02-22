package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerMockMVCTest {

	
	
	@Resource
	private MockMvc mvc;
	
	@Mock
	private Review reviewOne;
	
	@Mock
	private Review reviewTwo;
	
	@Mock
	private Category categoryOne;
	
	@Mock
	private Category categoryTwo;
	
	@MockBean
	private ReviewRepository reviewRepo;
	
	@MockBean
	private CategoryRepository categoryRepo;
	
	@Test
	public void shouldBeOkForSingleReview() throws Exception {
		long testReviewId = 1;
		when(reviewRepo.findById(testReviewId)).thenReturn(Optional.of(reviewOne));
		mvc.perform(get("/review?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToSingleReview() throws Exception {
		long testReviewId = 1;
		when(reviewRepo.findById(testReviewId)).thenReturn(Optional.of(reviewOne));
		mvc.perform(get("/review?id=1")).andExpect(view().name(is("review-template")));
	}
	
	@Test
	public void shouldNotBeOkForSingleReview() throws Exception {
		mvc.perform(get("/review?id=1")).andExpect(status().isNotFound());
	}
	
	@Test
	public void shouldPutSingleReviewIntoModel() throws Exception {
		when(reviewRepo.findById(1L)).thenReturn(Optional.of(reviewOne));
		
		mvc.perform(get("/review?id=1")).andExpect(model().attribute("reviews-headpage", is (reviewOne)));
	}
}
