package se.datalayer.guards.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.datalayer.guards.repository.UserRepository;
import se.guard.User;

@Service
public class UserService implements UserRepository
{

	@Autowired(required = true)
	private UserRepository userRepository;

	@PersistenceContext(unitName = "UserService")
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("guards");

	@PersistenceContext(unitName = "UserService")
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public User addNewUser(User user)
	{
		if (!doUserExist(user))
		{

			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

			entityManager.merge(user);
			entityManager.getTransaction().commit();
			return user;
		}
		else
		{
			entityManager.merge(user);
			System.out.println("Cant add same user twice!");
			return new User();
		}
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public User updateUser(User user)
	{
		entityManagerFactory.createEntityManager();
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		entityManager.getTransaction().begin();

		entityManager.merge(user);
		entityManager.getTransaction().commit();
		return user;

	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Collection<User> findAllUsers()
	{
		TypedQuery<User> query = entityManager.createQuery("from User ", User.class);
		if (entityManager.isOpen() != true)
		{
			entityManager.getTransaction().begin();
			entityManager.getTransaction().commit();
			return query.getResultList();

		}
		else
		{
			return query.getResultList();

		}
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Collection<User> findUserByUserName(String username)
	{
		TypedQuery<User> query = entityManager.createQuery("from User where  USERNAME =:username", User.class);
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		return query.setParameter("username", username).getResultList();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Collection<User> findUserByFirstName(String firstname)
	{
		TypedQuery<User> query = entityManager.createQuery("from User where  FIRSTNAME =:firstname", User.class);
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		return query.setParameter("firstname", firstname).getResultList();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public User findUserById(int userid)
	{

		TypedQuery<User> query = entityManager.createQuery("from User where USER_ID=:id", User.class);
		if (entityManager.isOpen() != true)
		{
			entityManager.getTransaction().begin();
			query.setParameter("id", userid);
			User user = query.getSingleResult();
			entityManager.getTransaction().commit();
			return user;
		}
		else
		{

			query.setParameter("id", userid);
			User user = query.getSingleResult();
			return user;
		}
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public boolean doUserExist(User user2)
	{
		entityManager = entityManagerFactory.createEntityManager();
		Collection<User> userList = entityManager.createQuery("select u from User u", User.class).getResultList();
		entityManager.getTransaction().begin();
		for (User user : userList)
		{
			if (user.getEmail().equals(user2.getEmail()))
			{
				return true;
			}
		}

		return false;

	}

	public void deleteUser(User user)
	{
		entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<User> query = entityManager.createQuery("from User where USER_ID=:id", User.class);
		entityManager.getTransaction().begin();
		int userId = user.getUserid();
		query.setParameter("id", userId);
		User removeUser = query.getSingleResult();
		entityManager.remove(removeUser);
		entityManager.getTransaction().commit();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Collection<User> findUserByAnyValue(String value)
	{

		List<User> result = new ArrayList<User>(0);
		if (entityManager.isOpen() != true)
		{
			if (value == null)
			{
				return null;
			}

			final String searchParam = "%" + value + "%";

			final String query = "SELECT u FROM User u WHERE " +

			"      u.firstname like :searchParam" + " OR u.firstname like :searchParam" + " OR u.lastname  like :searchParam" + " OR u.username  like :searchParam"
					+ " OR u.password  like :searchParam" + " OR u.civicregnumber  like :searchParam" + " OR u.email  like :searchParam"
					+ " OR u.address.street  like :searchParam" + " OR u.address.zipcode  like :searchParam" + " OR u.address.city like :searchParam";

			result = entityManager.createQuery(query, User.class).setParameter("searchParam", searchParam).getResultList();

			return result;
		}
		return result;

	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Collection<User> findUserByEmail(String email)
	{
		entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<User> query = entityManager.createQuery("from User where EMAIL=?1", User.class);
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		return query.setParameter(1, email).getResultList();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<User> findAll()
	{
		TypedQuery<User> query = entityManager.createQuery("from User ", User.class);
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		return query.getResultList();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public User findUserByFirstname(String firstname)
	{
		entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<User> query = entityManager.createNamedQuery("from User where  FIRSTNAME =?1", User.class);
		entityManager.getTransaction().begin();
		query.setParameter(1, firstname);
		entityManager.getTransaction().commit();
		return query.getSingleResult();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public User findUserByAnyParameter(String value)
	{
		List<User> result = new ArrayList<User>(0);

		User user = new User();

		if (value == null)
		{
			return (User) result;
		}

		final String searchParam = "%" + value + "%";

		final String query = "SELECT u FROM User u WHERE "

		+ "    u.firstname like :searchParam" + " OR u.lastname  like :searchParam" + " OR u.username  like :searchParam" + " OR u.password  like :searchParam"
				+ " OR u.email like :searchParam" + " OR u.civicregnumber like :searchParam" + " OR u.address.street  like :searchParam"
				+ " OR u.address.zipcode  like :searchParam" + " OR u.address.city like :searchParam";

		result = entityManager.createQuery(query, User.class).setParameter("searchParam", searchParam).getResultList();
		for (User user2 : result)
		{
			user = new User(user2.getUserid(), user2.getFirstname(), user2.getLastname(), user2.getUsername(), user2.getPassword(), user2.getEmail(),
					user2.getIsEnabled(), user2.getAddress(), user2.getRoles());
			return user;
		}

		return user;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public User findUserByMail(String email)
	{
		entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<User> query = entityManager.createQuery("from User where EMAIL=?1", User.class);
		entityManager.getTransaction().begin();
		query.setParameter(1, email);
		entityManager.getTransaction().commit();
		return query.getSingleResult();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public User findUserByPassword(String password)
	{
		entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<User> query = entityManager.createQuery("from User where PASSWORD=?1", User.class);
		entityManager.getTransaction().begin();
		query.setParameter(1, password);
		entityManager.getTransaction().commit();
		return query.getSingleResult();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public User findUserByUsername(String username)
	{
		entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<User> query = entityManager.createQuery("from User where  USERNAME =?1", User.class);
		entityManager.getTransaction().begin();
		query.setParameter(1, username);
		entityManager.getTransaction().commit();
		return query.getSingleResult();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Collection<User> findUserByFirstNameLastName(String firstname, String lastname)
	{
		TypedQuery<User> query = entityManager.createQuery("from User where FIRSTNAME=:firstname AND LASTNAME=:lastname", User.class);
		entityManager.getTransaction().begin();
		query.setParameter("firstname", firstname);
		query.setParameter("lastname", lastname);
		entityManager.getTransaction().commit();
		return query.getResultList();
	}

	public Collection<User> findUserByASerachString(String value)
	{
		StringTokenizer st = new StringTokenizer(value, " ");
		List<User> result = new ArrayList<User>(0);
		while (st.hasMoreElements())
		{

			String searchValue = st.hasMoreTokens() ? st.nextToken() : null;

			final String searchParam = "%" + searchValue + "%";
			if (searchValue != null)
			{
				final String query = "SELECT u FROM User u WHERE "

				+ "    u.firstname like :searchParam" + " OR u.lastname  like :searchParam" + " OR u.email  like :searchParam";
				result = entityManager.createQuery(query, User.class).setParameter("searchParam", searchParam).getResultList();
				return result;
			}

			else
			{
				TypedQuery<User> query = entityManager.createQuery("from User where FIRSTNAME=:firstname AND LASTNAME=:lastname", User.class);
				entityManager.getTransaction().begin();
				query.setParameter("firstname", searchValue);
				query.setParameter("lastname", searchValue);
				entityManager.getTransaction().commit();
				return query.getResultList();
			}

		}
		return null;

	}

	public static String encodePasswordWithBCrypt(String plainPassword)
	{

		return new BCryptPasswordEncoder().encode(plainPassword);
	}

	public User findUserByCivicRegistraionNumber(String civicregnumber)
	{
		TypedQuery<User> query = entityManager.createQuery("from User where CIVIC_REG_NUMBER=:civicregnumber", User.class);
		entityManager.getTransaction().begin();
		query.setParameter("civicregnumber", civicregnumber);
		entityManager.getTransaction().commit();
		return query.getSingleResult();
	}

}
