package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Room;
import services.BasicOpsRemote;

public class TestFindRoomById {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("meet-me-ear/meet-me-ejb/BasicOps!services.BasicOpsRemote");

		Room room = basicOpsRemote.findRoomById(1);

		System.out.println(room.getMembers().get(0).getName());
	}

}
