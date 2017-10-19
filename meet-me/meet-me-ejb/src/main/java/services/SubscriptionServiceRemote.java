package services;

import javax.ejb.Remote;

import persistence.Room;
import persistence.User;

@Remote
public interface SubscriptionServiceRemote {
	void assignUserToRoom(User user, Room room);

	void assignRoomToUser(User user, Room room);

	void deleteUserFromRoom(User user);

	void assignSuperviserToRoom(User user, Room room);

}
