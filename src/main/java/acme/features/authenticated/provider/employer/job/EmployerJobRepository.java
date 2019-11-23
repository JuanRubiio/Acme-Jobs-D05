
package acme.features.authenticated.provider.employer.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.job.Job;
import acme.framework.repositories.AbstractRepository;

public interface EmployerJobRepository extends AbstractRepository {

	@Query("select ua from Job ua where ua.employer.id = ?1")
	Collection<Job> getJobsByEmployerId(int id);

	@Query("select ua from Job ua where ua.id = ?1")
	Job findJobById(int id);
}
