
package acme.features.authenticated.message.sender;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.customisationParameters.CustomisationParameters;
import acme.entities.message.Message;
import acme.entities.threads.Thread;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedMessageSenderCreateService implements AbstractCreateService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageSenderRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Message> request, final Message entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment", "authenticated.userAccount.username", "thread");

	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("confirm", "false");
		} else {
			request.transfer(model, "confirm");
		}
		request.unbind(entity, model, "title", "tags", "body");

	}

	@Override
	public Message instantiate(final Request<Message> request) {
		Message result;
		result = new Message();
		Principal principal = request.getPrincipal();
		UserAccount aut = this.repository.findUserAccount(principal.getAccountId());
		Thread thread = this.repository.findThreadById(request.getModel().getInteger("threadId"));
		result.setSender(aut);
		result.setThread(thread);
		return result;

	}

	@Override
	public void validate(final Request<Message> request, final Message entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		Boolean isConfirmed = request.getModel().getBoolean("confirm");

		errors.state(request, isConfirmed, "confirm", "authenticated.message.form.checkbox");

		CustomisationParameters custom = this.repository.findCustomParameters();
		double contSpam = 0.0;
		double conPalabras = 0.0;
		String todasPalabras = "";
		todasPalabras = entity.getBody() + " " + entity.getTitle() + " " + entity.getTags();
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
						if (l.trim().equals(s.trim())) {
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
						if (l.trim().equals(s.trim())) {
							if (StringUtils.isNotBlank(custom.getSpamWordsEn()) && !custom.getSpamWordsEn().contains(s.trim())) {
								contSpam++;
							}
						}

					}
				}
			}
		}
		Double porcentajeSpam = contSpam / conPalabras * 100;

		boolean isSpam = porcentajeSpam >= custom.getSpamThreshold();
		errors.state(request, !isSpam, "body", "authenticated.message.error.spam");

	}

	@Override
	public void create(final Request<Message> request, final Message entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		Thread thread;
		moment = new Date(System.currentTimeMillis() - 1);

		entity.setMoment(moment);
		int threadId = request.getModel().getInteger("threadId");
		thread = this.repository.findThreadById(threadId);

		entity.setThread(thread);
		this.repository.save(entity);

	}

}
