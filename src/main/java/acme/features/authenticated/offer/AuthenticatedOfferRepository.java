
package acme.features.authenticated.offer;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.offer.Offer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedOfferRepository extends AbstractRepository {

	@Query("select ua from Offer ua where current_date() between ua.moment and ua.deadline")
	Collection<Offer> findOffersActive();

	@Query("select o from Offer o where o.id = ?1")
	Offer findOneById(int id);

}
