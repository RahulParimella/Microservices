package com.microservice.rating.Service;

import java.util.List;

import com.microservice.rating.entity.Rating;

public interface RatingService {
	//create
	Rating create(Rating rating);
	
	//get all ratings
	List<Rating> getRatings();
	
	//get all by userID
	List<Rating> getRatingByUserId(String userId);
	
	//get all by hotelid
	List<Rating> getRatingByHotelId(String hotelId);

}
