package se.datalayer.guards.repository;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import se.guard.User;

@Repository
public interface UserRepository
{
	User addNewUser(User user);

	User updateUser(User user);

	Collection<User> findAllUsers();

	Collection<User> findUserByUserName(String username);

	Collection<User> findUserByFirstName(String firstname);

	Collection<User> findUserByFirstNameLastName(String firstname, String lastname);

	Collection<User> findUserByASerachString(String search);

	Collection<User> findUserByAnyValue(String value);

	Collection<User> findUserByEmail(String email);

	User findUserByFirstname(String firstname);

	User findUserByAnyParameter(String value);

	User findUserByMail(String email);

	User findUserByUsername(String username);

	User findUserByCivicRegistraionNumber(String civicnumber);

	User findUserById(int userid);

	void deleteUser(User user);

	boolean doUserExist(User user);
}
