package com.cts.sr.moviecruiser.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azure.data.cosmos.PartitionKey;
import com.cts.sr.moviecruiser.movie.model.Movie;
import com.cts.sr.moviecruiser.movie.repository.MovieRepository;

import reactor.core.publisher.Mono;

@Service
public class MovieServiceImpl implements MovieService {
	
	
	@Autowired
	private MovieRepository movieRepository;
	
	public boolean saveMovie(Movie movie) throws Exception {
		try {
			Mono<Movie> savedMovie = movieRepository.save(movie);
			savedMovie.block();
		}
		catch(Exception ex) {
			throw ex;
		}
		return true;
	}
	
	public boolean deleteMovie(int id) throws Exception {
		
		Mono<Movie> movie = movieRepository.findById(id);
		
		if (movie.block() == null) {
			throw new Exception("Movie not found");
		}
		
		movieRepository.delete(movie.block());
		
		return true;
	}
	
	public Movie getMovieById(int id) throws Exception {
		Mono<Movie> movie = movieRepository.findById(id);
		
		if (movie.block() == null) {
			throw new Exception("Movie not found");
		}
		return movie.block();
	}
	@Override
	public List<Movie> getAllMovies(String userId) throws Exception {
		List<Movie> movies = movieRepository.findAll(new PartitionKey(userId)).collectList().block();
		return movies;
	}
}
