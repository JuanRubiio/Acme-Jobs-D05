
package acme.features.authenticated.threadUser;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.threads.ThreadUser;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractListService;

@Service
public class ThreadThreadUserListService implements AbstractListService<Authenticated, ThreadUser> {

	@Autowired
	private ThreadThreadUserRepository repository;


	@Override
	public boolean authorise(final Request<ThreadUser> request) {
		assert request != null;
		// Solo puedo listar los usuarios de un hilo si soy el dueño de ese hilo
		int threadId = request.getModel().getInteger("id");
		int meId = request.getPrincipal().getAccountId();
		ThreadUser threadUser = this.repository.findOneByThreadIdAndUserId(threadId, meId);
		Boolean res = threadUser.getCreatorThread();

		return res;

	}

	@Override
	public void unbind(final Request<ThreadUser> request, final ThreadUser entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		UserAccount user = entity.getUser();

		request.unbind(entity, model); //DUDA
		model.setAttribute("username", user.getUsername());
		ThreadUser threadUser = this.repository.findOneByThreadIdAndUserId(entity.getThread().getId(), entity.getUser().getId());
		Boolean hasAccess = threadUser.getCreatorThread();
		model.setAttribute("hasAccess", hasAccess);

	}

	@Override
	public Collection<ThreadUser> findMany(final Request<ThreadUser> request) {
		assert request != null;

		Collection<ThreadUser> result;
		int threadId = request.getModel().getInteger("id");

		result = this.repository.findThreadUserInThread(threadId);

		return result;

	}

}
