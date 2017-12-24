package com.keyholesoftware.stories.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "story")
public class UserStory {

	public UserStory() {
	}

	public UserStory(String title, String description, Long projectId, Long employeeId) {
		super();
		this.title = title;
		this.description = description;
		this.projectId = projectId;
		this.employeeId = employeeId;
	}

	@Id
	@GeneratedValue
	Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public UserStory getStory() {
		return story;
	}

	public void setStory(UserStory story) {
		this.story = story;
	}

	public Collection<UserStory> getRelatedStories() {
		return relatedStories;
	}

	public void setRelatedStories(Collection<UserStory> relatedStories) {
		this.relatedStories = relatedStories;
	}

	private String title;

	private String description;

	@Column(name = "project")
	private Long projectId;

	@Column(name = "assignee")
	private Long employeeId;

	@ManyToOne
	private UserStory story;

	@OneToMany(mappedBy = "story", fetch = FetchType.EAGER)
	private Collection<UserStory> relatedStories;

	@Override
	public String toString() {
		return "UserStory [oId=" + id + ", title=" + title + ", description=" + description + ", projectId=" + projectId
				+ ", employeeId=" + employeeId + ", story=" + story + "]";
	}

}
