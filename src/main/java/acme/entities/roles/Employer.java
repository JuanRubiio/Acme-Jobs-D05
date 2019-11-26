
package acme.entities.roles;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.entities.job.Job;
import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employer extends UserRole {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 6203324719694993625L;

	@NotBlank
	private String				company;

	@NotBlank
	private String				sector;

	@NotNull
	@Valid
	@OneToMany(mappedBy = "employer")
	Collection<Job>				jobs;

}
