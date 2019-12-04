
package acme.features.authenticated.sponsor.noncommercialBanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.NonCommercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class SponsorNonCommercialBannerShowService implements AbstractShowService<Sponsor, NonCommercialBanner> {

	@Autowired
	private SponsorNonCommercialBannerRepository repository;


	@Override
	public boolean authorise(final Request<NonCommercialBanner> request) {
		boolean result;
		int ncmbId;

		NonCommercialBanner ncmb;
		Sponsor sponsor;
		Principal principal;

		ncmbId = request.getModel().getInteger("id");
		ncmb = this.repository.findOneById(ncmbId);
		sponsor = ncmb.getSponsor();
		principal = request.getPrincipal();

		result = sponsor.getUserAccount().getId() == principal.getAccountId();
		return result;
	}

	@Override
	public void unbind(final Request<NonCommercialBanner> request, final NonCommercialBanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "target", "sponsor", "jingle");

	}

	@Override
	public NonCommercialBanner findOne(final Request<NonCommercialBanner> request) {
		assert request != null;

		int Id;
		NonCommercialBanner result;

		Id = request.getModel().getInteger("id");
		result = this.repository.findOneById(Id);
		return result;
	}

}
