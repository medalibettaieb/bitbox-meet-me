package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import persistence.ResquestStatus;
import persistence.Room;
import persistence.SubscriptionRequest;
import services.BasicOpsLocal;
import services.ReportingServiceLocal;
import services.SubscriptionServiceLocal;

@ManagedBean
@ViewScoped
public class RoomManagementBean {
	@EJB
	private SubscriptionServiceLocal subscriptionServiceLocal;
	@ManagedProperty(value = "#{identity}")
	private Identity identity;
	private List<SubscriptionRequest> subscriptionRequests = new ArrayList<>();
	private List<SubscriptionRequest> subscriptionRequestsByAgent = new ArrayList<>();
	@EJB
	private BasicOpsLocal basicOpsLocal;
	@EJB
	private ReportingServiceLocal reportingServiceLocal;
	private List<Room> rooms = new ArrayList<>();
	private Room room = new Room();
	private Room roomSelected = new Room();
	private Room agentRoom = new Room();
	private SubscriptionRequest subscriptionRequestSelected = new SubscriptionRequest();

	@PostConstruct
	public void init() {
		rooms = basicOpsLocal.findAllRooms();
		subscriptionRequests = subscriptionServiceLocal.findSuscriptionRequestsByMember(identity.getUser());
		agentRoom = identity.getUser().getRoomSupervised();
		subscriptionRequestsByAgent = subscriptionServiceLocal.findSuscriptionRequestsByRoom(agentRoom);
	}

	public String doRequestForSubscription() {
		subscriptionServiceLocal.requestForSubscription(identity.getUser(), roomSelected);
		return "/pages/memberHome/subscriptionSuccess";
	}

	public String doTreatRequest(String status) {
		if (status.equalsIgnoreCase("accepted")) {
			subscriptionServiceLocal.requestTreatement(subscriptionRequestSelected.getMember(),
					subscriptionRequestSelected.getRoom(),
					subscriptionRequestSelected.getSubscriptionId().getDateOfTheRequest(), ResquestStatus.ACCEPTED);
		} else {
			subscriptionServiceLocal.requestTreatement(subscriptionRequestSelected.getMember(),
					subscriptionRequestSelected.getRoom(),
					subscriptionRequestSelected.getSubscriptionId().getDateOfTheRequest(), ResquestStatus.REJECTED);
		}

		return "";
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Room getRoomSelected() {
		return roomSelected;
	}

	public void setRoomSelected(Room roomSelected) {
		this.roomSelected = roomSelected;
	}

	public List<SubscriptionRequest> getSubscriptionRequests() {
		return subscriptionRequests;
	}

	public void setSubscriptionRequests(List<SubscriptionRequest> subscriptionRequests) {
		this.subscriptionRequests = subscriptionRequests;
	}

	public Room getAgentRoom() {
		return agentRoom;
	}

	public void setAgentRoom(Room agentRoom) {
		this.agentRoom = agentRoom;
	}

	public List<SubscriptionRequest> getSubscriptionRequestsByAgent() {
		return subscriptionRequestsByAgent;
	}

	public void setSubscriptionRequestsByAgent(List<SubscriptionRequest> subscriptionRequestsByAgent) {
		this.subscriptionRequestsByAgent = subscriptionRequestsByAgent;
	}

	public SubscriptionRequest getSubscriptionRequestSelected() {
		return subscriptionRequestSelected;
	}

	public void setSubscriptionRequestSelected(SubscriptionRequest subscriptionRequestSelected) {
		this.subscriptionRequestSelected = subscriptionRequestSelected;
	}
}
