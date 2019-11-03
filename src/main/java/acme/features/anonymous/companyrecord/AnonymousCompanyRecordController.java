
package acme.features.anonymous.companyrecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.companyrecord.CompanyRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/company-record/")
public class AnonymousCompanyRecordController extends AbstractController<Anonymous, CompanyRecord> {

	@Autowired
	private AnonymousCompanyRecordShowService		showService;

	@Autowired
	private AnonymousCompanyRecordListService		listService;

	@Autowired
	private AnonymousCompanyRecordListTopService	listTopService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);

		super.addCustomCommand(CustomCommand.LIST_TOP, BasicCommand.LIST, this.listTopService);
	}
}
