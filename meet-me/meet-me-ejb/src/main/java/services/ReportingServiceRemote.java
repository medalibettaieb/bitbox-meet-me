package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Gender;
import persistence.Room;
import persistence.User;

@Remote
public interface ReportingServiceRemote {
	List<User> findAllMembersByRoom(int idRoom);

	List<User> findAllMembersByGender(Gender gender);

	Room findMostPopularRoom();
}
