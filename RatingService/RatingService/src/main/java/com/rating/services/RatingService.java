package com.rating.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rating.entities.Rating;

@Service
public interface RatingService {
//create
Rating create(Rating rating);	
// get all rating
List<Rating> getRatings();	
// get all by user
List<Rating> getRatingByUserID(String userId);	
// get all by hotel	
	
List<Rating> getRatingByHotelID(String hotelId);		
}
