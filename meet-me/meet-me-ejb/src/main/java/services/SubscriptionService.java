package services;

import javax.ejb.Stateless;

import persistence.Room;
import persistence.User;

/**
 * Session Bean implementation class SubscriptionService
 */
@Stateless
public class SubscriptionService implements SubscriptionServiceRemote, SubscriptionServiceLocal {

	/**
	 * Default constructor.
	 */
	public SubscriptionService() {
	}

	@Override
	public void assignUserToRoom(User user, Room room) {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignRoomToUser(User user, Room room) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserFromRoom(User user) {
		// TODO Auto-generated method stub

	}

}
