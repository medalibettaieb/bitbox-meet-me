package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Gender;
import persistence.Room;
import persistence.User;

/**
 * Session Bean implementation class ReportingService
 */
@Stateless
public class ReportingService implements ReportingServiceRemote, ReportingServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ReportingService() {
	}

	@Override
	public List<User> findAllMembersByRoom(int idRoom) {
		String jpql = "SELECT u FROM User u WHERE u.roomSubscribedIn.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", idRoom);
		return query.getResultList();
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
