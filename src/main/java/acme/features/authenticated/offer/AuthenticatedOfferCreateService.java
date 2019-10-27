
package acme.features.authenticated.offer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offer.Offer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.datatypes.Money;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedOfferCreateService implements AbstractCreateService<Authenticated, Offer> {

	@Autowired
	private AuthenticatedOfferRepository repository;


	@Override
	public boolean authorise(final Request<Offer> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "text", "minPrice", "maxPrice");

	}

	@Override
	public Offer instantiate(final Request<Offer> request) {
		assert request != null;

		Offer offer;
		Money max;
		Money min;

		offer = new Offer();
		max = new Money();
		min = new Money();

		offer.setMaxPrice(max);
		offer.setMinPrice(min);

		return offer;
	}

	@Override
	public void validate(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Offer> request, final Offer entity) {
		assert request != null;
		assert entity != null;

		entity.setMoment(new Date());
		entity.setTicker("Odsar-34245");

		this.repository.save(entity);
	}

}
