package training.inheritance;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Car
 *
 */
@Entity

public class Car extends Vehicule implements Serializable {

	private String options;
	private static final long serialVersionUID = 1L;

	public Car() {
		super();
	}

	public String getOptions() {
		return this.options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

}
