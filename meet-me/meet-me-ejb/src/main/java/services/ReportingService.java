package services;

import java.util.List;

import javax.ejb.Stateless;

import persistence.Gender;
import persistence.Room;
import persistence.User;

/**
 * Session Bean implementation class ReportingService
 */
@Stateless
public class ReportingService implements ReportingServiceRemote, ReportingServiceLocal {

	/**
	 * Default constructor.
	 */
	public ReportingService() {
	}

	@Override
	public List<User> findAllMembersByRoom(int idRoom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllMembersByGender(Gender gender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room findMostPopularRoom() {
		// TODO Auto-generated method stub
		return null;
	}

}
