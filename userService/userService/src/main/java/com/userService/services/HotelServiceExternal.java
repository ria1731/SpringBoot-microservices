package com.userService.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userService.entities.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelServiceExternal {
@GetMapping("/hotels/{hotelId}")
Hotel getHotel(@PathVariable("hotelId")String hotelId);	

}
