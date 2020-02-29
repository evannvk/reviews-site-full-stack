package org.wecancodeit.reviewssitefullstack;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewPopulator implements CommandLineRunner {
	
	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category movies = new Category("Movies");
		movies = categoryRepo.save(movies);
		Category comics = new Category("Comics");
		comics = categoryRepo.save(comics);
		Category music = new Category("Music");
		music = categoryRepo.save(music);
		
		Review maus = new Review("Maus", "/images/maus.jpeg", 
			"Maus, a two-part graphic novel written and drawn by Art Spiegelman, depicts his father's tale as a Jewish man during the holocaust. The graphic novel " +
			"depitcs the horrifying historical event with cats and mice. Yes, the Jewish people are depicted as mice and the nazis as cats. As interesting as the " +
			"holocaust is, the story is just as much about that as it is the realationship with Art and his father, Vladek. It reads as a memoir of Art's interviews" +
			"with his father twoards the end of his life.", comics);
		maus = reviewRepo.save(maus);
		Review eternalSunshine = new Review("Eternal Sunshine of the Spotless Mind", "/images/eternal-sunshine.png", 
			"Eternal sunshine of the spottless mind is one of my favortie movies. It takes the classic American Romance movies and turns it on its head by " +
			"showing the fragility of memory and love. After Joel Barrish (Jim Carrey) and Clementine Kruczynski (Kate Winslet) find each other on a trip " +
			"skipping work, a relationship starts to bud after a few nights spent together. Soon we discover this is not a new relationship, and the two had " +
			"broken up recently and Clementine had her memory erased, eager to move on with her life. Upon discovering this, Joel decides to have his memory erased " +
			"as well. But as the procedure is being performed, the memories of fondness and tender love give him second thoughts and begins to fight the operation." +
			"We then follow Joel in his desperate quest to prevent the procedure.", movies);
		eternalSunshine = reviewRepo.save(eternalSunshine);
		Review remoDrive = new Review("Greatest Hits by Remo Drive", "/images/remo-drive.jpg", "content", music);
		remoDrive = reviewRepo.save(remoDrive);
		Review scottPilgrim = new Review("Scott Pilgrim vs. The World", "/images/scott-pilgrim.jpg", "Content", comics, movies, music);
		scottPilgrim = reviewRepo.save(scottPilgrim);
	}

}
