
package acme.features.authenticated.offer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.offer.Offer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

public class AuthenticatedOfferListService implements AbstractListService<Authenticated, Offer> {

	@Autowired
	private AuthenticatedOfferRepository repository;


	@Override
	public boolean authorise(final Request<Offer> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "text", "minPrice", "maxPrice");

	}

	@Override
	public Collection<Offer> findMany(final Request<Offer> request) {
		assert request != null;
		Collection<Offer> result;

		result = this.repository.findOffersActive();

		return result;
	}

}
