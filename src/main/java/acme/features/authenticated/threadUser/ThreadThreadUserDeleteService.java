
package acme.features.authenticated.threadUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.threads.ThreadUser;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractDeleteService;

@Service
public class ThreadThreadUserDeleteService implements AbstractDeleteService<Authenticated, ThreadUser> {

	@Autowired
	private ThreadThreadUserRepository repository;


	@Override
	public boolean authorise(final Request<ThreadUser> request) {
		assert request != null;
		// TODO solo podra borrar a un usuario de un hilo si es su hilo
		int threadUserId = request.getModel().getInteger("id");
		ThreadUser threadUser = this.repository.findOneThreadUserAccountById(threadUserId);
		int threadId = threadUser.getThread().getId();
		int id = request.getPrincipal().getActiveRoleId();
		ThreadUser threadUser2 = this.repository.findOneByThreadIdAndUserId(threadId, id);
		boolean res = threadUser2.getCreatorThread();
		return res;
	}

	@Override
	public void bind(final Request<ThreadUser> request, final ThreadUser entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
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

	@Override
	public void validate(final Request<ThreadUser> request, final ThreadUser entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		int threadId = request.getModel().getInteger("id");
		ThreadUser threadUser = this.repository.findOneThreadUserAccountById(threadId);
		int userAccountId = threadUser.getUser().getId();
		int id = request.getPrincipal().getAccountId();
		boolean sameUser = id == userAccountId;
		errors.state(request, !sameUser, "user.username", "threadUser.delete.creatorThread");

	}

	@Override
	public void delete(final Request<ThreadUser> request, final ThreadUser entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);
	}

}
