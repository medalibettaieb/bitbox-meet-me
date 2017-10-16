package training.oneToManyUniSlaveSide;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: J
 *
 */
@Entity

public class J implements Serializable {

	   
	@Id
	private int idJ;
	@ManyToOne
	private I i;
	private static final long serialVersionUID = 1L;

	public J() {
		super();
	}   
	public int getIdJ() {
		return this.idJ;
	}

	public void setIdJ(int idJ) {
		this.idJ = idJ;
	}
	public I getI() {
		return i;
	}
	public void setI(I i) {
		this.i = i;
	}
   
}
