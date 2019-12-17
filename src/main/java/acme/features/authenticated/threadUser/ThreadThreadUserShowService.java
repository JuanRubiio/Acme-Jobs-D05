
package acme.features.authenticated.threadUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.threads.ThreadUser;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class ThreadThreadUserShowService implements AbstractShowService<Authenticated, ThreadUser> {

	@Autowired
	private ThreadThreadUserRepository repository;


	@Override
	public boolean authorise(final Request<ThreadUser> request) {
		assert request != null;
		// Solo puedes ver un usuario de un hilo si tu eres el creador de dicho hilo
		int userThreadId = request.getModel().getInteger("id");
		ThreadUser userThread = this.repository.findOneThreadUserAccountById(userThreadId);
		int threadId = userThread.getThread().getId();
		int meId = request.getPrincipal().getActiveRoleId();
		ThreadUser userThread2 = this.repository.findOneByThreadIdAndUserId(threadId, meId);
		Boolean res = userThread2.getCreatorThread();

		return res;
	}

	@Override
	public void unbind(final Request<ThreadUser> request, final ThreadUser entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "user.username");
	}

	@Override
	public ThreadUser findOne(final Request<ThreadUser> request) {
		assert request != null;

		ThreadUser result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneThreadUserAccountById(id);

		return result;
	}
}
