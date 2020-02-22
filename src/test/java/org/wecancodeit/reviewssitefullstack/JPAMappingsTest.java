package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JPAMappingsTest {
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@Test
	public void shouldSaveAndLoadCategory() {
		Category category = categoryRepo.save(new Category("category"));
		long categoryId = category.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Category> result = categoryRepo.findById(categoryId);
		category = result.get();
		assertThat(category.getName(), is("category"));
		
	}
	
	@Test
	public void shouldGenerateCategoryId() {
		Category category = categoryRepo.save(new Category("category"));
		long categoryId = category.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		assertThat(categoryId, is(greaterThan(0L)));
	}
	
	@Test
	public void shouldSaveAndLoadReview() {
		Review review = new Review("title", "image", "content");
		review = reviewRepo.save(review);
		long reviewId = review.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Review> result = reviewRepo.findById(reviewId);
		review = result.get();
		assertThat(review.getTitle(), is("title"));
	}
	
	@Test
	public void shouldEstablishReviewToCategoryRelationships() {
		Category movies = categoryRepo.save(new Category("Movies"));
		Category comics = categoryRepo.save(new Category("Comics"));
		
		Review review = new Review("Batman", "Image", "Content", movies, comics);
		review = reviewRepo.save(review);
		long reviewId = review.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Review> result = reviewRepo.findById(reviewId);
		review = result.get();
		
		assertThat(review.getCategories(), containsInAnyOrder(movies, comics));
	}
	
	@Test
	public void shouldFindReviewsForCategory() {
		Category movies = categoryRepo.save(new Category("Movies"));
		
		Review darkKnight = reviewRepo.save(new Review ("The Dark Knight", "Image", "Content", movies));
		Review psycho = reviewRepo.save(new Review ("Pshyco", "Image", "Content", movies));
		
		entityManager.flush();
		entityManager.clear();
		
		Collection<Review> reviewsForCategory = reviewRepo.findByCategoriesContains(movies);
		
		assertThat(reviewsForCategory, containsInAnyOrder(darkKnight, psycho));
	}

}
