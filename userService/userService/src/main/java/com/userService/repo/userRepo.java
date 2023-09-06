package com.userService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userService.entities.User;

public interface userRepo extends JpaRepository<User,String>{

}
