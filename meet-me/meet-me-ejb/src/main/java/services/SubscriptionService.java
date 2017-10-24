package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.Hobby;
import persistence.Member;
import persistence.Room;
import persistence.User;
import utilities.Statistics;

/**
 * Session Bean implementation class SubscriptionService
 */
@Stateless
public class SubscriptionService implements SubscriptionServiceRemote, SubscriptionServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private ReportingServiceLocal reportingServiceLocal;
	@EJB
	private BasicOpsLocal basicOpsLocal;

	/**
	 * Default constructor.
	 */
	public SubscriptionService() {
	}

	@Override
	public void assignUserToRoom(User user, Room room) {
		List<User> oldMembers = reportingServiceLocal.findAllMembersByRoom(room.getId());

		oldMembers.add(user);
		room.linkUsersToThisRoom(oldMembers);

		basicOpsLocal.updateRoom(room);

	}

	@Override
	public void assignRoomToUser(User user, Room room) {
		user.setRoomSubscribedIn(room);

		basicOpsLocal.updateUser(user);

	}

	@Override
	public void deleteUserFromRoom(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignSuperviserToRoom(User user, Room room) {
		room.setSuperviser(user);

		basicOpsLocal.updateRoom(room);

	}

	@Override
	public List<Room> matchesRooms(User user) {
		List<Room> rooms = basicOpsLocal.findAllRooms();

		for (Room r : rooms) {
			for (Hobby h : Hobby.values()) {
				getAverageByHobbyByRoom(r, h);
			}
		}
		return null;
	}

	public Double getAverageByHobbyByRoom(Room room, Hobby hobby) {
		List<User> memebers = room.getMembers();
		if (memebers != null) {
			double[] hobbiesValuesByMember = new double[memebers.size()];
			for (User u : memebers) {
				hobbiesValuesByMember[memebers.indexOf(u)] = ((Member) u).getHobbiesValues().get(hobby);

			}
			Statistics statistics = new Statistics(hobbiesValuesByMember);
			Double double1 = statistics.getStdDev() * 100;

			System.out.println(double1.intValue());
			return (double) double1.intValue();
		}
		System.out.println("empty");
		return 100D;

	}

	@Override
	public List<User> matchesMember(User theNewOne, Room room) {
		// TODO Auto-generated method stub
		return null;
	}

}
