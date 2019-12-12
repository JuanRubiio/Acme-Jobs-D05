
package acme.features.authenticated.worker.job;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.job.Job;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class WorkerJobListActiveService implements AbstractListService<Worker, Job> {

	@Autowired
	private WorkerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "status", "title", "deadline", "salary", "link", "active", "description");

	}

	@Override
	public Collection<Job> findMany(final Request<Job> request) {
		assert request != null;

		Collection<Job> result = this.repository.getJobsActive();

		return result;
	}

}
