
package acme.entities.creditCard;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Range;

import acme.entities.roles.Sponsor;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "monthExpired"), @Index(columnList = "yearExpired")
})
public class CreditCard extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 2121137363081925360L;

	@NotBlank
	@CreditCardNumber
	private String				creditCard;

	@NotNull
	@Range(min = 1, max = 12)
	private int					monthExpired;

	@NotNull
	@Min(2019)
	private int					yearExpired;

	@NotNull
	@Range(min = 100, max = 999)
	private int					CVV;

	@NotNull
	@Valid
	@OneToOne(optional = false)
	private Sponsor				sponsor;

}
