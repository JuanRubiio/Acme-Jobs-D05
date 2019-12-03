
package acme.features.administrator.chart;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorChartRepository extends AbstractRepository {

	@Query("Select Count(ua) from CompanyRecord ua group by ua.sector order by ua.sector ")
	List<Integer> getTotalNumberCompaniesSector();

	@Query("Select ua.sector from CompanyRecord ua group by ua.sector order by ua.sector ")
	List<String> getTotalCompaniesSector();

	@Query("Select Count(ua) from InvestorRecord ua group by ua.sector order by ua.sector")
	List<Integer> getTotalNumberInvestorSector();

	@Query("Select ua.sector from InvestorRecord ua group by ua.sector order by ua.sector")
	List<String> getTotalInvestorSector();

	@Query("Select Count(ua) from Job ua group by ua.status order by ua.status")
	List<Integer> getTotalNumberJobStatus();

	@Query("Select ua.status from Job ua group by ua.status order by ua.status")
	List<String> getTotalJobStatus();

	@Query("Select Count(ua) from Application ua group by ua.status order by ua.status")
	List<Integer> getTotalNumberAppStatus();

	@Query("Select ua.status from Application ua group by ua.status order by ua.status")
	List<String> getTotalAppStatus();
}
