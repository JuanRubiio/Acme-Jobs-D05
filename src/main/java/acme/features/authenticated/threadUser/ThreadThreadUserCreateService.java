
package acme.features.authenticated.threadUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.threads.Thread;
import acme.entities.threads.ThreadUser;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractCreateService;

@Service
public class ThreadThreadUserCreateService implements AbstractCreateService<Authenticated, ThreadUser> {

	@Autowired
	private ThreadThreadUserRepository repository;


	@Override
	public boolean authorise(final Request<ThreadUser> request) {
		assert request != null;
		// TODO Solo podra meter un usuario en un hilo si es su hilo
		int threadId = request.getModel().getInteger("threadId");
		int id = request.getPrincipal().getAccountId();
		ThreadUser threadUser = this.repository.findOneByThreadIdAndUserId(threadId, id);
		boolean res = threadUser.getCreatorThread();
		return res;
	}

	@Override
	public void bind(final Request<ThreadUser> request, final ThreadUser entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void unbind(final Request<ThreadUser> request, final ThreadUser entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

	}

	@Override
	public ThreadUser instantiate(final Request<ThreadUser> request) {
		assert request != null;

		ThreadUser result;
		int userAccountId;
		int threadId;

		userAccountId = request.getModel().getInteger("idUserAccount");
		threadId = request.getModel().getInteger("threadId");

		UserAccount userAccount = this.repository.findOneUserAccountById(userAccountId);
		Thread thread = this.repository.findOneById(threadId);

		result = new ThreadUser();
		result.setUser(userAccount);
		result.setThread(thread);
		result.setCreatorThread(false);

		return result;
	}

	@Override
	public void validate(final Request<ThreadUser> request, final ThreadUser entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<ThreadUser> request, final ThreadUser entity) {
		assert request != null;

		this.repository.save(entity);
	}
}
