package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import persistence.User;
import services.BasicOpsLocal;

@ManagedBean
public class UserManagementBean {
	@EJB
	private BasicOpsLocal basicOpsLocal;
	private User user=new User();
	
	public String doSaveOrUpdateUser() {
		basicOpsLocal.saveOrUpdateUser(user);
		return "";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
