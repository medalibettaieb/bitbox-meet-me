package gui;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.User;
import services.ReportingServiceRemote;
import services.SubscriptionServiceRemote;

public class TestFindAllMembersByRoom {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context
				.lookup("meet-me-ear/meet-me-ejb/SubscriptionService!services.SubscriptionServiceRemote");
		ReportingServiceRemote reportingServiceRemote = (ReportingServiceRemote) context
				.lookup("meet-me-ear/meet-me-ejb/ReportingService!services.ReportingServiceRemote");

		List<User> members = reportingServiceRemote.findAllMembersByRoom(1);

		System.out.println(members.size());

	}

}
