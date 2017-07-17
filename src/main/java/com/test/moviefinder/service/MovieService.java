package com.test.moviefinder.service;

import com.test.moviefinder.dto.ResponseDto;
import com.test.moviefinder.model.API;

/**
 * 
 * @author Darshan Mehta
 * This interface can be used by any class to perform 'find' operation
 */
public interface MovieService {
	
	/**
	 * Finds the movie based on the api and movie name
	 * @param api the api name
	 * @param movie the movie name
	 * @return response containing movie names and release dates
	 * @throws Exception exception if there is any error in finding movie name
	 */
	public ResponseDto find(API api, String movie) throws Exception;

}
