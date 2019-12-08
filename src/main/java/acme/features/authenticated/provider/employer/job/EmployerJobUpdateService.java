
package acme.features.authenticated.provider.employer.job;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.customisationParameters.CustomisationParameters;
import acme.entities.job.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerJobUpdateService implements AbstractUpdateService<Employer, Job> {

	@Autowired
	EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;
		boolean result;
		int jobId;
		Job job;
		Employer employer;
		Principal principal;

		jobId = request.getModel().getInteger("id");
		job = this.repository.findJobById(jobId);
		employer = job.getEmployer();
		principal = request.getPrincipal();

		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void bind(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "active");
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "reference", "status", "salary", "link", "description");

	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		Job result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findJobById(id);
		return result;
	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean isDuplicated, isFuture = false;

		isDuplicated = this.repository.findByReference(entity.getReference()) != null;
		errors.state(request, !isDuplicated, "reference", "employer.job.duplicatedReference");

		if (entity.getDeadline() != null) {
			if (entity.getDeadline().before(new Date())) {
				isFuture = false;
			} else {
				isFuture = true;
			}
			errors.state(request, isFuture, "deadline", "authenticated.consumer.deadlinepast");

		}
		if (entity.getActive() != null && entity.getActive() == true) {
			errors.state(request, false, "active", "employer.job.finalmode");
		}

	}

	@Override
	public void update(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;
		Date d = new Date();
		CustomisationParameters custom = this.repository.findCustomParameters();

		double contSpam = 0.0;
		if (custom != null && StringUtils.isNotBlank(custom.getSpamWordsEn())) {
			String engSpam = custom.getSpamWordsEn();
			String[] arraySpam = engSpam.split(",");
			List<String> listSpamEn = Arrays.asList(arraySpam);
			for (String s : listSpamEn) {
				if (entity.getDescription().contains(s) || entity.getTitle().contains(s)) {
					contSpam++;
				}

			}
		}
		if (custom != null && StringUtils.isNotBlank(custom.getSpamWordsEs())) {
			String esSpam = custom.getSpamWordsEs();
			String[] arraySpam = esSpam.split(",");
			List<String> listSpamEs = Arrays.asList(arraySpam);
			for (String s : listSpamEs) {
				if (entity.getDescription().contains(s) || entity.getTitle().contains(s)) {
					contSpam++;
				}

			}
		}

		if (entity.getDeadline().after(d) && "Published".equals(entity.getStatus()) && contSpam < custom.getSpamThreshold()) {
			entity.setActive(true);
		}

		this.repository.save(entity);
	}

}
