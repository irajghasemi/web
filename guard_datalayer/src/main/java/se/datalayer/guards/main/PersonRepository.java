package se.datalayer.guards.main;

import org.springframework.stereotype.Repository;

import se.guard.User;

@Repository
public interface PersonRepository
{
 User findByEmail(String email);
}
