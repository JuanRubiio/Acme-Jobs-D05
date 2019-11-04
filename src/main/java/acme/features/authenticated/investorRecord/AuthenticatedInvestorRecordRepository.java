
package acme.features.authenticated.investorRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investorRecord.InvestorRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedInvestorRecordRepository extends AbstractRepository {

	@Query("select ir from InvestorRecord r")
	Collection<InvestorRecord> findAllInvestorRecords();

	@Query("select ir from InvestorRecord ir where ir.id = ?1")
	InvestorRecord findOneById(int id);

}
