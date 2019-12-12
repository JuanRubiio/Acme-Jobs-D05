
package acme.features.authenticated.sponsor.commercialBanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.banners.CommercialBanner;
import acme.entities.customisationParameters.CustomisationParameters;
import acme.entities.roles.Sponsor;
import acme.framework.repositories.AbstractRepository;

public interface SponsorCommercialBannerRepository extends AbstractRepository {

	@Query("select c from CommercialBanner c")
	Collection<CommercialBanner> findAllCommercialBanners();

	@Query("select c from CommercialBanner c where c.id = ?1")
	CommercialBanner findOneById(int id);

	@Query("select c from CommercialBanner c where c.sponsor.id = ?1")
	Collection<CommercialBanner> findAllCommercialBannersToSponsor(int id);

	@Query("select s from Sponsor s where s.userAccount.id = ?1")
	Sponsor findSponsorById(int id);

	@Query("select ua from CustomisationParameters ua")
	CustomisationParameters findCustomParameters();
}
