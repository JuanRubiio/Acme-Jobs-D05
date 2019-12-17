
package acme.features.authenticated.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.threads.Thread;
import acme.entities.threads.ThreadUser;
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
		Principal principal = request.getPrincipal();
		int userId = principal.getAccountId();
		UserAccount user = this.repository.findUserAccountById(userId);
		ThreadUser tu = this.repository.findOneByThreadIdAndUserId(idThread, userId);

		return tu.getUser().equals(user);
	}

	@Override
	public void unbind(final Request<Thread> request, final Thread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		int idThread = request.getModel().getInteger("id");
		Principal principal = request.getPrincipal();
		int userId = principal.getAccountId();
		ThreadUser threadUser = this.repository.findOneByThreadIdAndUserId(idThread, userId);
		Boolean hasAccess = threadUser.getCreatorThread();
		model.setAttribute("hasAccess", hasAccess);

		request.unbind(entity, model, "title", "moment");

		//		List<Message> messages = this.repository.findMessageByThreadId(entity.getId());
		//
		//		Principal principal = request.getPrincipal();
		//		Message mes = new Message();
		//		for (Message m : messages) {
		//			if (m.getSender().getId() == principal.getAccountId()) {
		//				mes = m;
		//			}
		//		}
		//
		//		UserAccount sender = mes.getSender();
		//
		//		//		UserAccount recipient = mes.getRecipient();
		//		request.unbind(entity, model, "title", "moment");
		//
		//		//		model.setAttribute("recipient", recipient.getUsername());
		//		model.setAttribute("sender", sender.getUsername());

		UserAccount user = entity.getSender();
		model.setAttribute("sender", user.getUsername());

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
