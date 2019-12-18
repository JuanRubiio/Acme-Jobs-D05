
package acme.features.authenticated.message;

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
public class AuthenticatedMessageListService implements AbstractListService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageRepository repository;


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
		model.setAttribute("send", "false");

	}

	@Override
	public Collection<Message> findMany(final Request<Message> request) {

		assert request != null;

		Collection<Message> result;
		List<Message> messages = this.repository.findMessageByThreadId(request.getModel().getInteger("id"));

		result = messages;
		return result;
	}

}
