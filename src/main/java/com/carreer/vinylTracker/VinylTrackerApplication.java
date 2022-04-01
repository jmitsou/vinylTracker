package com.carreer.vinylTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VinylTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VinylTrackerApplication.class, args);
	}

}

//Application checklist:
/*  Entities:
	TODO - Create User entity Done
	TODO - Create Role Entity
	TODO - Create Profile entity
*/
/*Bonus entity
	TODO - Create Content entity
*/
/*Features:
	TODO - can register a user account
	TODO - can log in with existing user account
	TODO - can create a profile with valid authentication
	TODO - can pull profiles with valid authentication
*/
/*Bonus features:
	TODO - can create a content with valid authentication
	TODO - can pull content with valid authentication
	TODO - create one custom query for the content entities repository.
*/
