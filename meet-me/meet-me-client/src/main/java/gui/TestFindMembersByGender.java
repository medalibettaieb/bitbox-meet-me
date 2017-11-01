package gui;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Gender;
import persistence.Member;
import persistence.User;
import services.BasicOpsRemote;
import services.ReportingServiceRemote;
import services.SubscriptionServiceRemote;

public class TestFindMembersByGender {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("meet-me-ear/meet-me-ejb/BasicOps!services.BasicOpsRemote");
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context
				.lookup("meet-me-ear/meet-me-ejb/SubscriptionService!services.SubscriptionServiceRemote");
		ReportingServiceRemote reportingServiceRemote = (ReportingServiceRemote) context
				.lookup("meet-me-ear/meet-me-ejb/ReportingService!services.ReportingServiceRemote");

		List<Member> users = reportingServiceRemote.findAllMembersByGender(Gender.FEMALE);

		System.out.println(users.size());

	}

}
