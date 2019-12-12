
package acme.features.administrator.chart;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

		request.unbind(entity, model, "totalNumberCompanySector", "totalCompanySector", "totalNumberInvestorSector", "totalInvestorSector", "totalNumberJobStatus", "totalJobStatus", "totalNumberAppStatus", "totalAppStatus", "totalpendingAppFourWeeks",
			"pendingAppFourWeeks", "totalAcceptedAppFourWeeks", "acceptedAppFourWeeks", "totalRejectedAppFourWeeks", "rejectedAppFourWeeks");

	}

	@Override
	public Chart findOne(final Request<Chart> request) {
		Chart res = new Chart();
		List<String> pendingAppFourWeeks = new ArrayList<String>();
		List<String> acceptedAppFourWeeks = new ArrayList<String>();
		List<String> rejectedAppFourWeeks = new ArrayList<String>();

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		List<Integer> totalNumberCompanySector = this.repository.getTotalNumberCompaniesSector();
		List<Integer> totalNumberInvestorSector = this.repository.getTotalNumberInvestorSector();
		List<Integer> totalNumberJobStatus = this.repository.getTotalNumberJobStatus();
		List<Integer> totalNumberAppStatus = this.repository.getTotalNumberAppStatus();
		List<Integer> totalpendingAppFourWeeks = this.repository.getTotalpendingAppFourWeeks();
		List<Integer> totalAcceptedAppFourWeeks = this.repository.getTotalAcceptedAppFourWeeks();
		List<Integer> totalRejectedAppFourWeeks = this.repository.getTotalRejectedAppFourWeeks();

		List<String> totalJobStatus = this.repository.getTotalJobStatus();
		List<String> totalCompanySector = this.repository.getTotalCompaniesSector();
		List<String> totalInvestorSector = this.repository.getTotalInvestorSector();
		List<String> totalAppStatus = this.repository.getTotalAppStatus();
		List<Date> datesPendingAppFourWeeks = this.repository.getPendingAppFourWeeks();
		List<Date> datesAcceptedAppFourWeeks = this.repository.getAcceptedAppFourWeeks();
		List<Date> datesRejectedAppFourWeeks = this.repository.getRejectedAppFourWeeks();

		if (datesPendingAppFourWeeks != null && !datesPendingAppFourWeeks.isEmpty()) {
			for (Date d : datesPendingAppFourWeeks) {
				String dateformat = format.format(d);
				if (!pendingAppFourWeeks.contains(dateformat)) {
					pendingAppFourWeeks.add(dateformat);
				}
			}

		}
		if (datesAcceptedAppFourWeeks != null && !datesAcceptedAppFourWeeks.isEmpty()) {
			for (Date d : datesAcceptedAppFourWeeks) {
				String dateformat = format.format(d);
				if (!acceptedAppFourWeeks.contains(dateformat)) {
					acceptedAppFourWeeks.add(dateformat);
				}
			}

		}
		if (datesRejectedAppFourWeeks != null && !datesRejectedAppFourWeeks.isEmpty()) {
			for (Date d : datesRejectedAppFourWeeks) {
				String dateformat = format.format(d);
				if (!rejectedAppFourWeeks.contains(dateformat)) {
					rejectedAppFourWeeks.add(dateformat);
				}
			}

		}

		res.setTotalCompanySector(totalCompanySector);
		res.setTotalInvestorSector(totalInvestorSector);
		res.setTotalNumberCompanySector(totalNumberCompanySector);
		res.setTotalNumberInvestorSector(totalNumberInvestorSector);
		res.setTotalJobStatus(totalJobStatus);
		res.setTotalNumberJobStatus(totalNumberJobStatus);
		res.setTotalAppStatus(totalAppStatus);
		res.setTotalNumberAppStatus(totalNumberAppStatus);
		res.setPendingAppFourWeeks(pendingAppFourWeeks);
		res.setTotalpendingAppFourWeeks(totalpendingAppFourWeeks);
		res.setAcceptedAppFourWeeks(acceptedAppFourWeeks);
		res.setTotalAcceptedAppFourWeeks(totalAcceptedAppFourWeeks);
		res.setRejectedAppFourWeeks(rejectedAppFourWeeks);
		res.setTotalRejectedAppFourWeeks(totalRejectedAppFourWeeks);

		return res;
	}

}
