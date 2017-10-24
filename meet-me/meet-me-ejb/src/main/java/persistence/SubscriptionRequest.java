package persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: SubscriptionRequest
 *
 */
@Entity

public class SubscriptionRequest implements Serializable {
	@EmbeddedId
	private SubscriptionId subscriptionId;
	@Enumerated(EnumType.STRING)
	private ResquestStatus stateOfTheRequest;

	@ManyToOne
	@JoinColumn(name = "idMember", referencedColumnName = "id", insertable = false, updatable = false)
	private User member;

	@ManyToOne
	@JoinColumn(name = "idRoom", referencedColumnName = "id", insertable = false, updatable = false)
	private Room room;
	private static final long serialVersionUID = 1L;

	public SubscriptionRequest() {
		super();
	}

	public SubscriptionRequest(User member, Room room) {
		super();
		this.subscriptionId = new SubscriptionId(room.getId(), member.getId());
		this.stateOfTheRequest = ResquestStatus.NEW;
		this.member = member;
		this.room = room;
	}

	public ResquestStatus getStateOfTheRequest() {
		return stateOfTheRequest;
	}

	public void setStateOfTheRequest(ResquestStatus stateOfTheRequest) {
		this.stateOfTheRequest = stateOfTheRequest;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SubscriptionId getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(SubscriptionId subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public User getMember() {
		return member;
	}

	public void setMember(User member) {
		this.member = member;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
