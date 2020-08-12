package com.cts.sr.moviecruiser.movie.repository;

import java.util.List;

import com.cts.sr.moviecruiser.movie.model.Movie;
import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;

public interface MovieRepository extends ReactiveCosmosRepository<Movie, Integer> {
	
	public List<Movie> findByUserId(String userId);
}