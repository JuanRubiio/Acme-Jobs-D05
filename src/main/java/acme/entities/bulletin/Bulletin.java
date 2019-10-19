
package acme.entities.bulletin;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bulletin extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= -2215447280369682048L;

	@NotBlank
	private String				name;

	@NotBlank
	private String				surname;

	@NotBlank
	private String				type;

	@NotBlank
	private String				nif;

	@NotBlank
	private String				body;

	private String				bulletinName;
}
