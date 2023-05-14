package com.example.userService.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.userService.exceptions.UserNotFoundException;
import com.example.userService.user.UserData;

@Component
public class UsersServices {
	
	ArrayList<UserData> ui = new ArrayList<>();
	
	public UsersServices () {
		ui.add(new UserData(1,"Asif","Vijayawada"));
		ui.add(new UserData(2,"Ameer","Hyderabad"));
		ui.add(new UserData(3,"Radha","Guntur"));
		ui.add(new UserData(4,"Subbu","Channai"));
		ui.add(new UserData(5,"Bannu","Vizag"));
		ui.add(new UserData(6,"Sai","Hayward"));
	}
	
	public ArrayList<UserData> getUsers() {
		
		return ui;
	}
	
	public UserData getUserById( int uid) {
		return ui.stream()
				.filter(u->u.getUid()==uid)
				.findFirst()
				.orElseThrow(() -> new UserNotFoundException("User not Found with id "+uid));
	}
	
	public UserData getUserByName(String uname) {
		return ui.stream()
				.filter(u->u.getUname().equals(uname))
				.findFirst().
				orElseThrow(()-> new UserNotFoundException("User not Found with name "+ uname));
	}
	
	public UserData insertUser(UserData usr) {
		
		ui.add(usr);
		
		return this.getUserById(usr.getUid());
	}
	
	public UserData updateUser(int uid,  UserData usr) {
		
		UserData existing = this.getUserById(uid);
		
		if(usr.getUname()!=null)
			existing.setUname(usr.getUname());
		if(usr.getAddress()!=null)
			existing.setAddress(usr.getAddress());
		
		return existing;
	
	}
	
	public String deleteUser(int uid) {
		
		UserData existed = this.getUserById(uid);
		
		ui.remove(existed);
		
		return "User deleted with id : "+ uid;
	}
	
}
