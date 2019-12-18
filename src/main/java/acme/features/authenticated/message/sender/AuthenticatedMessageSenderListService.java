
package acme.features.authenticated.message.sender;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.message.Message;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedMessageSenderListService implements AbstractListService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageSenderRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "tags", "moment");
		model.setAttribute("sender", entity.getSender().getUsername());
		model.setAttribute("thread", entity.getThread().getTitle());

	}

	@Override
	public Collection<Message> findMany(final Request<Message> request) {

		assert request != null;

		Collection<Message> result;
		int idThread = request.getModel().getInteger("id");
		List<Message> messages = this.repository.findMessageIAmSenderByIdThread(request.getPrincipal().getAccountId(), idThread);

		result = messages;
		return result;
	}

}
