
package acme.features.authenticated.sponsor.commercialBanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.CommercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class SponsorCommercialBannerShowService implements AbstractShowService<Sponsor, CommercialBanner> {

	@Autowired
	private SponsorCommercialBannerRepository repository;


	@Override
	public boolean authorise(final Request<CommercialBanner> request) {
		boolean result;
		int cmbId;

		CommercialBanner cmb;
		Sponsor sponsor;
		Principal principal;

		cmbId = request.getModel().getInteger("id");
		cmb = this.repository.findOneById(cmbId);
		sponsor = cmb.getSponsor();
		principal = request.getPrincipal();

		result = sponsor.getUserAccount().getId() == principal.getAccountId();
		return result;
	}

	@Override
	public void unbind(final Request<CommercialBanner> request, final CommercialBanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "target", "sponsor", "creditCard", "monthExpired", "yearExpired", "CVV");

	}

	@Override
	public CommercialBanner findOne(final Request<CommercialBanner> request) {
		assert request != null;

		int Id;
		CommercialBanner result;

		Id = request.getModel().getInteger("id");
		result = this.repository.findOneById(Id);
		return result;
	}

}
