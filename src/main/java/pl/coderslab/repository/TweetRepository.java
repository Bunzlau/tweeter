package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.model.Tweet;
import pl.coderslab.model.User;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
	List<Tweet> findAllTweetsByUserId(long id);

	List<Tweet> findAllTweetsByUser(User user);

	@Query("SELECT tweet FROM Tweet tweet ORDER BY created DESC")
	List<Tweet> findAllTweetsOrderByreatedDesc();

}
