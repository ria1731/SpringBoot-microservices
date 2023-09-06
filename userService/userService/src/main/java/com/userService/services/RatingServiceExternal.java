package com.userService.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.userService.entities.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingServiceExternal {
//get
	
//post
@PostMapping("/ratings")	
public Rating createRating(Rating values);



////put
//@PostMapping("/ratings/{ratingId}")
//public Rating updateRating(@PathVariable("ratingId")String ratingId, Rating rating);
//
//// delete
//@DeleteMapping("rating/{ratingId}")
//public void deleteRating(@PathVariable String ratingId);

}
