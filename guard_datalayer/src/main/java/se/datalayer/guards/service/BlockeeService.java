package se.datalayer.guards.service;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.datalayer.guards.repository.BlockeeRepository;
import se.guard.Blockee;

public class BlockeeService implements BlockeeRepository
{

	@Autowired(required = true)
	private BlockeeService blockeeService;

	@PersistenceContext(unitName = "BlockeeService")
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("guards");

	@PersistenceContext(unitName = "BlockeeService")
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Blockee addUserToBlockee(Blockee blockee)
	{

		entityManager.getTransaction().begin();
		entityManager.merge(blockee);
		entityManager.getTransaction().commit();
		return blockee;

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deleteUserFromBlockee(Blockee blockee)
	{
		entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Blockee> query = entityManager.createQuery("from Blockee where BLOCKEE_ID=:id ", Blockee.class);
		entityManager.getTransaction().begin();
		int blockee_id = blockee.getBlockee_id();
		query.setParameter("id", blockee_id);
		Blockee removeBlockee = query.getSingleResult();
		entityManager.remove(removeBlockee);
		entityManager.getTransaction().commit();

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Collection<Blockee> showBlockee()
	{

		TypedQuery<Blockee> query = entityManager.createQuery("from Blockee ", Blockee.class);
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

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Blockee findBlockee_ByBlockeeId(int blocker_id)
	{
		TypedQuery<Blockee> query = entityManager.createQuery("from Blockee where BLOCKER_ID=:id", Blockee.class);
		if (entityManager.isOpen() != true)
		{
			entityManager.getTransaction().begin();
			query.setParameter("id", blocker_id);
			Blockee blockee = query.getSingleResult();
			entityManager.getTransaction().commit();
			return blockee;
		}
		else
		{

			query.setParameter("id", blocker_id);
			Blockee blockee = query.getSingleResult();
			return blockee;
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Blockee findBlockee_ByBlockerId_And_BlockedId(int blocker_id, int blocked_id)
	{
		TypedQuery<Blockee> query = entityManager.createQuery("from Blockee where BLOCKER_ID=:blcoker_id AND BLOCKED_ID=:blocked_id", Blockee.class);
		if (entityManager.isOpen() != true)
		{
			entityManager.getTransaction().begin();
			query.setParameter("blcoker_id", blocker_id);
			query.setParameter("blocked_id", blocked_id);
			Blockee blockee = query.getSingleResult();
			entityManager.getTransaction().commit();
			return blockee;
		}
		else
		{

			query.setParameter("blcoker_id", blocker_id);
			query.setParameter("blocked_id", blocked_id);
			Blockee blockee = query.getSingleResult();
			return blockee;
		}
	}

	

	public boolean checkIf_BlockerAndBlocked_Exist(int blocker_id, int blocked_id)
	{
		TypedQuery<Blockee> query = entityManager.createQuery("from Blockee where BLOCKER_ID=:blcoker_id AND BLOCKED_ID=:blocked_id", Blockee.class);
		if (entityManager.isOpen() != true)
		{
			entityManager.getTransaction().begin();
			query.setParameter("blcoker_id", blocker_id);
			query.setParameter("blocked_id", blocked_id);
			Blockee blockee = query.getSingleResult();
			if (blockee.equals(true))
			{
				entityManager.getTransaction().commit();
				return true;
			}
		}
		return false;
	}
	
//	@Transactional(propagation = Propagation.REQUIRES_NEW)
//	public Collection<Blockee> findBlockee_ByNayValue(String value)
//	{
//		Collection<Blockee> result = new ArrayList<Blockee>(0);
//
//		if (value == null)
//		{
//			return result;
//		}
//
//		final String searchParam = "%" + value + "%";
//
//		final String query = "SELECT b FROM Blockee b WHERE " + 
//							 "b.firstname like :searchParam" 
//							 + " OR b.firstname like :searchParam"
//							 + " OR b.lastname  like :searchParam" 
//							 + " OR b.username  like :searchParam" 
//							 + " OR b.password  like :searchParam" 
//							 + " OR b.email     like :searchParam"
//							 + " OR b.address.street  like :searchParam" 
//							 + " OR b.address.zipcode  like :searchParam" 
//							 + " OR b.address.city like :searchParam";
//
//		result = entityManager.createQuery(query, Blockee.class).setParameter("searchParam", searchParam).getResultList();
//
//		return result;
//	}

}
