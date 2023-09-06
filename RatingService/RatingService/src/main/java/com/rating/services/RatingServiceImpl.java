package com.rating.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entities.Rating;
import com.rating.repo.RatingRepo;
@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
	private RatingRepo ratingRepo;

	@Override
	public Rating create(Rating rating) {
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserID(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelID(String hotelId) {
	 return ratingRepo.findByHotelId(hotelId);
	}

}
