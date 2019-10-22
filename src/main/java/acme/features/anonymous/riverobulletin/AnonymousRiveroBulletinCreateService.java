
package acme.features.anonymous.riverobulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletin.RiveroBulletin;
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

		request.unbind(entity, model, "name", "surname", "nif", "type", "body");
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

		Collection<RiveroBulletin> bulletinSurname = this.repository.findBySurname(entity.getSurname());
		if (bulletinSurname == null || bulletinSurname.isEmpty()) {
			entity.setBulletinName(entity.getSurname() + " Bulletin");
		} else {
			Collection<RiveroBulletin> bulletinName = this.repository.findByName(entity.getName());

			if (bulletinName == null || bulletinName.isEmpty()) {
				entity.setBulletinName(entity.getName() + " Bulletin");

			} else {

				entity.setBulletinName(entity.getNif() + " Bulletin");

			}
		}
		this.repository.save(entity);

	}

}
