package com.microservice.rating.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.rating.Repository.RatingRepository;
import com.microservice.rating.Service.RatingService;
import com.microservice.rating.entity.Rating;
@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository RatingRepo;

	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		
		return RatingRepo.save(rating) ;
	}

	@Override
	public List<Rating> getRatings() {
		// TODO Auto-generated method stub
		return RatingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return RatingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return RatingRepo.findByHotelId(hotelId);
	}

}
