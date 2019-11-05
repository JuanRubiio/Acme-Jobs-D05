
package acme.features.administrator.chart;

import java.util.Arrays;
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

		request.unbind(entity, model, "totalNumberCompanySectorPublic", "totalNumberCompanySectorPrivate", "totalNumberInvestorSectorPublic", "totalNumberInvestorSectorPrivate");

	}

	@Override
	public Chart findOne(final Request<Chart> request) {
		Chart res = new Chart();
		Integer[] totalNumberCompanySector = this.repository.getTotalNumberCompaniesSector();
		Integer[] totalNumberInvestorSector = this.repository.getTotalNumberInvestorSector();

		List<Integer> totalNumberCompanySector_c = Arrays.asList(totalNumberCompanySector);
		List<Integer> totalNumberInvestorSector_c = Arrays.asList(totalNumberInvestorSector);

		if (!totalNumberCompanySector_c.isEmpty()) {
			res.setTotalNumberCompanySectorPublic(totalNumberCompanySector_c.get(1));
			res.setTotalNumberCompanySectorPrivate(totalNumberCompanySector_c.get(0));

		} else {
			res.setTotalNumberCompanySectorPublic(0);
			res.setTotalNumberCompanySectorPrivate(0);
		}

		if (!totalNumberInvestorSector_c.isEmpty()) {
			res.setTotalNumberInvestorSectorPublic(totalNumberInvestorSector_c.get(1));
			res.setTotalNumberInvestorSectorPrivate(totalNumberInvestorSector_c.get(0));

		} else {
			res.setTotalNumberInvestorSectorPublic(0);
			res.setTotalNumberInvestorSectorPrivate(0);
		}

		return res;
	}

}
