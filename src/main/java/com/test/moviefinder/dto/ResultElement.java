package com.test.moviefinder.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Darshan Mehta
 *
 * DTO to hold movie information
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultElement {

	@JsonProperty("title")
	private String title;
	
	@JsonProperty("release_date")
	private String releaseDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
}
