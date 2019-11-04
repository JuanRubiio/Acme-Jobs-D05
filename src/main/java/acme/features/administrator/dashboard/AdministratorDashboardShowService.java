
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

		request.unbind(entity, model, "totalNumberCompanyRecords", "totalNumberAnnonuncements", "totalNumberInvestorRecords", "minRewardActiveRequest", "maxRewardActiveRequest", "avgRewardActiveRequest", "desvRewardActiveRequest", "minRewardActiveOffer",
			"maxRewardActiveOffer", "avgRewardActiveOffer", "desvRewardActiveOffer");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {

		Dashboard res = new Dashboard();

		Integer totalNumberCompanyRecords = this.repository.getTotalNumberCompanyRecords();
		Integer totalNumberAnnouncements = this.repository.getTotalNumberAnnouncements();
		Double minRewardActiveOffer = this.repository.getMinRewardActiveOffer();
		Double maxRewardActiveOffer = this.repository.getMaxRewardActiveOffer();
		Double avgRewardActiveOffer = this.repository.getAvgRewardActiveOffer();
		Double desvRewardActiveOffer = this.repository.getAvgRewardActiveOffer();
		res.setTotalNumberCompanyRecords(totalNumberCompanyRecords);
		res.setTotalNumberAnnonuncements(totalNumberAnnouncements);
		res.setMinRewardActiveOffer(minRewardActiveOffer);
		res.setMaxRewardActiveOffer(maxRewardActiveOffer);
		res.setAvgRewardActiveOffer(avgRewardActiveOffer);
		res.setDesvRewardActiveOffer(desvRewardActiveOffer);

		return res;
	}

}
