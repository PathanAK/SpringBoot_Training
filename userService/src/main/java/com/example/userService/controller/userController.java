package com.example.userService.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userService.service.UsersServices;
import com.example.userService.user.UserData;

@RestController
public class userController {
	
	@Autowired
	UsersServices service;
	

	@GetMapping(value = "/greet", produces = MediaType.TEXT_PLAIN_VALUE )
	public ResponseEntity<String> greet() {
		return new ResponseEntity<String>("<h1>Hello Welcome!!</h1>", HttpStatus.OK);
	}
	
	@GetMapping(value = "/users")
	public ResponseEntity<ArrayList<UserData>> getUsers() {
		return new ResponseEntity<ArrayList<UserData>>(service.getUsers(),  HttpStatus.OK);
	}
	
	@GetMapping(value = "/user/{uid}")
	public ResponseEntity<UserData> getUserById(@PathVariable int uid) {
		return new ResponseEntity<UserData>(service.getUserById(uid), HttpStatus.OK);
	}
	
	@GetMapping(value = "/username/{uname}")
	public ResponseEntity<UserData> getUserByName(@PathVariable String uname) {
		return new ResponseEntity<UserData>(service.getUserByName(uname), HttpStatus.OK);
	}
	
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserData> insertUser(@RequestBody UserData usr) {
		return new ResponseEntity<UserData>(service.insertUser(usr), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/update/{uid}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserData> updateUser(@PathVariable int uid, @RequestBody UserData usr) {
		return new ResponseEntity<UserData>(service.updateUser(uid, usr), HttpStatus.CREATED);
	
	}
	
	@DeleteMapping("delete/{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable int uid) {
		return new ResponseEntity<String>(service.deleteUser(uid), HttpStatus.ACCEPTED);
	}
}
