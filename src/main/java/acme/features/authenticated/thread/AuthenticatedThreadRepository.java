
package acme.features.authenticated.thread;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.threads.Thread;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedThreadRepository extends AbstractRepository {

	@Query("select t from Thread t where t.id = ?1")
	Thread findOneById(int id);

	@Query("select distinct t from Thread t join t.authenticateds a on a.id = ?1")
	Collection<Thread> findManyByAuthenticatedId(int id);

}
