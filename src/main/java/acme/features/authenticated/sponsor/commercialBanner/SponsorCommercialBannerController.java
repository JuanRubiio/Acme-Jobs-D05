
package acme.features.authenticated.sponsor.commercialBanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.banners.CommercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/sponsor/commercial-banner/")
public class SponsorCommercialBannerController extends AbstractController<Sponsor, CommercialBanner> {

	@Autowired
	private SponsorCommercialBannerListService		mineService;

	@Autowired
	private SponsorCommercialBannerShowService		showService;

	@Autowired
	private SponsorCommercialBannerCreateService	createService;

	@Autowired
	private SponsorCommercialBannerUpdateService	updateService;

	@Autowired
	private SponsorCommercialBannerDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.LIST, this.mineService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);

	}

}
