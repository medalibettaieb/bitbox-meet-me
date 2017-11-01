package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import persistence.Gender;
import persistence.Member;
import persistence.User;
import services.BasicOpsLocal;

@ManagedBean
public class UserManagementBean {
	@EJB
	private BasicOpsLocal basicOpsLocal;
	private User user = new User();
	private Member member = new Member();
	private String gender;

	public String doSaveOrUpdateUser() {
		basicOpsLocal.saveOrUpdateUser(user);
		return "";
	}

	public String doSaveOrUpdateMember() {
		if (gender.equalsIgnoreCase("MALE")) {
			member.setGender(Gender.MALE);
		} else if (gender.equalsIgnoreCase("FEMALE")) {
			member.setGender(Gender.FEMALE);
		}

		basicOpsLocal.saveOrUpdateUser(member);
		return "";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
