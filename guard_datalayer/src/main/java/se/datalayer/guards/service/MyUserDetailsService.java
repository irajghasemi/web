package se.datalayer.guards.service;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.datalayer.guards.main.PersonRepository;
import se.datalayer.guards.repository.UserRepository;
import se.guard.User;

@Service("MyUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    private UserRepository userRepository;
    
    private PersonRepository pr;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException, DataAccessException {
        if ((email == null) || email.trim().isEmpty()) {
            throw new UsernameNotFoundException("Email is null or empty");
        }

        logger.debug("Checking  users with email: " + email);

        Collection<User> userList = userRepository.findUserByEmail(email);
        User us= pr.findByEmail(email);

//        if (userList == null) {
        if (us == null) {
            String errorMsg = "User with email: " + email + " could not be found";
            logger.debug(errorMsg);
            throw new UsernameNotFoundException(errorMsg);
        }
        
        for (User user : userList)
		{
			

        Collection<GrantedAuthority> grantedAuthorities = toGrantedAuthorities(user.getRoleNames());
        String password = user.getPassword();
        boolean enabled = user.getIsEnabled();
        boolean userNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean userNonLocked = true;

        return new org.springframework.security.core.userdetails.User(email, password, enabled, userNonExpired, credentialsNonExpired, userNonLocked,
                grantedAuthorities);
		}
		return null;

    }

    public static Collection<GrantedAuthority> toGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> result = newArrayList();

        for (String role : roles) {
            result.add(new SimpleGrantedAuthority(role));
        }

        return result;
    }
}
                       