package com.userService.entities;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Rating {

private String ratingId;
private String userId;
private String hotelId;
private int rating;
private String feedback;
private Hotel hotel;
	
}
