
package acme.features.authenticated.sponsor.noncommercialBanner;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.NonCommercialBanner;
import acme.entities.customisationParameters.CustomisationParameters;
import acme.entities.roles.Sponsor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class SponsorNonCommercialBannerUpdateService implements AbstractUpdateService<Sponsor, NonCommercialBanner> {

	@Autowired
	SponsorNonCommercialBannerRepository repository;


	@Override
	public boolean authorise(final Request<NonCommercialBanner> request) {
		assert request != null;
		boolean result;
		int sponsorId;
		NonCommercialBanner ncb;
		Sponsor sponsor;
		Principal principal;

		sponsorId = request.getModel().getInteger("id");
		ncb = this.repository.findOneById(sponsorId);
		sponsor = ncb.getSponsor();
		principal = request.getPrincipal();

		result = sponsor.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void bind(final Request<NonCommercialBanner> request, final NonCommercialBanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<NonCommercialBanner> request, final NonCommercialBanner entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "target", "jingle");
	}

	@Override
	public NonCommercialBanner findOne(final Request<NonCommercialBanner> request) {
		assert request != null;

		NonCommercialBanner result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void validate(final Request<NonCommercialBanner> request, final NonCommercialBanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		CustomisationParameters custom = this.repository.findCustomParameters();

		double contSpam1 = 0.0;
		double contSpam2 = 0.0;
		double contSpam3 = 0.0;

		if (custom != null && StringUtils.isNotBlank(custom.getSpamWordsEn())) {
			String engSpam = custom.getSpamWordsEn();
			String[] arraySpam = engSpam.split(",");
			List<String> listSpamEn = Arrays.asList(arraySpam);
			for (String s : listSpamEn) {
				if (entity.getPicture().contains(s)) {
					contSpam1++;
				}
				if (entity.getSlogan().contains(s)) {
					contSpam2++;
				}
				if (entity.getJingle().contains(s)) {
					contSpam3++;
				}

			}
		}
		if (custom != null && StringUtils.isNotBlank(custom.getSpamWordsEs())) {
			String esSpam = custom.getSpamWordsEs();
			String[] arraySpam = esSpam.split(",");
			List<String> listSpamEs = Arrays.asList(arraySpam);
			for (String s : listSpamEs) {
				if (entity.getPicture().contains(s)) {
					contSpam1++;
				}
				if (entity.getSlogan().contains(s)) {
					contSpam2++;
				}
				if (entity.getJingle().contains(s)) {
					contSpam3++;
				}
			}
		}

		if (contSpam1 > 0.0) {
			errors.state(request, false, "picture", "There are spams in picture ");
		}

		if (contSpam2 > 0.0) {
			errors.state(request, false, "slogan", "There are spams in slogan ");
		}

		if (contSpam3 > 0.0) {
			errors.state(request, false, "jingle", "There are spams in jingle ");
		}

	}

	@Override
	public void update(final Request<NonCommercialBanner> request, final NonCommercialBanner entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
