
package acme.features.authenticated.offer;

import java.util.Date;

import javax.xml.ws.ServiceMode;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.offer.Offer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractCreateService;

@ServiceMode
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

		request.bind(entity, errors, "moment");
	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "text", "maxPrice", "reward", "minPrice", "ticker");

	}

	@Override
	public Offer instantiate(final Request<Offer> request) {
		Offer res;

		res = new Offer();

		return res;
	}

	@Override
	public void validate(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Offer> request, final Offer entity) {
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
