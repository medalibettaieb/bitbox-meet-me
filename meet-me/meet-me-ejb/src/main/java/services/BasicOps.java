package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Room;
import persistence.User;

/**
 * Session Bean implementation class BasicOps
 */
@Stateless
public class BasicOps implements BasicOpsRemote, BasicOpsLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public BasicOps() {
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(user);
	}

	@Override
	public User findUserById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public void deleteUserById(int id) {
		entityManager.remove(findUserById(id));
	}

	@Override
	public List<User> findAllUsers() {
		String jpql = "SELECT u FROM User u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public void addRoom(Room room) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRoom(Room room) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRoom(Room room) {
		// TODO Auto-generated method stub

	}

	@Override
	public Room findRoomById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> findAllRooms() {
		// TODO Auto-generated method stub
		return null;
	}

}
