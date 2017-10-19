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
		Room room = basicOpsLocal.findRoomById(1);
		Hobby hobby = Hobby.MUSIC;
		getAverageByHobbyByRoom(room, hobby);
		return null;
	}

	public Float getAverageByHobbyByRoom(Room room, Hobby hobby) {
		List<User> memebers = room.getMembers();
		if (memebers != null) {
			int[] hobbiesValuesByMember = new int[memebers.size()];
			for (User u : memebers) {

				hobbiesValuesByMember[memebers.indexOf(u)] = ((Member) u).getHobbiesValues().get(hobby);
				System.out.println("the member " + ((Member) u).getName() + "and the score is :"
						+ hobbiesValuesByMember[memebers.indexOf(u)]);
			}
		}

		return null;

	}

	@Override
	public List<User> matchesMember(User theNewOne, Room room) {
		// TODO Auto-generated method stub
		return null;
	}

}
