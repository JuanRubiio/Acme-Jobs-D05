
package acme.features.administrator.chart;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorChartRepository extends AbstractRepository {

	@Query("Select Count(ua) from CompanyRecord ua group by ua.sector order by ua.sector ")
	Integer[] getTotalNumberCompaniesSector();

	@Query("Select Count(ua) from InvestorRecord ua group by ua.sector order by ua.sector")
	Integer[] getTotalNumberInvestorSector();

}
