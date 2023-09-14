package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.HotelNotFoundException;
import com.example.demo.model.Hotel;
import com.example.demo.repository.HotelRepository;
import com.example.demo.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository repo;

	@Override
	public Hotel createHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		Hotel htl=repo.save(hotel);
		return htl;
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		List<Hotel> htl=repo.findAll();
		return htl;
	}

	@Override
	public Hotel getHotel(int id) {
		// TODO Auto-generated method stub
		Optional<Hotel> htl=repo.findById(id);
		if(htl.isPresent()) {
			return htl.get();
		}
		else {
			throw new HotelNotFoundException("Hotel id not found:"+id);
		}
	}

	@Override
	public String deleteHotel(int id) {
		// TODO Auto-generated method stub
		Optional<Hotel> htl=repo.findById(id);
		if(htl.isPresent()) {
			repo.delete(htl.get());
			return "Deleted successfully";
		}
		else {
			return "Hotel not found";
		}
		
	}

}

