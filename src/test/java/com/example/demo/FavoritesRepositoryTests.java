package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class FavoritesRepositoryTests {
	
	@Autowired
	private FavoritesRepository favRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateFavorites() {
		Favorites fav = new Favorites();
		
		fav.setUserID(1);
		fav.setBookID(1);
		
		
		Favorites saved = favRepo.save(fav);
		Favorites exists = entityManager.find(Favorites.class, saved.getId());
		
		assertThat(exists.getUserID()).isEqualTo(fav.getUserID());
	}
	

}
