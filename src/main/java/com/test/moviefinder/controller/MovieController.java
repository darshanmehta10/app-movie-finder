package com.test.moviefinder.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.moviefinder.dto.ResponseDto;
import com.test.moviefinder.model.API;
import com.test.moviefinder.service.MovieService;

/**
 * 
 * @author Darshan Mehta
 * This class is a part of controller layer. It gets the API request, calls service method
 * and returns appropriate response
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/find")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	/**
	 * Calls 'find' method of service class and returns the response
	 * @param request the request object
	 * @return the response containing number of movies and release dates. Error if anything 
	 * goes wrong
	 */
	@RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Object> find(@RequestParam(value = "movie", required = true) String name, @RequestParam(value = "api", required = true) API api){
		try{
			ResponseDto response = movieService.find(api, name);
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		}catch(Exception e){
			Map<String, String> errorData = new HashMap<>();
			errorData.put("error", e.getMessage());
			return new ResponseEntity<Object>(errorData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
