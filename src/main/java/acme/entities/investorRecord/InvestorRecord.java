
package acme.entities.investorRecord;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InvestorRecord extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= -6960635053626263044L;

	@NotBlank
	private String				nameInvestor;

	@NotNull
	private String				sector;

	@NotNull
	private Date				investingStatement;

	@NotNull
	@Range(min = 0, max = 5)
	private int					stars;
}
