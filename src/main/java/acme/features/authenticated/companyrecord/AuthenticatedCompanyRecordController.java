
package acme.features.authenticated.companyrecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.companyrecord.CompanyRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/company-record/")
public class AuthenticatedCompanyRecordController extends AbstractController<Authenticated, CompanyRecord> {

	@Autowired
	private AuthenticatedCompanyRecordShowService	showService;

	@Autowired
	private AuthenticatedCompanyRecordListService	listService;

	@Autowired
	private AuthenticatedCompanyRecordListService	createService;

	@Autowired
	private AuthenticatedCompanyRecordListService	updateService;

	@Autowired
	private AuthenticatedCompanyRecordListService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}
}
