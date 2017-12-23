package com.keyholesoftware.stories;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.keyholesoftware.stories.model.UserStory;
import com.keyholesoftware.stories.repository.StoryRepository;

@SpringBootApplication
public class StoriesApp {

	public static void main(String[] args) {
		SpringApplication.run(StoriesApp.class, args);
	}

	@Bean
	public CommandLineRunner seedDatabase(StoryRepository repository) {
		return (args) -> {
			// billing system
			repository.save(new UserStory("Time Tracking",
					"As as user I want to edit time for a project using my computer.", 1L, 4L));
			repository.save(new UserStory("Time tracking for mobile",
					"As a user I want to edit time tracking using my phone.", 1L, 3L));
			repository.save(new UserStory("Add tracking for the future",
					"As a user I want to edit time and space so that I can enter my time yesterday.", 1L, 4L));

			// mobilization
			UserStory mobileRef = repository.save(new UserStory("Reference Projects",
					"As as user I want to see examples of mobile projects", 3L, 4L));

			UserStory xamarin = repository
					.save(new UserStory("Xamarin Example", "SPIKE - Xamarin Reference Project", 3L, 5L));
			UserStory reactNative = repository
					.save(new UserStory("React Native Example", "SPIKE - React Native Example", 3L, 6L));
			UserStory flutter = repository.save(new UserStory("Flutter Example", "SPIKE - Flutter Example", 3L, 7L));

			xamarin.setStory(mobileRef);
			reactNative.setStory(mobileRef);
			flutter.setStory(mobileRef);

			mobileRef.setRelatedStories(Arrays.asList(xamarin, reactNative, flutter));

			repository.save(mobileRef);
			repository.save(xamarin);
			repository.save(reactNative);
			repository.save(flutter);

			List<UserStory> jaimeStories = repository.findByEmployeeId(4L);
			System.out.println(jaimeStories);
			// List<UserStory> daveStories = repository.findByEmployeeId(3L);
		};
	}
}
