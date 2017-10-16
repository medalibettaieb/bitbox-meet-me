package training.oneToManyUniMasterSide;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: G
 *
 */
@Entity

public class G implements Serializable {

	   
	@Id
	private int idG;
	@OneToMany
	private List<H>hs;
	private static final long serialVersionUID = 1L;

	public G() {
		super();
	}   
	public int getIdG() {
		return this.idG;
	}

	public void setIdG(int idG) {
		this.idG = idG;
	}
	public List<H> getHs() {
		return hs;
	}
	public void setHs(List<H> hs) {
		this.hs = hs;
	}
   
}
