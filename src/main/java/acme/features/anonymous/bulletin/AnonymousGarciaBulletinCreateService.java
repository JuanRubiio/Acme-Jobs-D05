
package acme.features.anonymous.bulletin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.GarciaBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousGarciaBulletinCreateService implements AbstractCreateService<Anonymous, GarciaBulletin> {

	@Autowired
	AnonymousGarciaBulletinRepository repository;


	@Override
	public boolean authorise(final Request<GarciaBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public GarciaBulletin instantiate(final Request<GarciaBulletin> request) {
		assert request != null;

		GarciaBulletin result;

		result = new GarciaBulletin();

		return result;
	}

	@Override
	public void unbind(final Request<GarciaBulletin> request, final GarciaBulletin entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "surname", "dni", "type", "body");
	}

	@Override
	public void bind(final Request<GarciaBulletin> request, final GarciaBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<GarciaBulletin> request, final GarciaBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<GarciaBulletin> request, final GarciaBulletin entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
