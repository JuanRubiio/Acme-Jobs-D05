
package acme.features.authenticated.thread;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.message.Message;
import acme.entities.threads.Thread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedThreadShowService implements AbstractShowService<Authenticated, Thread> {

	@Autowired
	AuthenticatedThreadRepository repository;


	@Override
	public boolean authorise(final Request<Thread> request) {
		assert request != null;
		int idThread = request.getModel().getInteger("id");
		Thread t = this.repository.findOneById(idThread);
		Principal principal = request.getPrincipal();

		UserAccount sender = t.getSender();
		boolean result = sender.getId() == principal.getAccountId();
		return result;
	}

	@Override
	public void unbind(final Request<Thread> request, final Thread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		List<Message> messages = this.repository.findMessageByThreadId(entity.getId());
		Principal principal = request.getPrincipal();
		Message mes = new Message();
		for (Message m : messages) {
			if (m.getSender().getId() == principal.getAccountId()) {
				mes = m;
			}
		}

		UserAccount sender = mes.getSender();
		UserAccount recipient = mes.getRecipient();
		request.unbind(entity, model, "title", "moment");
		model.setAttribute("recipient", recipient.getUsername());
		model.setAttribute("sender", sender.getUsername());
	}

	@Override
	public Thread findOne(final Request<Thread> request) {

		assert request != null;

		Thread result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

}
