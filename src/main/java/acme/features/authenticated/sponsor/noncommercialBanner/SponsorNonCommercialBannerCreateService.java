
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
import acme.framework.services.AbstractCreateService;

@Service
public class SponsorNonCommercialBannerCreateService implements AbstractCreateService<Sponsor, NonCommercialBanner> {

	@Autowired
	SponsorNonCommercialBannerRepository repository;


	@Override
	public boolean authorise(final Request<NonCommercialBanner> request) {
		assert request != null;

		return true;
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
	public NonCommercialBanner instantiate(final Request<NonCommercialBanner> request) {
		NonCommercialBanner result;

		int sponsorId = request.getPrincipal().getAccountId();
		Sponsor sponsor = this.repository.findSponsorById(sponsorId);

		result = new NonCommercialBanner();
		result.setSponsor(sponsor);

		return result;
	}

	@Override
	public void validate(final Request<NonCommercialBanner> request, final NonCommercialBanner entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

		CustomisationParameters custom = this.repository.findCustomParameters();

		double contSpam = 0.0;
		double conPalabras = 0.0;
		String todasPalabras = "";
		todasPalabras = entity.getPicture() + " " + entity.getSlogan() + " " + entity.getJingle();
		String[] arrayPalabras = todasPalabras.split(" ");
		List<String> listPalabras = Arrays.asList(arrayPalabras);
		if (custom != null && StringUtils.isNotBlank(custom.getSpamWordsEn())) {
			String engSpam = custom.getSpamWordsEn();
			String[] arraySpam = engSpam.split(",");
			List<String> listSpamEn = Arrays.asList(arraySpam);
			for (String l : listPalabras) {
				if (StringUtils.isNotBlank(l)) {
					conPalabras++;
					for (String s : listSpamEn) {
						if (l.trim().toLowerCase().equals(s.trim().toLowerCase())) {
							contSpam++;
						}

					}
				}
			}
		}
		if (custom != null && StringUtils.isNotBlank(custom.getSpamWordsEs())) {
			String engSpam = custom.getSpamWordsEs();
			String[] arraySpam = engSpam.split(",");
			List<String> listSpamEs = Arrays.asList(arraySpam);
			for (String l : listPalabras) {
				if (StringUtils.isNotBlank(l)) {
					for (String s : listSpamEs) {
						if (l.trim().toLowerCase().equals(s.trim().toLowerCase())) {
							if (StringUtils.isNotBlank(custom.getSpamWordsEn()) && !custom.getSpamWordsEn().contains(s.trim())) {
								contSpam++;
							}
						}

					}
				}
			}
		}
		Double porcentajeSpam = contSpam / conPalabras * 100;

		if (porcentajeSpam > custom.getSpamThreshold()) {
			errors.state(request, false, "picture", "There are spam in this form");
		}

	}

	@Override
	public void create(final Request<NonCommercialBanner> request, final NonCommercialBanner entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
