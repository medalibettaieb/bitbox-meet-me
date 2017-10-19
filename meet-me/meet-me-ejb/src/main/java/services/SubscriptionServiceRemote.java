package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Room;
import persistence.User;

@Remote
public interface SubscriptionServiceRemote {
	void assignUserToRoom(User user, Room room);

	void assignRoomToUser(User user, Room room);

	void deleteUserFromRoom(User user);

	void assignSuperviserToRoom(User user, Room room);

	List<Room> matchesRooms(User user);

	List<User> matchesMember(User theNewOne, Room room);

}
