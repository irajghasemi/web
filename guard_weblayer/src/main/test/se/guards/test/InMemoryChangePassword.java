package se.guards.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.memory.InMemoryDaoImpl;

public class InMemoryChangePassword extends InMemoryDaoImpl implements IChangePassword
{
	
	IChangePassword changePasswordDao;

	@Override
	public void changePassword(String username, String password)
	{
		User userDetails =
				(User) getUserMap().getUser(username);
				// create a new UserDetails with the new password
				User newUserDetails =
				new User(userDetails.getUsername(),password,
				userDetails.isEnabled(),
				userDetails.isAccountNonExpired(),
				userDetails.isCredentialsNonExpired(),
				userDetails.isAccountNonLocked(),
				userDetails.getAuthorities());
				// add to the map
				getUserMap().addUser(newUserDetails);
				}	

}
