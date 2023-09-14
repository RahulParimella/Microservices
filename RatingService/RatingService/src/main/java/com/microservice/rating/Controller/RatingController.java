package com.microservice.rating.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.rating.Service.RatingService;
import com.microservice.rating.entity.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	//create rating
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		 return new ResponseEntity<>(ratingService.create(rating), HttpStatus.CREATED);		
	}
	
	
	//getall ratings
	@GetMapping
	public ResponseEntity<List<Rating>> getRatings(){
		return ResponseEntity.ok(ratingService.getRatings());
		
	}
	
	//getallbyuserid
		@GetMapping("users/{userId}")
		public ResponseEntity<List<Rating>> getRatingsByUserId(String userId){
			return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
			
		}
		
		//getallbyhotelid
		@GetMapping("/hotels/{hotelId}")
		public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
			return ResponseEntity.ok(ratingService.getRatingByUserId(hotelId));
			
		}
	
}
