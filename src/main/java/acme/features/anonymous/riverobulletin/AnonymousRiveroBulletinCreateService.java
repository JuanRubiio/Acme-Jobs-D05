
package acme.features.anonymous.riverobulletin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.RiveroBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousRiveroBulletinCreateService implements AbstractCreateService<Anonymous, RiveroBulletin> {

	@Autowired
	AnonymousRiveroBulletinRepository repository;


	@Override
	public boolean authorise(final Request<RiveroBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<RiveroBulletin> request, final RiveroBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<RiveroBulletin> request, final RiveroBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "surname", "nif", "type", "body", "bulletinName");
	}

	@Override
	public RiveroBulletin instantiate(final Request<RiveroBulletin> request) {
		assert request != null;

		RiveroBulletin result;

		result = new RiveroBulletin();

		return result;
	}

	@Override
	public void validate(final Request<RiveroBulletin> request, final RiveroBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<RiveroBulletin> request, final RiveroBulletin entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
