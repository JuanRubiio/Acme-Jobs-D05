
package acme.features.authenticated.sponsor.noncommercialBanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.banners.NonCommercialBanner;
import acme.framework.repositories.AbstractRepository;

public interface SponsorNonCommercialBannerRepository extends AbstractRepository {

	@Query("select c from NonCommercialBanner c")
	Collection<NonCommercialBanner> findAllNonCommercialBanners();

	@Query("select c from NonCommercialBanner c where c.id = ?1")
	NonCommercialBanner findOneById(int id);

	@Query("select c from NonCommercialBanner c where c.sponsor.id = ?1")
	Collection<NonCommercialBanner> findAllNonCommercialBannersToSponsor(int id);
}
