package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
