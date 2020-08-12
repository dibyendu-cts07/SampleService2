package com.cts.sr.moviecruiser.movie.model;

import org.springframework.data.annotation.Id;

import com.cts.sr.moviecruiser.movie.data.MovieDTO;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

@Document(collection = "Movie")
public class Movie {
	
	@Id
	private Integer id;

	@PartitionKey
	private String userId;
	
	private String name;
	
	private String posterPath;
	
	private String releaseDate;
	
	private String description;
	
	private Double voteAverage;
	
	private Long voteCount;
	
	private String comment;
	
	public Movie() {
	}
	
	public Movie(Integer id, String userId, String name, String posterPath, String releaseDate, Double voteAverage,
			Long voteCount) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.posterPath = posterPath;
		this.releaseDate = releaseDate;
		this.voteAverage = voteAverage;
		this.voteCount = voteCount;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPosterPath() {
		return posterPath;
	}
	
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public Double getVoteAverage() {
		return voteAverage;
	}
	
	public void setVoteAverage(Double voteAverage) {
		this.voteAverage = voteAverage;
	}
	
	public Long getVoteCount() {
		return voteCount;
	}
	
	public void setVoteCount(Long voteCount) {
		this.voteCount = voteCount;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void copy(MovieDTO dto){
		
		if(dto.getId() != null)
			this.setId(dto.getId());
		if(dto.getName() != null)
			this.setName(dto.getName());
		if(dto.getPosterPath() != null)
			this.setPosterPath(dto.getPosterPath());
		if(dto.getDescription() != null)
			this.setDescription(dto.getDescription());
		if(dto.getReleaseDate() != null)
			this.setReleaseDate(dto.getReleaseDate());
		if(dto.getVoteAverage() != null)
			this.setVoteAverage(dto.getVoteAverage());
		if(dto.getVoteCount() != null)
			this.setVoteCount(dto.getVoteCount());
		if(dto.getComment() != null)
			this.setComment(dto.getComment());
		
	}
	
}