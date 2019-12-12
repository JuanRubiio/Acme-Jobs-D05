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

package acme.features.administrator.noncommercialBanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.banners.NonCommercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorNonCommercialBannerRepository extends AbstractRepository {

	@Query("select c from NonCommercialBanner c")
	Collection<NonCommercialBanner> findAllNonCommercialBanners();

	@Query("select c from NonCommercialBanner c where c.id = ?1")
	NonCommercialBanner findOneById(int id);

	@Query("select s from Sponsor s where s.userAccount.id = ?1")
	Sponsor findSponsorById(int id);
}
