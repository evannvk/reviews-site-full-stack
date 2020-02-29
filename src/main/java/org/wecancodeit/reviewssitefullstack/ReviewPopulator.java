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
		
		Review maus = new Review("Maus", "/images/maus.jpeg", "Content", comics);
		maus = reviewRepo.save(maus);
		Review eternalSunshine = new Review("Eternal Sunshine of the Spotless Mind", "/images/eternal-sunshine.png", "Content", movies);
		eternalSunshine = reviewRepo.save(eternalSunshine);
		Review remoDrive = new Review("Greatest Hits by Remo Drive", "/images/remo-drive.jpg", "Content", music);
		remoDrive = reviewRepo.save(remoDrive);
		Review scottPilgrim = new Review("Scott Pilgrim vs. The World", "/images/scott-pilgrim.jpg", "Content", comics, movies, music);
		scottPilgrim = reviewRepo.save(scottPilgrim);
	}

}
