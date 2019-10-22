
package acme.features.anonymous.jimenezbulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.JimenezBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousJimenezBulletinListService implements AbstractListService<Anonymous, JimenezBulletin> {

	@Autowired
	AnonymousJimenezBulletinRepository repository;


	@Override
	public boolean authorise(final Request<JimenezBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<JimenezBulletin> request, final JimenezBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "bulletinName", "type", "body");

	}

	@Override
	public Collection<JimenezBulletin> findMany(final Request<JimenezBulletin> request) {
		assert request != null;
		Collection<JimenezBulletin> result;

		result = this.repository.findAllJimenezBulletin();

		return result;
	}

}
