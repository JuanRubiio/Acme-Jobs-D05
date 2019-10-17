
package acme.features.anonymous.bulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletin.Bulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousBulletinCreateService implements AbstractCreateService<Anonymous, Bulletin> {

	@Autowired
	AnonymousBulletinRepository repository;


	@Override
	public boolean authorise(final Request<Bulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Bulletin> request, final Bulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Bulletin> request, final Bulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "surname", "nif", "type", "body");
	}

	@Override
	public Bulletin instantiate(final Request<Bulletin> request) {
		assert request != null;

		Bulletin result;

		result = new Bulletin();

		return result;
	}

	@Override
	public void validate(final Request<Bulletin> request, final Bulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Bulletin> request, final Bulletin entity) {
		assert request != null;
		assert entity != null;

		Collection<Bulletin> bulletinSurname = this.repository.findBySurname(entity.getSurname());
		if (bulletinSurname == null || bulletinSurname.isEmpty()) {
			entity.setBulletinName(entity.getSurname() + " Bulletin");
		} else {
			Collection<Bulletin> bulletinName = this.repository.findByName(entity.getName());

			if (bulletinName == null || bulletinName.isEmpty()) {
				entity.setBulletinName(entity.getName() + " Bulletin");

			} else {

				entity.setBulletinName(entity.getNif() + " Bulletin");

			}
		}
		this.repository.save(entity);

	}

}
