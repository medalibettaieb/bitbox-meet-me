package gui;

import java.awt.Color;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Room;
import services.BasicOpsRemote;

public class TestAddRoom {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("meet-me-ear/meet-me-ejb/BasicOps!services.BasicOpsRemote");

		Room room = new Room();
		room.setColor(new Color(255, 255, 0));
		room.setNumber(90);

		basicOpsRemote.addRoom(room);
	}

}
