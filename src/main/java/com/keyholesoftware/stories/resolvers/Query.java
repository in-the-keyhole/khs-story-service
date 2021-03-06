package com.keyholesoftware.stories.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import com.keyholesoftware.stories.model.UserStory;
import com.keyholesoftware.stories.repository.StoryRepository;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	private StoryRepository storyRepository;

	public UserStory story(Long id) {
		return storyRepository.findOne(id);
	}

	public List<UserStory> stories(Long projectId, Long employeeId) {
		if (projectId == null && employeeId == null) {
			return Lists.newArrayList(storyRepository.findAll());
		}

		UserStory story = new UserStory();
		if (projectId != null) {
			story.setProjectId(projectId);
		}
		if (employeeId != null) {
			story.setEmployeeId(employeeId);
		}

		return Lists.newArrayList(storyRepository.findAll(Example.of(story)));
	}
}
