package com.test.moviefinder.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Darshan Mehta
 *
 * DTO to hold repsonse of tmdb API
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TmdbResponseDto {
	
	private List<ResultElement> results;

	public List<ResultElement> getResults() {
		return results;
	}

	public void setResults(List<ResultElement> results) {
		this.results = results;
	}
}
