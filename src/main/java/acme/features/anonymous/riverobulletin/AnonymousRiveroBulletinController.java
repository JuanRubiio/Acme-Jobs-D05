
package acme.features.anonymous.riverobulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.bulletins.RiveroBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/rivero-bulletin/")
public class AnonymousRiveroBulletinController extends AbstractController<Anonymous, RiveroBulletin> {

	@Autowired
	AnonymousRiveroBulletinCreateService	createService;

	@Autowired
	AnonymousRiveroBulletinListService		listService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
	}

}
