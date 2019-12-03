
package acme.features.authenticated.thread;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.message.Message;
import acme.entities.threads.Thread;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedThreadRepository extends AbstractRepository {

	@Query("select t from Thread t where t.id = ?1")
	Thread findOneById(int id);

	@Query("select t from Thread t where t.sender.id = ?1")
	Collection<Thread> findManyByAuthenticatedId(int id);

	@Query("select t from Message t where t.thread.id = ?1")
	List<Message> findMessageByThreadId(int id);

}
