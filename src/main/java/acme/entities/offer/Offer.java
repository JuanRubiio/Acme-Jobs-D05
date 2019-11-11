
package acme.entities.offer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Offer extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= -6960635053626263044L;

	@NotBlank
	private String				title;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				moment;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				deadline;

	@NotBlank
	private String				text;

	@NotNull
	@Valid
	private Money				maxPrice;

	@NotNull
	@Valid
	private Money				reward;

	@NotNull
	@Valid
	private Money				minPrice;

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "^[Oa-zA-Z]{5}-\\d{5}$")
	private String				ticker;

}
