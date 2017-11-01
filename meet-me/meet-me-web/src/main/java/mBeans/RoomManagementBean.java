package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import persistence.Room;
import services.BasicOpsLocal;

@ManagedBean
public class RoomManagementBean {
	@EJB
	private BasicOpsLocal basicOpsLocal;
	private List<Room> rooms=new ArrayList<>();
	@PostConstruct
	public void init() {
		rooms=basicOpsLocal.findAllRooms();
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
}
