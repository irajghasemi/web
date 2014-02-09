package se.datalayer.guards.service;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.datalayer.guards.repository.AdminCalendarRepsoitory;
import se.guard.DateAndTime;

@Service
public class AdminCalendarService implements AdminCalendarRepsoitory
{

	@Autowired(required = true)
	private AdminCalendarRepsoitory calendarRepsoitory;

	@PersistenceContext(unitName = "DateAndTimeService")
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("guards");
	@PersistenceContext(unitName = "DateAndTimeService")
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public DateAndTime addService(DateAndTime dateAndTime)
	{
		if (entityManager.isOpen() != true)
		{
			entityManager.getTransaction().begin();
			entityManager.persist(dateAndTime);
			entityManager.getTransaction().commit();
			return dateAndTime;
		}
		else
		{
			entityManager.getTransaction().begin();
			entityManager.persist(dateAndTime);
			entityManager.getTransaction().commit();
			return dateAndTime;
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public DateAndTime updateService(DateAndTime dateAndTime)
	{
		entityManager.getTransaction().begin();
		entityManager.merge(dateAndTime);
		entityManager.getTransaction().commit();

		return dateAndTime;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean removeService(int dateAndTime_id)
	{
		entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<DateAndTime> query = entityManager.createQuery("from DateAndTime where DATEANDTIME_ID=:id", DateAndTime.class);
		entityManager.getTransaction().begin();
		query.setParameter("id", dateAndTime_id);
		DateAndTime removeDateAndTime = query.getSingleResult();
		entityManager.remove(removeDateAndTime);
		entityManager.getTransaction().commit();

		return true;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public DateAndTime getSingelServiceById(int searchDateAndTimeBy_Id)
	{

		TypedQuery<DateAndTime> query = entityManager.createQuery("from DateAndTime where DATEANDTIME_ID=:id ", DateAndTime.class);
		entityManager.getTransaction().begin();
		query.setParameter("id", searchDateAndTimeBy_Id);
		DateAndTime getSingetDateAndTime = query.getSingleResult();
		entityManager.getTransaction().commit();

		return getSingetDateAndTime;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Collection<DateAndTime> getAllDateAndTime()
	{
		TypedQuery<DateAndTime> query = entityManager.createQuery("from DateAndTime", DateAndTime.class);
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();

		return query.getResultList();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Collection<DateAndTime> getService_ByRange(String startDate, String endDate)
	{
		TypedQuery<DateAndTime> query = entityManager.createQuery("from DateAndTime where START_DATE=:startDate OR END_DATE<=:endDate", DateAndTime.class);
		entityManager.getTransaction().begin();
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		Collection<DateAndTime> result = query.getResultList();
		entityManager.getTransaction().commit();

		return result;
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Collection<DateAndTime> getAllServicesFromThisYearAndSoOn(String todaysdate)
	{
		TypedQuery<DateAndTime> query = entityManager.createQuery("from DateAndTime where START_DATE >=:todaysDate", DateAndTime.class);
		entityManager.getTransaction().begin();
		query.setParameter("todaysDate", todaysdate);
		Collection<DateAndTime> result = query.getResultList();
		entityManager.getTransaction().commit();
		
		return result;
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Collection<DateAndTime> getServicesForCurrentYear(String currentYear)
	{
		TypedQuery<DateAndTime> query = entityManager.createQuery("from DateAndTime where START_YEAR_ONLY =:currentYear", DateAndTime.class);
		entityManager.getTransaction().begin();
		query.setParameter("currentYear", currentYear);
		Collection<DateAndTime> result = query.getResultList();
		entityManager.getTransaction().commit();
		
		return result;
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Collection<DateAndTime> getServicesForNextYear(String currentYear)
	{
		TypedQuery<DateAndTime> query = entityManager.createQuery("from DateAndTime where START_YEAR_ONLY >:currentYear", DateAndTime.class);
		entityManager.getTransaction().begin();
		query.setParameter("currentYear", currentYear);
		Collection<DateAndTime> result = query.getResultList();
		entityManager.getTransaction().commit();
		
		return result;
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Collection<DateAndTime> getServicesWhichEndsThisYear(String currentYear)
	{
		TypedQuery<DateAndTime> query = entityManager.createQuery("from DateAndTime where END_YEAR_ONLY =:currentYear", DateAndTime.class);
		entityManager.getTransaction().begin();
		query.setParameter("currentYear", currentYear);
		Collection<DateAndTime> result = query.getResultList();
		entityManager.getTransaction().commit();
		
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Collection<DateAndTime> getService_BetweenTwoDates(String startDate, String endDate)
	{
		TypedQuery<DateAndTime> query = entityManager.createQuery("from DateAndTime where START_DATE=:startDate AND END_DATE=:endDate", DateAndTime.class);
		entityManager.getTransaction().begin();
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		Collection<DateAndTime> result = query.getResultList();
		entityManager.getTransaction().commit();

		return result;
	}

	public boolean doDateAndTimeExist(String startDate, String endDate)
	{
		Collection<DateAndTime> lists = getService_ByRange(startDate, endDate);
		entityManager.getTransaction().begin();

		for (DateAndTime dateAndTime : lists)
		{
			if (dateAndTime.getStartDate().equals(startDate) && dateAndTime.getEndDate().equals(endDate))
			{
				return true;
			}
		}
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Collection<DateAndTime> getAll_Available_Services()
	{

		TypedQuery<DateAndTime> query = entityManager.createQuery("from DateAndTime where  SERVICE_AVAILABLE=?1 ", DateAndTime.class);
		entityManager.getTransaction().begin();
		query.setParameter(1, 1);
		entityManager.getTransaction().commit();
		return query.getResultList();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Collection<DateAndTime> getAll_Occupied_Services()
	{
		TypedQuery<DateAndTime> query = entityManager.createQuery("from DateAndTime where  SERVICE_AVAILABLE=?1 ", DateAndTime.class);
		entityManager.getTransaction().begin();
		query.setParameter(1, 0);
		entityManager.getTransaction().commit();
		return query.getResultList();
	}

}
