package com.test.moviefinder.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.test.moviefinder.dto.ResponseDto;
import com.test.moviefinder.dto.ResultElement;
import com.test.moviefinder.dto.TmdbResponseDto;
import com.test.moviefinder.model.API;

/**
 * 
 * @author Darshan Mehta
 * This class is a part of service layer of the application. It implements move method of MovieService interface which is used by controller.
 */
@Component
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${tmdb.api.url:https://api.themoviedb.org/3/search/movie?api_key=}")
	private String tmdbAPIUrl;
	
	@Value("${tmdb.api.key:b7419ede19ac8af5b9a418941783d6e9}")
	private String tmdbApiKey;
	
	@Value("${imdb.api.url:http://www.theimdbapi.org/api/find/movie?title=}")
	private String imdbAPIUrl;
	
	/**
	 * Finds the movie based on the api and movie name
	 * @param api the api name
	 * @param movie the movie name
	 * @return response containing movie names and release dates
	 * @throws Exception exception if there is any error in finding movie name
	 */
	@Override
	public ResponseDto find(API api, String movie) throws Exception{
		switch(api) {
		case TMDB : 
				return findWithTmdb(movie);
				
		case IMDB :
				return findWithImdb(movie);
			
			default:
				throw new IllegalArgumentException("Invalid API Type");
		}
	}
	
	/**
	 * Finds the movie details by calling tmdb API
	 * @param name the movie name
	 * @return the movie names and release dates
	 * @throws Exception exception if there is any, while finding movie name
	 */
	private ResponseDto findWithTmdb(String name) throws Exception{
		TmdbResponseDto tmdbResponse = restTemplate.getForObject(new URI(tmdbAPIUrl + tmdbApiKey + "&query=" + name), TmdbResponseDto.class);
		return new ResponseDto(getElements(tmdbResponse.getResults().iterator(), 4));
	}
	
	/**
	 * Finds the movie details by calling imdb API
	 * @param name the movie name
	 * @return the movie names and release dates
	 * @throws Exception exception if there is any, while finding movie name
	 */
	private ResponseDto findWithImdb(String name){
		ResponseEntity<List<ResultElement>> imdbResults = restTemplate.exchange(imdbAPIUrl + name, HttpMethod.GET, null, new ParameterizedTypeReference	<List<ResultElement>>() {});
		return new ResponseDto(getElements(imdbResults.getBody().iterator(), 4));
	}
	
	/**
	 * Returns 'limit' number of elements from the Iterable represented by iterator
	 * @param iterator the iterator to collection
	 * @param limit number of elements to extract
	 * @return the list of elements
	 */
	private List<ResultElement> getElements(Iterator<ResultElement> iterator, int limit){
		List<ResultElement> results = new ArrayList<>();
		int count = 0;
		while(++count <= limit && iterator.hasNext()){
			results.add(iterator.next());
		}
		return results;
	}
}