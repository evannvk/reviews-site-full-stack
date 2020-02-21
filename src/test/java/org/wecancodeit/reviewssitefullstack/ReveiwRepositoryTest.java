package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.wecancodeit.reviewssitefullstack.Review;
import org.wecancodeit.reviewssitefullstack.ReviewRepository;

public class ReveiwRepositoryTest {

	@Resource
	private ReviewRepository underTest;

	private Review reviewOne = new Review(1, "Boxing", "description", "image url", "content");
	private Review reviewTwo = new Review(2, "review name", "description", "image url", "content");

	@Test
	public void shouldFindReviewOneById() {
		underTest = new ReviewRepository(reviewOne);
		Review foundReview = underTest.findOneReview(1);
		assertThat(foundReview, is(reviewOne));
	}

	@Test
	public void shouldFindReviewTwoById() {
		underTest = new ReviewRepository(reviewTwo);
		Review foundReviews = underTest.findOneReview(2);
		assertThat(foundReviews, is(reviewTwo));
	}

	@Test
	public void shouldFindAllReviews() {
		underTest = new ReviewRepository(reviewOne, reviewTwo);
		Collection<Review> foundReviews = underTest.findAllReviews();
		assertThat(foundReviews, containsInAnyOrder(reviewOne, reviewTwo));
	}

}
