package br.com.fiap.samf.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends Usuario{

	/**
	 * só para ter um discrimator value diferente
	 */
	private static final long serialVersionUID = 8923217190361634594L;

}
