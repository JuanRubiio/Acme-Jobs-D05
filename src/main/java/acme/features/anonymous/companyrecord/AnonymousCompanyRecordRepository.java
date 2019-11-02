
package acme.features.anonymous.companyrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.companyrecord.CompanyRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousCompanyRecordRepository extends AbstractRepository {

	@Query("select ua from CompanyRecord ua")
	Collection<CompanyRecord> findAllCompanyRecords();

	@Query("select o from CompanyRecord o where o.id = ?1")
	CompanyRecord findOneById(int id);

}
