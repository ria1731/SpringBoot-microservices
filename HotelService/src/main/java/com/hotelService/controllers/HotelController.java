package com.hotelService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelService.entities.Hotel;
import com.hotelService.services.HotelService;



@RestController
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
	private HotelService hotelService;
		
	//create
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel hotel1=hotelService.create(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
	}

	//single user get
	@PreAuthorize("hasAuthourity('SCOPE_internal')")
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getSingleUser(@PathVariable String id){
		Hotel hotel=hotelService.get(id);
		return ResponseEntity.ok(hotel);
	}

	//all user get
	@PreAuthorize("hasAuthourity('SCOPE_internal')|| hasAuthority('Admin')")
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll(){
		List<Hotel> allHotel=hotelService.getAll();
		return ResponseEntity.ok(allHotel);
	}
		
		
	}

