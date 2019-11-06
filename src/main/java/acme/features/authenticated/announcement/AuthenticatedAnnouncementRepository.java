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

package acme.features.authenticated.announcement;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.announcements.Announcement;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAnnouncementRepository extends AbstractRepository {

	/* La query muestra los anuncios que tengan una fecha anterior o igual a 30 días */
	@Query("select a from Announcement a where datediff(curdate(), a.moment) <=30")
	Collection<Announcement> findAnnouncementThisMonth();

	@Query("select a from Announcement a")
	Collection<Announcement> findAllAnnouncements();

	@Query("select a from Announcement a where a.id = ?1")
	Announcement findOneById(int id);

	@Query("select count(a) from Announcement a")
	Integer numberAnnouncements();
}
