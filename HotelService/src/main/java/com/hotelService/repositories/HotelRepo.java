package com.hotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelService.entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel,String>{

}
