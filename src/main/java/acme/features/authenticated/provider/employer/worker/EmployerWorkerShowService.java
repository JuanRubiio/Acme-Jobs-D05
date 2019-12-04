
package acme.features.authenticated.provider.employer.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Employer;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerWorkerShowService implements AbstractShowService<Employer, Worker> {

	@Autowired
	EmployerWorkerRepository repository;


	@Override
	public boolean authorise(final Request<Worker> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Worker> request, final Worker entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "qualificationsRecord", "skillsRecord");
		model.setAttribute("userName", entity.getUserAccount().getUsername());
		model.setAttribute("fullName", entity.getUserAccount().getIdentity().getFullName());
		model.setAttribute("email", entity.getUserAccount().getIdentity().getEmail());
	}

	@Override
	public Worker findOne(final Request<Worker> request) {

		assert request != null;

		Worker result;
		int id;

		String[] aux = request.getServletRequest().getQueryString().trim().split("=");
		request.getServletRequest().getQueryString();
		id = Integer.parseInt(aux[1]);

		result = this.repository.findOneWorkerByApplication(id);

		return result;
	}

}
