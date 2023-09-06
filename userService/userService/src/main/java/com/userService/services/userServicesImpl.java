package com.userService.services;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userService.entities.Hotel;
import com.userService.entities.Rating;
import com.userService.entities.User;
import com.userService.repo.*;
import com.userService.exception.*;


@Service
public class userServicesImpl implements userServices{
	@Autowired
    private userRepo userRepo;
	@Autowired
	private HotelServiceExternal hotelService;
	@Autowired
	private RestTemplate restTemplate;
	private Logger logger = LoggerFactory.getLogger(userServicesImpl.class);
	@Override
	public User saveUser(User user) {
		String randomID=UUID.randomUUID().toString();
		user.setUserId(randomID);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
		}

	@Override
	public User getUser(String userId) {
		// get user from db
		User user= userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given ID doesn't exists"));
		//fetching ratings from rating service
		Rating[] forObject=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		logger.info("{}",forObject);
		List<Rating> ratings=Arrays.stream(forObject).toList();
		
		List<Rating> ratingList=ratings.stream().map(rating ->{
		//http://localhost:8082/hotels/fd82f34e-3db5-4c1d-9a50-25fa37bedc5a moti mahal
		//ResponseEntity<Hotel> forEntity= restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
		Hotel hotel= hotelService.getHotel(rating.getHotelId());
		//logger.info("response status code: {}",forEntity.getStatusCode());
		rating.setHotel(hotel);
		return rating;	
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		return user;
	}

}
