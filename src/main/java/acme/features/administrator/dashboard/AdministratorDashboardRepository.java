
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("Select Count(ua) from CompanyRecord ua")
	Integer getTotalNumberCompanyRecords();

	//	@Query("select min(f.reward), max(f.reward), avg(f.reward), stddev(f.reward) from Offer f where current_date() between f.moment and f.deadline")
	//	List<Object> getMinMaxAvgDesvOfferActive();

}
