package persistence;

import java.io.Serializable;
import javax.persistence.*;
import persistence.User;

/**
 * Entity implementation class for Entity: Member
 *
 */
@Entity

public class Member extends User implements Serializable {

	private Gender gender;
	private static final long serialVersionUID = 1L;

	public Member() {
		super();
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
   
}
