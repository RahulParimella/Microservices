package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Hotel;

public interface HotelService {
	
	Hotel createHotel(Hotel hotel);
	List<Hotel> getAllHotels();
	Hotel getHotel(int id);
	String deleteHotel(int id);
}

