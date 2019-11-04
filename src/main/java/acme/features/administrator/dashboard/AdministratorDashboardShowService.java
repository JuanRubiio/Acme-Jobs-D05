
package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalNumberCompanyRecords");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {

		Dashboard res = new Dashboard();

		Integer totalNumberCompanyRecords = this.repository.getTotalNumberCompanyRecords();

		res.setTotalNumberCompanyRecords(totalNumberCompanyRecords);

		return res;
	}

	private void instantiateDashboard() {
		Dashboard res = new Dashboard();

	}

}
