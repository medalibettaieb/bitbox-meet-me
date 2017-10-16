package training.inheritance;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Entity implementation class for Entity: Vehicule
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicule implements Serializable {

	@Id
	private int mat;
	private String color;
	private static final long serialVersionUID = 1L;

	public Vehicule() {
		super();
	}

	public int getMat() {
		return this.mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
