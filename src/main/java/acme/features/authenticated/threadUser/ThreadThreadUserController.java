
package acme.features.authenticated.threadUser;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.threads.ThreadUser;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/thread-user/")
public class ThreadThreadUserController extends AbstractController<Authenticated, ThreadUser> {

	@Autowired
	private ThreadThreadUserListService		listService;

	@Autowired
	private ThreadThreadUserShowService		showService;

	@Autowired
	private ThreadThreadUserDeleteService	deleteService;

	@Autowired
	private ThreadThreadUserCreateService	createService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
