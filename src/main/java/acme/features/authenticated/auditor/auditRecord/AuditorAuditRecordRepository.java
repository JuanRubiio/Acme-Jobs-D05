
package acme.features.authenticated.auditor.auditRecord;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecord.AuditRecord;
import acme.entities.job.Job;
import acme.entities.roles.Auditor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditRecordRepository extends AbstractRepository {

	@Query("select b from AuditRecord b where b.id = ?1")
	AuditRecord findOneAuditRecordById(int id);

	@Query("select b from AuditRecord b where b.job.id = ?1 and b.auditor.userAccount.id = ?2")
	List<AuditRecord> findManyByJobId(int SponsorId, int auditorId);

	@Query("select b from AuditRecord b where b.job.id = ?1 and b.auditor.userAccount.id != ?2")
	List<AuditRecord> findManyByJobIdOther(int SponsorId, int auditorId);

	@Query("select b from AuditRecord b")
	Collection<AuditRecord> findMany();

	@Query("select b from Auditor b where b.id = ?1")
	Auditor findAuditorById(int id);

	@Query("select b from Job b where b.id = ?1")
	Job findJobById(int id);

	@Query("select count(a) from AuditRecord a where a.job.id=?1 and a.auditor.id = ?2")
	Integer countMyAuditRecords(int jobId, int auditorId);

}
