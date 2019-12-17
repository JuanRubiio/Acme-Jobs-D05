/*
 * AuthenticatedUserAccountRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.userAccount;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.threads.ThreadUser;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedUserAccountRepository extends AbstractRepository {

	@Query("select ua from UserAccount ua where ua.id = ?1")
	UserAccount findOneUserAccountById(int id);

	//	@Query("select ut from UserAccount ut where ut.thread.id=?1 and ut.authenticated.id =?2")
	//	UserAccount findOneByThreadIdAndAuthenticatedId(int threadId, int authenticatedId);

	@Query("select u from UserAccount u where u not in (select tu.user from ThreadUser tu where tu.thread.id = ?1)")
	Collection<UserAccount> findThreadUserNotInThread(int threadId);

	@Query("select tu from ThreadUser tu where tu.thread.id=?1 and tu.user.id =?2")
	ThreadUser findOneByThreadIdAndUserId(int threadId, int userId);

}
