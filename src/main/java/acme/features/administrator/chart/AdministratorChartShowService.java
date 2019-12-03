
package acme.features.administrator.chart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Chart;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorChartShowService implements AbstractShowService<Administrator, Chart> {

	@Autowired
	private AdministratorChartRepository repository;


	@Override
	public boolean authorise(final Request<Chart> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Chart> request, final Chart entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalNumberCompanySector", "totalCompanySector", "totalNumberInvestorSector", "totalInvestorSector", "totalNumberJobStatus", "totalJobStatus", "totalNumberAppStatus", "totalAppStatus");

	}

	@Override
	public Chart findOne(final Request<Chart> request) {
		Chart res = new Chart();
		List<Integer> totalNumberCompanySector = this.repository.getTotalNumberCompaniesSector();
		List<Integer> totalNumberInvestorSector = this.repository.getTotalNumberInvestorSector();
		List<Integer> totalNumberJobStatus = this.repository.getTotalNumberJobStatus();
		List<Integer> totalNumberAppStatus = this.repository.getTotalNumberAppStatus();

		List<String> totalJobStatus = this.repository.getTotalJobStatus();
		List<String> totalCompanySector = this.repository.getTotalCompaniesSector();
		List<String> totalInvestorSector = this.repository.getTotalInvestorSector();
		List<String> totalAppStatus = this.repository.getTotalAppStatus();

		res.setTotalCompanySector(totalCompanySector);
		res.setTotalInvestorSector(totalInvestorSector);
		res.setTotalNumberCompanySector(totalNumberCompanySector);
		res.setTotalNumberInvestorSector(totalNumberInvestorSector);
		res.setTotalJobStatus(totalJobStatus);
		res.setTotalNumberJobStatus(totalNumberJobStatus);
		res.setTotalAppStatus(totalAppStatus);
		res.setTotalNumberAppStatus(totalNumberAppStatus);

		return res;
	}

}
