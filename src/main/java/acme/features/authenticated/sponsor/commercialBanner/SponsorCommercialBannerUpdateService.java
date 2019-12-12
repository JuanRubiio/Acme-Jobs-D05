
package acme.features.authenticated.sponsor.commercialBanner;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.CommercialBanner;
import acme.entities.customisationParameters.CustomisationParameters;
import acme.entities.roles.Sponsor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class SponsorCommercialBannerUpdateService implements AbstractUpdateService<Sponsor, CommercialBanner> {

	@Autowired
	SponsorCommercialBannerRepository repository;


	@Override
	public boolean authorise(final Request<CommercialBanner> request) {
		assert request != null;
		boolean result;
		int sponsorId;
		CommercialBanner cb;
		Sponsor sponsor;
		Principal principal;

		sponsorId = request.getModel().getInteger("id");
		cb = this.repository.findOneById(sponsorId);
		sponsor = cb.getSponsor();
		principal = request.getPrincipal();

		result = sponsor.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void bind(final Request<CommercialBanner> request, final CommercialBanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<CommercialBanner> request, final CommercialBanner entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "target", "creditCard", "monthExpired", "yearExpired", "CVV");
	}

	@Override
	public CommercialBanner findOne(final Request<CommercialBanner> request) {
		assert request != null;

		CommercialBanner result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void validate(final Request<CommercialBanner> request, final CommercialBanner entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

		CustomisationParameters custom = this.repository.findCustomParameters();

		double contSpam1 = 0.0;
		double contSpam2 = 0.0;

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
			}
		}

		if (contSpam1 > 0.0) {
			errors.state(request, false, "picture", "There are spams in picture ");
		}

		if (contSpam2 > 0.0) {
			errors.state(request, false, "slogan", "There are spams in slogan ");
		}

	}

	@Override
	public void update(final Request<CommercialBanner> request, final CommercialBanner entity) {

		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
