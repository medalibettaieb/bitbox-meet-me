package training.oneToManyUniSlaveSide;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: I
 *
 */
@Entity

public class I implements Serializable {

	   
	@Id
	private int idI;
	private static final long serialVersionUID = 1L;

	public I() {
		super();
	}   
	public int getIdI() {
		return this.idI;
	}

	public void setIdI(int idI) {
		this.idI = idI;
	}
   
}
