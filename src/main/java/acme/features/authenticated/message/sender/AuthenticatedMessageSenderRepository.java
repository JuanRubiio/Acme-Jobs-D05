
package acme.features.authenticated.message.sender;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.message.Message;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageSenderRepository extends AbstractRepository {

	@Query("select m from Message m where m.id = ?1")
	Message findOneById(int id);

	@Query("select m.thread from Message m where m.id = ?1")
	acme.entities.threads.Thread findThreadByIdMessageId(int id);

	@Query("select t from Message t where t.thread.id = ?1 and t.sender.id = t.thread.sender.id")
	List<Message> findMessageByThreadId(int id);
}
