package training.oneToOneUni;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: C
 *
 */
@Entity

public class C implements Serializable {

	@Id
	private int IdC;
	@OneToOne
	private D d;
	private static final long serialVersionUID = 1L;

	public C() {
		super();
	}

	public int getIdC() {
		return this.IdC;
	}

	public void setIdC(int IdC) {
		this.IdC = IdC;
	}

	public D getD() {
		return d;
	}

	public void setD(D d) {
		this.d = d;
	}

}
