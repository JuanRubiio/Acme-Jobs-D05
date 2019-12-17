
package acme.entities.threads;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import acme.framework.entities.DomainEntity;
import acme.framework.entities.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ThreadUser extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Thread				thread;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private UserAccount			user;

	@NotNull
	private Boolean				creatorThread;

}
