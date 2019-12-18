
package acme.features.authenticated.message;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.message.Message;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageRepository extends AbstractRepository {

	@Query("select m from Message m where m.id = ?1")
	Message findOneById(int id);

	@Query("select m.thread from Message m where m.id = ?1")
	acme.entities.threads.Thread findThreadByIdMessageId(int id);

	@Query("select t from Message t where t.thread.id = ?1 order by t.moment desc")
	List<Message> findMessageByThreadId(int id);
}
