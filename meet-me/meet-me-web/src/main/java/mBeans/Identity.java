package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import persistence.Agent;
import persistence.User;
import services.BasicOpsLocal;

@ManagedBean
public class Identity {
	// injection of the dependency
	@EJB
	private BasicOpsLocal basicOpsLocal;
	// the model
	private User user = new User();

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = basicOpsLocal.login(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			if (userLoggedIn instanceof Agent) {
				System.out.println("this is an agent");
			} else {
				System.out.println("this is an member");
			}
			System.out.println("not registred");
		}

		return navigateTo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
