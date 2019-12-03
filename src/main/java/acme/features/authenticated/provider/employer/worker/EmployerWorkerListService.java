/*
 * AnonymousShoutListService.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.provider.employer.worker;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Employer;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class EmployerWorkerListService implements AbstractListService<Employer, Worker> {

	// Internal state ---------------------------------------------------------

	@Autowired
	EmployerWorkerRepository repository;


	@Override
	public boolean authorise(final Request<Worker> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Worker> findMany(final Request<Worker> request) {
		assert request != null;

		Collection<Worker> result;
		int id;

		String[] aux = request.getServletRequest().getQueryString().trim().split("=");
		request.getServletRequest().getQueryString();
		id = Integer.parseInt(aux[1]);

		result = this.repository.findWorkerByApplication(id);

		return result;
	}
	@Override
	public void unbind(final Request<Worker> request, final Worker entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "qualificationsRecord", "skillsRecord");
		model.setAttribute("userName", entity.getUserAccount().getUsername());
		model.setAttribute("fullName", entity.getUserAccount().getIdentity().getFullName());
		model.setAttribute("email", entity.getUserAccount().getIdentity().getEmail());

	}

}
