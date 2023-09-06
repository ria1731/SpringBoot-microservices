package com.hotelService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelService.entities.Hotel;
import com.hotelService.repositories.HotelRepo;
import com.hotelService.exceptions.ResourceNotFoundException;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepo hotelRepo;
	@Override
	public Hotel create(Hotel hotel) {
		String randomID=UUID.randomUUID().toString();
		hotel.setId(randomID);
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel get(String id) {
		return hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with given ID doesn't exists"));
	}

	
	
	
	
	
	
}
