
package acme.features.authenticated.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.job.Job;
import acme.framework.repositories.AbstractRepository;

public interface AuthenticatedJobRepository extends AbstractRepository {

	@Query("select ua from Job ua where ua.deadline > now() and ua.status = 'published'")
	Collection<Job> getJobsActive();

	@Query("select ua from Job ua where ua.id = ?1")
	Job findJobById(int id);
}
