package se.guards.test;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface IChangePassword extends UserDetailsService
{

	public void changePassword(String username, String newPassword);

}
