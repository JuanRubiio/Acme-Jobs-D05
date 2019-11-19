
package acme.features.administrator.investorrecord;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investorRecord.InvestorRecord;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorInvestorRecordCreateService implements AbstractCreateService<Administrator, InvestorRecord> {

	@Autowired
	private AdministratorInvestorRecordRepository repository;
	//TODO: VALIDACION DE LA FECHA NO PASADA


	@Override
	public boolean authorise(final Request<InvestorRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<InvestorRecord> request, final InvestorRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<InvestorRecord> request, final InvestorRecord entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "nameInvestor", "sector", "investingStatement", "stars");
	}

	@Override
	public InvestorRecord instantiate(final Request<InvestorRecord> request) {
		InvestorRecord result;

		result = new InvestorRecord();
		return result;
	}

	@Override
	public void validate(final Request<InvestorRecord> request, final InvestorRecord entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean isFuture = false;

		if (entity.getInvestingStatement() != null) {
			if (entity.getInvestingStatement().before(new Date())) {
				isFuture = false;
			} else {
				isFuture = true;
			}
		}

		errors.state(request, isFuture, "investingStatement", "administrator.create.investingstatementpast");

	}

	@Override
	public void create(final Request<InvestorRecord> request, final InvestorRecord entity) {
		this.repository.save(entity);
	}

}
