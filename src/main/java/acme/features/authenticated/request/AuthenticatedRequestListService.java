
package acme.features.authenticated.request;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedRequestListService implements AbstractListService<Authenticated, acme.entities.request.Request> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AuthenticatedRequestRepository repository;


	@Override
	public boolean authorise(final Request<acme.entities.request.Request> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<acme.entities.request.Request> request, final acme.entities.request.Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "deadline", "text", "ticker");

	}

	@Override
	public Collection<acme.entities.request.Request> findMany(final Request<acme.entities.request.Request> request) {
		assert request != null;

		Collection<acme.entities.request.Request> result;
		result = this.repository.findActivesRequests();

		return result;
	}

}
