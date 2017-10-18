package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Gender;
import persistence.Room;
import persistence.User;

@Local
public interface ReportingServiceLocal {
	List<User> findAllMembersByRoom(int idRoom);

	List<User> findAllMembersByGender(Gender gender);

	Room findMostPopularRoom();
}
