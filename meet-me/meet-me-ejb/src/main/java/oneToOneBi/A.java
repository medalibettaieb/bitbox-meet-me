package oneToOneBi;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: A
 *
 */
@Entity

public class A implements Serializable {

	@Id
	private int IdA;
	@OneToOne
	private B b;
	private static final long serialVersionUID = 1L;

	public A() {
		super();
	}

	public int getIdA() {
		return this.IdA;
	}

	public void setIdA(int IdA) {
		this.IdA = IdA;
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

}
