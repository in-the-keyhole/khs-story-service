package com.keyholesoftware.stories.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.keyholesoftware.stories.model.UserStory;

public interface StoryRepository extends CrudRepository<UserStory, Long>, QueryByExampleExecutor<UserStory> {

	List<UserStory> findByEmployeeId(Long employeeId);

	List<UserStory> findByProjectIdAndEmployeeId(Long projectId, Long employeeId);
}
