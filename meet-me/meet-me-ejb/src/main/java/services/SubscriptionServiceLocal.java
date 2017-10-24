package services;

import java.util.Date;

import javax.ejb.Local;

import persistence.ResquestStatus;
import persistence.Room;
import persistence.SubscriptionRequest;
import persistence.User;

@Local
public interface SubscriptionServiceLocal {
	void assignUserToRoom(User user, Room room);

	void assignRoomToUser(User user, Room room);

	void deleteUserFromRoom(User user);

	void assignSuperviserToRoom(User user, Room room);

	void requestForSubscription(User member, Room room);
	
	SubscriptionRequest findSubscriptionRequestById(User user, Room room, Date date);
	
	void requestTreatement(User user, Room room, Date date, ResquestStatus status);
}
