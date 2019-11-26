
package acme.features.authenticated.consumer.offer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offer.Offer;
import acme.entities.roles.Consumer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ConsumerOfferCreateService implements AbstractCreateService<Consumer, Offer> {

	@Autowired
	private ConsumerOfferRepository repository;


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

		request.unbind(entity, model, "title", "deadline", "text", "maxPrice", "reward", "minPrice", "ticker", "moment", "confirmation");

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
		boolean isDuplicated, isConfirmed, isFuture = false;
		boolean correctRewardMin = false;
		boolean correctRewardMax = false;

		isDuplicated = this.repository.findByTicker(entity.getTicker()) != null;
		errors.state(request, !isDuplicated, "ticker", "authenticated.consumer.duplicatedtiker");

		if (entity.getDeadline() != null) {
			if (entity.getDeadline().before(new Date())) {
				isFuture = false;
			} else {
				isFuture = true;
			}
			errors.state(request, isFuture, "deadline", "authenticated.consumer.deadlinepast");

		}

		if (entity.getConfirmation() == false) {
			isConfirmed = false;
		} else {
			isConfirmed = true;
		}

		errors.state(request, isConfirmed, "confirmation", "authentication.offer.isconfirmation");

		if (entity.getMaxPrice() != null && entity.getMaxPrice().getAmount() != null && entity.getReward() != null && entity.getReward().getAmount() != null) {
			if (entity.getMaxPrice().getAmount() < entity.getReward().getAmount()) {
				correctRewardMax = true;
			}

			errors.state(request, !correctRewardMax, "reward", "authentication.offer.correctRewardMax");
		}
		if (entity.getMinPrice() != null && entity.getMinPrice().getAmount() != null && entity.getReward() != null && entity.getReward().getAmount() != null) {
			if (entity.getMinPrice().getAmount() > entity.getReward().getAmount()) {
				correctRewardMin = true;
			}

			errors.state(request, !correctRewardMin, "reward", "authentication.offer.correctRewardMin");
		}
	}

	@Override
	public void create(final Request<Offer> request, final Offer entity) {
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
