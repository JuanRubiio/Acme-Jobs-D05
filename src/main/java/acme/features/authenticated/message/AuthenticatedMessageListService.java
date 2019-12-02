
package acme.features.authenticated.message;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.message.Message;
import acme.entities.threads.Thread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedMessageListService implements AbstractListService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;
		Thread thread = this.repository.findThreadById(request.getModel().getInteger("id"));
		List<Authenticated> authenticateds = (List<Authenticated>) thread.getAuthenticateds();
		Principal principal = request.getPrincipal();
		boolean result = authenticateds.stream().filter(x -> x.getUserAccount().getId() == principal.getAccountId()).count() > 0;
		return result;
	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "tags", "body");
	}

	@Override
	public Collection<Message> findMany(final Request<Message> request) {

		assert request != null;

		Collection<Message> result;
		Thread thread = this.repository.findThreadById(request.getModel().getInteger("id"));
		thread.getMessages().size();
		result = thread.getMessages();
		return result;
	}

}
