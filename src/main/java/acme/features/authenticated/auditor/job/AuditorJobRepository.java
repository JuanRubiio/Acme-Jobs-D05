
package acme.features.authenticated.auditor.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.job.Job;
import acme.entities.roles.Auditor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int JobId);

	@Query("select distinct b.job from AuditRecord b where b.auditor.id = ?1")
	Collection<Job> findManyByAuditorId(int AuditorId);

	@Query("select b.auditor from AuditRecord b where b.job = ?1")
	Collection<Auditor> findManyAuditorsByJobId(int JobId);

	@Query("select j from Job j ")
	Collection<Job> findAllJobs();

}
