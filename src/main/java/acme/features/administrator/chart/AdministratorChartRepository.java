
package acme.features.administrator.chart;

import java.util.Date;
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

	@Query("Select Count(ua) from Application ua where ua.status = 'Pending' and datediff(curdate(), ua.moment) <=28 group by date_format(ua.moment, '%Y-%m-%d') order by date_format(ua.moment, '%Y-%m-%d')")
	List<Integer> getTotalpendingAppFourWeeks();

	@Query("Select ua.moment from Application ua where ua.status = 'Pending' and datediff(curdate(), ua.moment) <=28 group by date_format(ua.moment, '%Y-%m-%d') order by date_format(ua.moment, '%Y-%m-%d')")
	List<Date> getPendingAppFourWeeks();

	@Query("Select Count(ua) from Application ua where ua.status = 'Accepted' and datediff(curdate(), ua.moment) <=28 group by date_format(ua.moment, '%Y-%m-%d') order by date_format(ua.moment, '%Y-%m-%d')")
	List<Integer> getTotalAcceptedAppFourWeeks();

	@Query("Select ua.moment from Application ua where ua.status = 'Accepted' and datediff(curdate(), ua.moment) <=28 group by date_format(ua.moment, '%Y-%m-%d') order by date_format(ua.moment, '%Y-%m-%d')")
	List<Date> getAcceptedAppFourWeeks();

	@Query("Select Count(ua) from Application ua where ua.status = 'Rejected' and datediff(curdate(), ua.moment) <=28 group by date_format(ua.moment, '%Y-%m-%d') order by date_format(ua.moment, '%Y-%m-%d')")
	List<Integer> getTotalRejectedAppFourWeeks();

	@Query("Select ua.moment from Application ua where ua.status = 'Rejected' and datediff(curdate(), ua.moment) <=28 group by date_format(ua.moment, '%Y-%m-%d') order by date_format(ua.moment, '%Y-%m-%d')")
	List<Date> getRejectedAppFourWeeks();
}
