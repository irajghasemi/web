package se.datalayer.guards.repository;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import se.guard.ChooseGuardDuty;
import se.guard.User;

@Repository
public interface ChooseGuardDutyRepository
{

	ChooseGuardDuty addPickedService(ChooseGuardDuty pickingsDates);

	ChooseGuardDuty updatePickedService(ChooseGuardDuty pickingsDates);

	Collection<ChooseGuardDuty> getAllPickedServicesByUser(User user);

	Collection<ChooseGuardDuty> getAllPickedServiceByDateAndTime_id(int dateAndTime_id);

	ChooseGuardDuty getSingelPickedServiceByDateAndTime_id(int dateAndTime_id);

	Collection<ChooseGuardDuty> checkIfUserAlreadyBookedTheSameService(int serviceId, int userid);

	Collection<ChooseGuardDuty> getPickedServiceByEmail(String email);

	ChooseGuardDuty getPickingServiceByUserId(int user_id);

	Collection<ChooseGuardDuty> getPickingService_ByUser_Ids(int userIdOne, int userIdTwo);

	ChooseGuardDuty get_SingelPickedServiceById(int pickingsDates_id);

	Collection<ChooseGuardDuty> getAllPickedDates();

	boolean checkIfTheGuardDutyExistBydateId(int dateAndTime_id);

	boolean doesTheUseralreadyExistForBookingServiceInDB(User user);

	boolean checkIfUserWantsToBookTheSameServiceTwise(int serviceId, int userid);

	boolean removePickedDates(int id);

}
