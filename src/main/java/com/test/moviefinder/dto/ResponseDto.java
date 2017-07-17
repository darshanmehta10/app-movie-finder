package com.test.moviefinder.dto;

import java.util.List;

/**
 * 
 * @author Darshan Mehta
 *
 * DTO to handle API responses
 */
public class ResponseDto {
	
	private List<ResultElement> movies;
	
	public ResponseDto(){}
	
	public ResponseDto(List<ResultElement> movies){
		this.movies = movies;
	}

	public List<ResultElement> getMovies() {
		return movies;
	}

	public void setMovies(List<ResultElement> movies) {
		this.movies = movies;
	}
}
