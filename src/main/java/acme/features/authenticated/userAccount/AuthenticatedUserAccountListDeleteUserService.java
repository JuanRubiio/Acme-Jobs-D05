
package acme.features.authenticated.userAccount;

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
public class AuthenticatedUserAccountListDeleteUserService implements AbstractListService<Authenticated, UserAccount> {

	@Autowired
	private AuthenticatedUserAccountRepository repository;


	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;
		// Solo puedo listar los usuarios, para borrarlos, de un hilo si soy el dueño de ese hilo
		int threadId = request.getModel().getInteger("threadId");
		int meId = request.getPrincipal().getAccountId();
		ThreadUser threadUser = this.repository.findOneByThreadIdAndUserId(threadId, meId);
		Boolean res = threadUser.getCreatorThread();

		return res;
	}

	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		//		UserAccount user = entity.getUsername();

		request.unbind(entity, model); //DUDA
		model.setAttribute("username", entity.getUsername());

	}

	@Override
	public Collection<UserAccount> findMany(final Request<UserAccount> request) {
		assert request != null;

		Collection<UserAccount> result;
		int threadId = request.getModel().getInteger("threadId");

		result = this.repository.findThreadUserNotInThread(threadId);

		return result;

	}

}
