
package acme.features.authenticated.auditor.auditRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditRecord.AuditRecord;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuditorAuditRecordShowService implements AbstractShowService<Auditor, AuditRecord> {

	@Autowired
	AuditorAuditRecordRepository repository;


	@Override
	public boolean authorise(final Request<AuditRecord> request) {
		boolean result;
		int arId;

		AuditRecord ar;
		Auditor auditor;
		Principal principal;

		arId = request.getModel().getInteger("id");
		ar = this.repository.findOneAuditRecordById(arId);
		auditor = ar.getAuditor();
		principal = request.getPrincipal();

		result = auditor.getUserAccount().getId() == principal.getAccountId();
		return result;
	}

	@Override
	public void unbind(final Request<AuditRecord> request, final AuditRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		int auditRecorddId = request.getModel().getInteger("id");
		AuditRecord aud = this.repository.findOneAuditRecordById(auditRecorddId);
		int propietarioId = aud.getAuditor().getUserAccount().getId();
		Principal principal = request.getPrincipal();
		int myId = principal.getAccountId();
		boolean hasAccess = propietarioId != myId;
		model.setAttribute("hasAccess", hasAccess);

		request.unbind(entity, model, "title", "moment", "status", "body");

	}

	@Override
	public AuditRecord findOne(final Request<AuditRecord> request) {
		assert request != null;

		int AuditRecordId;
		AuditRecord result;
		AuditRecordId = request.getModel().getInteger("id");
		result = this.repository.findOneAuditRecordById(AuditRecordId);

		return result;
	}

}
