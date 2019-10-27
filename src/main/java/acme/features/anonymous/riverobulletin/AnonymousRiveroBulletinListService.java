
package acme.features.anonymous.riverobulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.RiveroBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousRiveroBulletinListService implements AbstractListService<Anonymous, RiveroBulletin> {

	@Autowired
	AnonymousRiveroBulletinRepository repository;


	@Override
	public boolean authorise(final Request<RiveroBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<RiveroBulletin> request, final RiveroBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "bulletinName", "type", "body");

	}

	@Override
	public Collection<RiveroBulletin> findMany(final Request<RiveroBulletin> request) {
		assert request != null;
		Collection<RiveroBulletin> result;

		result = this.repository.findAllBulletin();

		return result;
	}

}
