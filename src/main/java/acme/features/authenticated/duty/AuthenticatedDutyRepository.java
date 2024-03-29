
package acme.features.authenticated.duty;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.duty.Duty;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedDutyRepository extends AbstractRepository {

	@Query("select d from Duty d where d.id=?1")
	Duty findOneById(int id);

	@Query("select d from Duty d where d.job.id = ?1")
	Collection<Duty> findAllByJob(int idJob);
}
