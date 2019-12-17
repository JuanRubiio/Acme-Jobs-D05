
package acme.features.authenticated.thread;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.message.Message;
import acme.entities.threads.Thread;
import acme.entities.threads.ThreadUser;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedThreadRepository extends AbstractRepository {

	@Query("select t from Thread t where t.id = ?1")
	Thread findOneById(int id);

	@Query("select t from Thread t where t.sender.id = ?1")
	Collection<Thread> findManyByAuthenticatedId(int id);

	@Query("select t from Message t where t.thread.id = ?1")
	List<Message> findMessageByThreadId(int id);

	//	@Query("select t from Thread t where (select u from UserAccount u where u.id=?1) member of t.users")
	//	Collection<Thread> findThreadsWhereIAmInvolved(int id);
	// TODO CORREGIR

	@Query("select t from Thread t " + "inner join ThreadUser tu on tu.thread.id = t.id " + "where tu.user.id = ?1")
	//	@Query("select t from Thread t where t.sender.id = ?1")
	Collection<Thread> findThreadsWhereIAmInvolved(int id);

	@Query("select u from UserAccount u where u.id = ?1")
	UserAccount findUserAccountById(int id);

	@Query("select tu from ThreadUser tu where tu.thread.id =?1 and tu.user.id =?2")
	ThreadUser findOneByThreadIdAndUserId(int threadId, int userId);
}
