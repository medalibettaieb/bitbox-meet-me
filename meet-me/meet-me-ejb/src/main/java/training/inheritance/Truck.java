package training.inheritance;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Truck
 *
 */
@Entity

public class Truck extends Vehicule implements Serializable {

	
	private String typeOf;
	private static final long serialVersionUID = 1L;

	public Truck() {
		super();
	}   
	public String getTypeOf() {
		return this.typeOf;
	}

	public void setTypeOf(String typeOf) {
		this.typeOf = typeOf;
	}
   
}
