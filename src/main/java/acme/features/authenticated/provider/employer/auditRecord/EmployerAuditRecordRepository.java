
package acme.features.authenticated.provider.employer.auditRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecord.AuditRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerAuditRecordRepository extends AbstractRepository {

	@Query("select b from AuditRecord b where b.id = ?1")
	AuditRecord findOneAuditRecordById(int id);

	@Query("select b from AuditRecord b where b.job.id = ?1 and b.status='Published'")
	Collection<AuditRecord> findManyByJobId(int SponsorId);

	@Query("select b from AuditRecord b")
	Collection<AuditRecord> findMany();

}
