/*
 * AnonymousUserAccountRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.provider.employer.worker;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.roles.Worker;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerWorkerRepository extends AbstractRepository {

	@Query("select a from Worker a")
	Collection<Worker> findAllWorkers();

	@Query("select a from Worker a where a.id = ?1")
	Worker findOneById(int id);

	@Query("select count(a) from Worker a")
	Integer numberWorkers();

	@Query("select a.worker from Application a where a.id = ?1")
	Collection<Worker> findWorkerByApplication(int id);

}
