package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Gender;
import persistence.Member;
import services.BasicOpsRemote;

public class TestAddUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("meet-me-ear/meet-me-ejb/BasicOps!services.BasicOpsRemote");

		Member member = new Member();
		member.setId(1);
		member.setName("ali");
		member.setGender(Gender.MALE);

		basicOpsRemote.addUser(member);
	}

}
