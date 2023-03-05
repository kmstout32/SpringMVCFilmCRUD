package com.skilldistillery.film.entities;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film {
	List<Actor> actorList = new ArrayList<>();
	public List<Actor> getActorList() {
		return actorList;
	}


	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
	}
	private Integer id;
	private String title;
	private String description;
	private Integer releaseYear;
	private Integer languageId;
	private Integer rentalDuration;
	private Double rentalRate;
	private Integer length;
	private Double replacementCost;
	private String rating;
	private String specialFeature;
	private String language;
	private String category;
	private String condition;
	private String leftInStock;
	


	public Film(Integer id, String title, String description, Integer releaseYear, Integer languageId,
			Integer rentalDuration, Double rentalRate, Integer length, Double replacementCost, String rating,
			String specialFeature) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeature = specialFeature;
	}
	
	
	public Film(Integer id, String title, String description, Integer releaseYear,
			Integer languageId, Integer rentalDuration, Double rentalRate, Integer length, Double replacementCost,
			String rating, String specialFeature, String language) {
	
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeature = specialFeature;
		this.language = language;
	}
	


	public Film(Integer id, String title, String description, Integer releaseYear, Integer languageId,
			Integer rentalDuration, Double rentalRate, Integer length, Double replacementCost, String rating,
			String specialFeature, String language, String category) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeature = specialFeature;
		this.language = language;
		this.category = category;
	}


	public Film() {
		// TODO Auto-generated constructor stub
	}
	
	public Film(String title, String desc, Integer releaseYear, String lang) {
		this.title = title;
		this.description = desc;
		this.releaseYear = releaseYear;
		this.language = lang;
	
		
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Integer getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	public Integer getLanguageId() {
		return languageId;
	}
	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}
	public Integer getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(Integer rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public Double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(Double rentalRate) {
		this.rentalRate = rentalRate;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Double getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(Double replacementCost) {
		this.replacementCost = replacementCost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSpecialFeature() {
		return specialFeature;
	}
	
	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public void setSpecialFeature(String specialFeature) {
		this.specialFeature = specialFeature;
	}
	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Film))
			return false;
		Film other = (Film) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear
				+ ", languageId=" + languageId + ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate
				+ ", length=" + length + ", replacementCost=" + replacementCost + ", rating=" + rating
				+ ", specialFeature=" + specialFeature + ", language=" + language + ", category=" + category + "]";
	}


	

	
	

	
}
                                                                                                                           