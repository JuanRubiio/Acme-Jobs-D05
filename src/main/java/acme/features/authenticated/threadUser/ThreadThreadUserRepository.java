
package acme.features.authenticated.threadUser;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.threads.Thread;
import acme.entities.threads.ThreadUser;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ThreadThreadUserRepository extends AbstractRepository {

	@Query("select t from Thread t where t.id = ?1")
	Thread findOneById(int id);

	@Query("select tua from ThreadUser tua where tua.thread.id = ?1")
	Collection<ThreadUser> findThreadUserInThread(int threadId);

	@Query("select tua from ThreadUser tua where tua.id = ?1")
	ThreadUser findOneThreadUserAccountById(int id);

	@Query("select tua.thread from ThreadUser tua where tua.id = ?1")
	Thread findThreadByThreadUserAccountId(int id);

	@Query("select u from UserAccount u where u.id = ?1")
	UserAccount findOneUserAccountById(int id);

	@Query("select tua from ThreadUser tua where tua.thread.id=?1 and tua.user.id =?2")
	ThreadUser findOneByThreadIdAndUserId(int threadId, int userAccountId);

	@Query("select tua from ThreadUser tua where tua.thread.id = ?1 and tua.creatorThread = 1")
	ThreadUser findSenderInThread(int threadId);

}
