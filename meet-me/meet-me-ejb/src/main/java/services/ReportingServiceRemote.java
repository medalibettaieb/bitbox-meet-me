package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Gender;
import persistence.ResquestStatus;
import persistence.Room;
import persistence.SubscriptionRequest;
import persistence.User;

@Remote
public interface ReportingServiceRemote {
	List<User> findAllMembersByRoom(int idRoom);

	List<User> findAllMembersByGender(Gender gender);

	Room findMostPopularRoom();
	
	List<User> findMembersRequestingThisRoom(Room room);
	
	List<SubscriptionRequest> findSubscriptionRequestsByStatus(ResquestStatus status);
	
	
	
}
