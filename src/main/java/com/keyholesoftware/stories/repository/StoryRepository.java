package com.keyholesoftware.stories.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.keyholesoftware.stories.model.UserStory;

public interface StoryRepository extends CrudRepository<UserStory, Long>{
	
    List<UserStory> findByEmployeeId(Long employeeId);

 
}
