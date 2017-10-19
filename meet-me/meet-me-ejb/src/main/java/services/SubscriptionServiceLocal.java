package services;

import javax.ejb.Local;

import persistence.Room;
import persistence.User;

@Local
public interface SubscriptionServiceLocal {
	void assignUserToRoom(User user, Room room);

	void assignRoomToUser(User user, Room room);

	void deleteUserFromRoom(User user);

	void assignSuperviserToRoom(User user, Room room);
}
