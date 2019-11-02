
package acme.entities.companyrecord;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CompanyRecord extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1582297483968956288L;

	@NotBlank
	private String				name;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				ceoName;

	@NotBlank
	private String				description;

	@NotBlank
	@URL
	private String				webSite;

	@NotBlank
	@Pattern(regexp = "^(\\+?\\d{3})?\\s?(\\(\\d{4}\\))?\\s?\\d{6,10}$")
	private String				phone;

	@NotBlank
	@Email
	private String				email;

	@NotBlank
	private String				incorporated;

	@NotNull
	@Range(min = 0, max = 5)
	private int					stars;

}
