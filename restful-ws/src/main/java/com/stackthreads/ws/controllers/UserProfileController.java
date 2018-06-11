package com.stackthreads.ws.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.aspectj.weaver.AjAttribute.MethodDeclarationLineNumberAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stackthreads.ws.beans.UserProfile;
import com.stackthreads.ws.components.UserProfileService;
import com.stackthreads.ws.exceptions.UserNotFound;

@RestController
public class UserProfileController {

	@Autowired
	UserProfileService users;

	/**
	 * Get all user list
	 * 
	 * @return
	 */
	// @RequestMapping(method=RequestMethod.GET, path="/")
	// or
	@GetMapping(path = "/users")
	public List<UserProfile> getAllUsers() {
		return users.getAllUsers();
	}

	/**
	 * get a specific user
	 * 
	 * @param id
	 * @return
	 * @throws UserNotFound
	 */
	@GetMapping(path = "/users/{id}")
	public UserProfile getUser(@PathVariable int id) throws UserNotFound {
		// path variable is used to get a variable from url
		UserProfile user = users.getUser(id);
		if (user == null) {
			throw new UserNotFound(String.format("No such user found with user id: %d", id));
		}
		return user;
	}

	/**
	 * create user
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserProfile user) {
		/**
		 * @Valid is from javax.validation api, which comes implemented in
		 *        spring-boot-starter-web project. Its used for validating the data
		 *        which is coming to api. This validation will be done in beans using
		 *        annotations provided by javax.validation.contraints package.
		 */
		users.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().fromCurrentRequest().path("/{id}")
				.buildAndExpand(user.getId()).toUri();
		System.out.println(location);
		// return created status for newly created record
		return ResponseEntity.created(location).build();
	}

	/**
	 * update user
	 */
	@PutMapping(path = "/users")
	public Resource<UserProfile> updateUser(@RequestBody UserProfile user) {
		// RequestBody is used to get post body
		/**
		 * HATEOAS: Hypermedia as the engine of application state send the additional
		 * links to user to make other relevant resquest For this, spring-boot-hateoas
		 * dependency has to be added eg: link to all users:
		 * 
		 */
		//whatever business object you want to return, create a resource object for it.
		Resource<UserProfile> resource = new Resource<UserProfile>(user);
		//create links which you want to put
		ControllerLinkBuilder links = linkTo(methodOn(this.getClass()).getAllUsers());
		//add this link to resource
		resource.add(links.withRel("all user link"));
		return resource;
//		return ResponseEntity.accepted().build();
	}

	/**
	 * delete user
	 * 
	 * @throws UserNotFound
	 */
	@DeleteMapping(path = "users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) throws UserNotFound {
		UserProfile user = users.deleteUser(id);
		if (user == null) {
			throw new UserNotFound("No user Found with id " + id + "to be deleted!");
		}
		return ResponseEntity.noContent().build();
	}
}
