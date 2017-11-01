package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistence.Agent;
import persistence.User;
import services.BasicOpsLocal;

@ManagedBean
@SessionScoped
public class Identity {
	// injection of the dependency
	@EJB
	private BasicOpsLocal basicOpsLocal;
	// the model
	private User user = new User();

	public String doLogin() {
		String navigateTo = "/horror?faces-redirect=true";
		User userLoggedIn = basicOpsLocal.login(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			user=userLoggedIn;
			if (userLoggedIn instanceof Agent) {
				navigateTo = "/pages/agentHome/home?faces-redirect=true";
			} else {
				navigateTo = "/pages/memberHome/home?faces-redirect=true";
			}
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
