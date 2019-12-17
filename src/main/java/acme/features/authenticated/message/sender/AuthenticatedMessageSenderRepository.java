
package acme.features.authenticated.message.sender;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.customisationParameters.CustomisationParameters;
import acme.entities.message.Message;
import acme.entities.threads.Thread;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageSenderRepository extends AbstractRepository {

	@Query("select m from Message m where m.id = ?1")
	Message findOneById(int id);

	@Query("select m.thread from Message m where m.id = ?1")
	acme.entities.threads.Thread findThreadByIdMessageId(int id);

	@Query("select t from Message t where t.thread.id = ?1 and t.sender.id = t.thread.sender.id")
	List<Message> findMessageByThreadId(int id);

	@Query("select us from UserAccount us where us.id = ?1 ")
	UserAccount findUserAccount(int id);

	@Query("select t from Thread t where t.id = ?1")
	Thread findThreadById(int id);

	@Query("select ua from CustomisationParameters ua")
	CustomisationParameters findCustomParameters();
}
