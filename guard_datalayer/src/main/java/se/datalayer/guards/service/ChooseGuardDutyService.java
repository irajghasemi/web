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

import se.datalayer.guards.repository.ChooseGuardDutyRepository;
import se.guard.ChooseGuardDuty;
import se.guard.User;

@Service
public class ChooseGuardDutyService implements ChooseGuardDutyRepository
{

	@Autowired
	private ChooseGuardDutyRepository pickingServiceRepository;
	@Autowired
	private AdminCalendarService dateAndTimeService;
	@Autowired
	private BlockeeService blockeeService;

	@PersistenceContext(unitName = "PickingDatesAndTimesService")
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("guards");

	@PersistenceContext(unitName = "PickingDatesAndTimesService")
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ChooseGuardDuty addPickedService(ChooseGuardDuty pickingsDates)
	{
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(pickingsDates);
		entityManager.getTransaction().commit();

		return pickingsDates;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public ChooseGuardDuty updatePickedService(ChooseGuardDuty pickingsDates)
	{
		entityManager.getTransaction().begin();
		entityManager.merge(pickingsDates);
		entityManager.getTransaction().commit();

		return pickingsDates;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public ChooseGuardDuty getPickingServiceByUserId(int user_id)
	{
		TypedQuery<ChooseGuardDuty> query = entityManager.createQuery("from ChooseGuardDuty where USER_ONE_ID=:id OR USER_TOW_ID=:id", ChooseGuardDuty.class);
		entityManager.getTransaction().begin();
		query.setParameter("id", user_id);
		ChooseGuardDuty getpickedServiceBy_User_Id = query.getSingleResult();
		entityManager.getTransaction().commit();
		return getpickedServiceBy_User_Id;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public ChooseGuardDuty get_SingelPickedServiceById(int pickingsDates_id)
	{
		TypedQuery<ChooseGuardDuty> query = entityManager.createQuery("from ChooseGuardDuty where USER_PICKED_DATE_ID=:id", ChooseGuardDuty.class);
		entityManager.getTransaction().begin();
		query.setParameter("id", pickingsDates_id);
		ChooseGuardDuty getpickedServiceBy_Id = query.getSingleResult();
		entityManager.getTransaction().commit();
		return getpickedServiceBy_Id;
	}

	@Transactional(readOnly = true, propagation =  Propagation.SUPPORTS)
	public ChooseGuardDuty getSingelPickedServiceByDateAndTime_id(int dateAndTime_id)
	{
		entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<ChooseGuardDuty> query = entityManager.createQuery("from ChooseGuardDuty where DATEANDTIME_ID=:id", ChooseGuardDuty.class);
		entityManager.getTransaction().begin();
		query.setParameter("id", dateAndTime_id);
		entityManager.getTransaction().commit();
		return query.getSingleResult();
		
	}
	
	
	

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Collection<ChooseGuardDuty> getAllPickedDates()
	{
		TypedQuery<ChooseGuardDuty> query = entityManager.createQuery("from ChooseGuardDuty", ChooseGuardDuty.class);
		entityManager.getTransaction().begin();
		Collection<ChooseGuardDuty> getAllPickedDate = query.getResultList();
		entityManager.getTransaction().commit();
		return getAllPickedDate;
	}

	public boolean removePickedDates(int id)
	{
		TypedQuery<ChooseGuardDuty> query = entityManager.createNamedQuery("from ChooseGuardDuty where USER_PICKED_ID=:id", ChooseGuardDuty.class);
		ChooseGuardDuty result = query.getSingleResult();
		if (!result.equals(null))
		{
			query.setParameter("id", id);
			ChooseGuardDuty remove = query.getSingleResult();
			entityManager.remove(remove);
			entityManager.getTransaction().commit();
			return true;
		}
		else

			return false;
	}

	public Collection<ChooseGuardDuty> getAllPickedServicesByUser(User user)
	{

		TypedQuery<ChooseGuardDuty> query = entityManager.createQuery("from ChooseGuardDuty", ChooseGuardDuty.class);
		entityManager.getTransaction().begin();
		Collection<ChooseGuardDuty> result = query.getResultList();
		entityManager.getTransaction().commit();

		return result;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Collection<ChooseGuardDuty> getPickedServiceByEmail(String email)
	{
		String q = "SELECT o FROM ChooseGuardDuty o LEFT JOIN o.userOne s  LEFT JOIN o.userTwo p WHERE s.email=:email OR p.email=:email";
		TypedQuery<ChooseGuardDuty> query = entityManager.createQuery(q, ChooseGuardDuty.class);
		entityManager.getTransaction().begin();
		query.setParameter("email", email);
		entityManager.getTransaction().commit();
		return query.getResultList();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Collection<ChooseGuardDuty> getPickedServiceByCivicRegNumber(String civicnumber)
	{
		String queryString = "SELECT o FROM ChooseGuardDuty o LEFT JOIN o.userOne s  LEFT JOIN o.userTwo p WHERE s.civicnumber=:civicnumber OR p.civicnumber=:civicnumber";
		TypedQuery<ChooseGuardDuty> query = entityManager.createQuery(queryString, ChooseGuardDuty.class);
		entityManager.getTransaction().begin();
		query.setParameter("civicnumber", civicnumber);
		entityManager.getTransaction().commit();
		return query.getResultList();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Collection<ChooseGuardDuty> getPickingService_ByUser_Ids(int userIdOne, int userIdTwo)
	{
		TypedQuery<ChooseGuardDuty> query = entityManager.createQuery("from ChooseGuardDuty where USER_ONE_ID=:userIdOne AND USER_TWO_ID=:userIdTwo",
				ChooseGuardDuty.class);
		entityManager.getTransaction().begin();
		query.setParameter("userIdOne", userIdOne);
		query.setParameter("userIdTwo", userIdTwo);
		entityManager.getTransaction().commit();
		return query.getResultList();
	}

	public boolean doesTheUseralreadyExistForBookingServiceInDB(User user)
	{

		String queryString = "SELECT u FROM ChooseGuardDuty u";
		TypedQuery<ChooseGuardDuty> query = entityManager.createQuery(queryString, ChooseGuardDuty.class);
		entityManager.getTransaction().begin();
		Collection<ChooseGuardDuty> list = query.getResultList();
		for (ChooseGuardDuty exist : list)
		{

			User userone = exist.getUserOne();
			User usertwo = exist.getUserTwo();

			if (user.equals(userone) || (user.equals(usertwo)))
			{
				return true;
			}

		}
		entityManager.getTransaction().commit();

		return false;
	}

	public Collection<ChooseGuardDuty> checkIfUserAlreadyBookedTheSameService(int serviceId, int userId)
	{
		String queryString = "SELECT o FROM ChooseGuardDuty o LEFT JOIN o.userOne s  LEFT JOIN o.userTwo p WHERE o.pickedService_id=:serviceId OR s.userid=:userId OR p.userid=:userId";

		TypedQuery<ChooseGuardDuty> query = entityManager.createQuery(queryString, ChooseGuardDuty.class);
		entityManager.getTransaction().begin();
		query.setParameter("serviceId", serviceId);
		query.setParameter("userId", userId);
		Collection<ChooseGuardDuty> list = query.getResultList();

		if (!list.isEmpty())
		{
			for (ChooseGuardDuty doexist : list)
			{

				Integer idFromDb = doexist.getPickedService_id();
				Integer userIdFromInput = userId;
				User userOneFromDB = doexist.getUserOne();
				User userTwoFromDB = doexist.getUserTwo();

				if (idFromDb.equals(serviceId) && (userIdFromInput.equals(userOneFromDB.getUserid()) || userIdFromInput.equals(userTwoFromDB.getUserid())))
				{
					return list;
				}

			}
		}

		return list;
	}

	public boolean checkIfUserWantsToBookTheSameServiceTwise(int dateAndTimeId, int userId)
	{
		String queryString = "SELECT o FROM ChooseGuardDuty o LEFT JOIN o.userOne s  LEFT JOIN o.userTwo p WHERE o.dateAndTime.dateAndTime_id=:dateAndTimeId OR s.userid=:userId OR p.userid=:userId";

		TypedQuery<ChooseGuardDuty> query = entityManager.createQuery(queryString, ChooseGuardDuty.class);
		entityManager.getTransaction().begin();
		query.setParameter("dateAndTimeId", dateAndTimeId);
		query.setParameter("userId", userId);
		Collection<ChooseGuardDuty> list = query.getResultList();
		if (!list.isEmpty())
		{
			for (ChooseGuardDuty doexist : list)
			{
				Integer dateAndTimeIdFromDb = doexist.getDateAndTime().getDateAndTime_id();

				Integer userIdFromInput = userId;
				Integer userOneIdFromDB = doexist.getUserOne().getUserid();
				Integer userTwoIdFromDB = doexist.getUserTwo().getUserid();

				if (dateAndTimeIdFromDb.equals(dateAndTimeId) && ((userOneIdFromDB.equals(userIdFromInput) || userTwoIdFromDB.equals(userIdFromInput))))
				{
					return true;
				}

			}
		}

		return false;
	}

	public Collection<ChooseGuardDuty> getAllPickedServiceByDateAndTime_id(int dateAndTimeId)
	{
		entityManager = entityManagerFactory.createEntityManager();
		String queryString = "SELECT d FROM ChooseGuardDuty  d WHERE d.dateAndTime.dateAndTime_id=:dateAndTimeId ";

		TypedQuery<ChooseGuardDuty> query = entityManager.createQuery(queryString, ChooseGuardDuty.class);
		entityManager.getTransaction().begin();
		query.setParameter("dateAndTimeId", dateAndTimeId);
		entityManager.getTransaction().commit();

		return query.getResultList();
	}

	public boolean checkIfTheGuardDutyExistBydateId(int dateAndTimeId)
	{
		entityManager = entityManagerFactory.createEntityManager();
		String queryString = "SELECT d FROM ChooseGuardDuty  d WHERE d.dateAndTime.dateAndTime_id=:dateAndTimeId ";
		TypedQuery<ChooseGuardDuty> query = entityManager.createQuery(queryString, ChooseGuardDuty.class);
		entityManager.getTransaction().begin();
		query.setParameter("dateAndTimeId", dateAndTimeId);
		Collection<ChooseGuardDuty> list = query.getResultList();

		if (!list.isEmpty())
		{
			for (ChooseGuardDuty doexist : list)
			{
				Integer id=doexist.getDateAndTime().getDateAndTime_id();
				if(id.equals(dateAndTimeId)){
					return true;
				}
			}

		}

		return false;
	}
	


}
