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

package acme.features.anonymous.bulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.GarciaBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousGarciaBulletinRepository extends AbstractRepository {

	@Query("select b from GarciaBulletin b")
	Collection<GarciaBulletin> findMany();

	@Query("select b from GarciaBulletin b where b.name= ?1")
	Collection<GarciaBulletin> findByName(String name);

	@Query("select b from GarciaBulletin b where b.surname= ?1")
	Collection<GarciaBulletin> findBySurname(String surname);

	@Query("select b from GarciaBulletin b where b.dni= ?1")
	Collection<GarciaBulletin> findByDni(String dni);

}
