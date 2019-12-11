
package acme.features.administrator.requestAuditor;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.requestAuditors.RequestAuditor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorRequestAuditorRepository extends AbstractRepository {

	@Query("select a from RequestAuditor a where a.id = ?1")
	RequestAuditor findOneById(int id);

	@Query("select a from RequestAuditor a")
	Collection<RequestAuditor> findMany();

}
