
package acme.entities.descriptor;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.entities.duty.Duty;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Descriptor extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 9135092480036378334L;

	@NotBlank
	private String				description;

	//Relationships----------------------------

	@NotNull
	@Valid
	@OneToMany
	private List<Duty>			duties;
}
