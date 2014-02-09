package se.datalayer.guards.repository;

import java.util.Collection;

import se.guard.Blockee;

public interface BlockeeRepository
{

	Blockee addUserToBlockee(Blockee blockee);

	void deleteUserFromBlockee(Blockee blockee);

	Collection<Blockee> showBlockee();

	Blockee findBlockee_ByBlockeeId(int blocker_id);

	Blockee findBlockee_ByBlockerId_And_BlockedId(int blocker_id, int blocked_id);

	boolean checkIf_BlockerAndBlocked_Exist(int blocker_id, int blocked_id);

//	Collection<Blockee> findBlockee_ByNayValue(String anyvalue);

}
