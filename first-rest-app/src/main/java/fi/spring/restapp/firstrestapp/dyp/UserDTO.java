package fi.spring.restapp.firstrestapp.dyp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {
	@NotNull(message="Username cannot be null")
String Username;
	@NotNull(message="Password cannot be null")
	@Size(min=3,max=8)
String Password;
	@NotNull(message=" Name cannot be null")
String Name;
	@NotNull(message="user Email cannot be null")
	@Email(message="check your email formate")
String Email;
public UserDTO() {
	
}
public UserDTO(String username, String password, String name, String email) {
	super();
	Username = username;
	Password = password;
	Name = name;
	Email = email;
}
public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}

}
