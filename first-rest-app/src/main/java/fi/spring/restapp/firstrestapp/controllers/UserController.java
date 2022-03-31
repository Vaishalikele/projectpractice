package fi.spring.restapp.firstrestapp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fi.spring.restapp.firstrestapp.dyp.UserDTO;

@RestController
@RequestMapping("/user")
public class UserController {
	
	//QUERY STRING FROMATE
	@GetMapping("/auth")
public Boolean authenticate(@RequestParam("uname") String userName,@RequestParam("pwd")String password)
{
	if(userName.equals("fi")&&password.equals("cdac"))
		return true;
	else
		return 
				false;
	}
	
	
//	// USED TO PATH FORMATE
//	@GetMapping("/{uname}")
//	public String getInfo1(@PathVariable(name = "uname") String userName) {
//		if (userName.equals("fi"))
//			return "fi123";
//		else if (userName.equals("cdac"))
//			return "cdac123";
//		else
//			return "defaule123";
//	}
	
//http://localhost/user/
// AUTO USED FOR ALL DATA USED IN JSON FORMATE 
ArrayList<UserDTO> users = new ArrayList<>();

public UserController() {
	users.add(new UserDTO("vaishu", "vaishu123", "vaishali", "Vaishali@gmail.com"));
	users.add(new UserDTO("vvv", "vv123", "vvvv", "vvv@gmail.com"));
}
@GetMapping("/{uname}")
public UserDTO getInfo(@PathVariable(name="uname") String userName) {
	for(UserDTO objUser:users) {
		if(objUser.getUsername().equals(userName))
			return objUser;
	}
	return null;
}

// USED TO SPECIFIC FORMATE LIKE XML
	@GetMapping(produces= {MediaType.APPLICATION_XML_VALUE},path="/{uname}")
	public UserDTO getInfo2(@PathVariable(name="uname") String userName) {
for(UserDTO objUser: users) {
	if(objUser.getUsername().equals(userName))
		return objUser;
}
	return null;	
	}
	
	// INsert new user Query
	@PostMapping("/newuser")
	public String newUser(@Valid @RequestBody UserDTO objUser) 
	{
		
	System.out.println(objUser.getUsername());
	System.out.println(objUser.getPassword());
	System.out.println(objUser.getName());
	System.out.println(objUser.getEmail());
		return objUser.getEmail();	
	}

	//Display all in table used Query
	@GetMapping("/all")
	public List<UserDTO> getAll()
	{
		return users;
	}
	//Validation 
	@GetMapping(produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},path="/{uname}")
	public ResponseEntity<UserDTO> getInfo3(@PathVariable(name="uname") String userName) {
for(UserDTO objUser: users) {
	if(objUser.getUsername().equals(userName))
		return new ResponseEntity<>(objUser,HttpStatus.OK);
}
	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);	
	}
}

