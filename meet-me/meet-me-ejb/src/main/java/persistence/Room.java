package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Room
 *
 */
@Entity
@Table(name = "T_ROOM")
public class Room implements Serializable {

	@Id
	private int id;
	private int number;
	private String color;

	@OneToOne
	private User superviser;

	@OneToMany(mappedBy = "roomSubscribedIn", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<User> members;
	private static final long serialVersionUID = 1L;

	public Room() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public User getSuperviser() {
		return superviser;
	}

	public void setSuperviser(User superviser) {
		this.superviser = superviser;
	}

	public void linkUsersToThisRoom(List<User> users) {
		this.members = users;
		for (User u : users) {
			u.setRoomSubscribedIn(this);
		}
	}

}
