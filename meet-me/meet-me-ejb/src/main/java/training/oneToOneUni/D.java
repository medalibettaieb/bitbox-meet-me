package training.oneToOneUni;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: D
 *
 */
@Entity

public class D implements Serializable {

	   
	@Id
	private int IdD;
	
	private static final long serialVersionUID = 1L;

	public D() {
		super();
	}   
	public int getIdD() {
		return this.IdD;
	}

	public void setIdD(int IdD) {
		this.IdD = IdD;
	}
   
}
