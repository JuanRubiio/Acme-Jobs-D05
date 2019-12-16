
package acme.features.administrator.requestAuditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requestAuditors.RequestAuditor;
import acme.features.administrator.auditor.AdministratorAuditorRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractDeleteService;

@Service
public class AdministratorAuditorDeclinedService implements AbstractDeleteService<Administrator, RequestAuditor> {

	@Autowired
	private AdministratorAuditorRepository repository;


	@Override
	public boolean authorise(final Request<RequestAuditor> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<RequestAuditor> request, final RequestAuditor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<RequestAuditor> request, final RequestAuditor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "firm", "responsabilityStatement");

	}

	@Override
	public void validate(final Request<RequestAuditor> request, final RequestAuditor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public RequestAuditor findOne(final Request<RequestAuditor> request) {
		assert request != null;

		RequestAuditor result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findRequestAuditorById(id);
		return result;
	}

	@Override
	public void delete(final Request<RequestAuditor> request, final RequestAuditor entity) {

		assert request != null;
		assert entity != null;

		this.repository.delete(entity);

	}
}
