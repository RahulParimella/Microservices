package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Hotel;
import com.example.demo.service.HotelService;


@RestController
@RequestMapping("/api")
public class HotelController {

	@Autowired
	private HotelService service;
	
	@PostMapping("/hotel")
	public Hotel addHotel(@RequestBody Hotel hotel) {
		return service.createHotel(hotel);
		
	}
	
	@GetMapping("/hotel")
	public List<Hotel> getHotels(){
		List<Hotel> htl=service.getAllHotels();
		return htl;
	}
	
	@GetMapping("/hotel/{id}")
	public Hotel getHotel(@PathVariable int id) {
		return service.getHotel(id);
		
	}
	
	@DeleteMapping("/hotel/{id}")
	public String delete(@PathVariable int id) {
		return service.deleteHotel(id);
	}
}

