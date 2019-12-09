
package acme.features.authenticated.provider.employer.duty;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.duty.Duty;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerDutyCreateService implements AbstractCreateService<Employer, Duty> {

	@Autowired
	private EmployerDutyRepository repository;


	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Duty> request, final Duty entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "percentage");

	}

	@Override
	public Duty instantiate(final Request<Duty> request) {
		Duty res;

		res = new Duty();

		return res;
	}

	@Override
	public void validate(final Request<Duty> request, final Duty entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		String[] aux = request.getServletRequest().getQueryString().trim().split("=");
		int idJob = Integer.parseInt(aux[1]);
		Double total = new Double(0);
		Collection<Duty> duties = this.repository.findAllByJob(idJob);
		if (duties != null && !duties.isEmpty()) {
			for (Duty d : duties) {
				total = total + d.getPercentage();
			}
		}
		if (total > new Double(100)) {
			errors.state(request, false, "percentage", "employer.duty.percentaje");
		}
	}

	@Override
	public void create(final Request<Duty> request, final Duty entity) {

		this.repository.save(entity);
	}

}
