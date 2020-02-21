package org.wecancodeit.reviewssitefullstack;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {

	private Map<Long, Review> reviewList = new HashMap<>();
	private Review reviewOne = new Review(1, "Eternal Sunshine of the Spotless Mind", "Movies", "/images/Eternal-Sunshine.png", 
			"Eternal sunshine of the spottless mind is one of my favortie movies. It takes the classic American Romance movies and turns it on its head by " +
			"showing the fragility of memory and love. After Joel Barrish (Jim Carrey) and Clementine Kruczynski (Kate Winslet) find each other on a trip " +
			"skipping work, a relationship starts to bud after a few nights spent together. Soon we discover this is not a new relationship, and the two had " +
			"broken up recently and Clementine had her memory erased, eager to move on with her life. Upon discovering this, Joel decides to have his memory erased " +
			"as well. But as the procedure is being performed, the memories of fondness and tender love give him second thoughts and begins to fight the operation." +
			"We then follow Joel in his desperate quest to prevent the procedure.");
	private Review reviewTwo = new Review(2, "Maus", "Comics", "/images/maus.jpeg", 
			"Maus, a two-part graphic novel written and drawn by Art Spiegelman, depicts his father's tale as a Jewish man during the holocaust. The graphic novel " +
			"depitcs the horrifying historical event with cats and mice. Yes, the Jewish people are depicted as mice and the nazis as cats. As interesting as the " +
			"holocaust is, the story is just as much about that as it is the realationship with Art and his father, Vladek. It reads as a memoir of Art's interviews" +
			"with his father twoards the end of his life.");

	public ReviewRepository() {
		reviewList.put(reviewOne.getId(), reviewOne);
		reviewList.put(reviewTwo.getId(), reviewTwo);
	}

	// uses varargs for testing purposes to take on the necessary courses
	public ReviewRepository(Review... reviews) {
		for (Review review: reviews) {
			reviewList.put(review.getId(), review);
		}
	}

	public Review findOneReview(long id) {

		return reviewList.get(id);
	}

	public Collection<Review> findAllReviews() {

		return reviewList.values();
	}

}
