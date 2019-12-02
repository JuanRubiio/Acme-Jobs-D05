
package acme.features.authenticated.worker.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.job.Job;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerJobShowService implements AbstractShowService<Worker, Job> {

	@Autowired
	private WorkerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		//		boolean result;
		//		int jobId;
		//		Job job;
		//		Employer employer;
		//		Principal principal;
		//
		//		jobId = request.getModel().getInteger("id");
		//		job = this.repository.findJobById(jobId);
		//		employer = job.getEmployer();
		//		principal = request.getPrincipal();
		//
		//		result = job.getActive() || !job.getActive() && employer.getUserAccount().getId() == principal.getAccountId();

		return true;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "reference", "status", "salary", "link", "description", "active");

	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		int jobId;
		Job job;

		jobId = request.getModel().getInteger("id");
		job = this.repository.findJobById(jobId);
		return job;
	}

}
