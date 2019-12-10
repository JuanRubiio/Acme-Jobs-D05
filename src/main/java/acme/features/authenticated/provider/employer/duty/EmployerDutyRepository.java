
package acme.features.authenticated.provider.employer.duty;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.duty.Duty;
import acme.entities.job.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerDutyRepository extends AbstractRepository {

	@Query("select d from Duty d where d.id=?1")
	Duty findOneById(int id);

	@Query("select d from Duty d where d.job.id = ?1")
	Collection<Duty> findAllByJob(int idJob);

	@Query("select d from Job d where d.id=?1")
	Job findJobById(int id);

	@Query("select d.reference from Job d where d.active = 0")
	List<String> findReferenceJobById();
}
