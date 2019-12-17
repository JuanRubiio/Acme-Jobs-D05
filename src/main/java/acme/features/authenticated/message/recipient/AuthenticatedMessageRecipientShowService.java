
package acme.features.authenticated.message.recipient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.message.Message;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMessageRecipientShowService implements AbstractShowService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageRecipientRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;
		Message message = this.repository.findOneById(request.getModel().getInteger("id"));
		Principal principal = request.getPrincipal();
		UserAccount sender = message.getSender();
		//		UserAccount recipient = message.getRecipient();
		//		boolean result = sender.getId() == principal.getAccountId() || recipient.getId() == principal.getAccountId();
		boolean result = true;
		return result;
	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "tags", "body");
		//		model.setAttribute("recipient", entity.getRecipient().getUsername());
		model.setAttribute("sender", entity.getSender().getUsername());
		model.setAttribute("thread", entity.getThread().getTitle());

	}

	@Override
	public Message findOne(final Request<Message> request) {

		assert request != null;

		Message result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

}
