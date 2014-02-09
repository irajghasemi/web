package se.guards.velocitymail;

import se.guard.User;

public interface VelocityEmailRepository
{
	public void sendLostPasswordEmail(final User user, final String action);
}
