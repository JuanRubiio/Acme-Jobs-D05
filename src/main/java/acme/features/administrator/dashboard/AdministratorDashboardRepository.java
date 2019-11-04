
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("Select Count(ua) from CompanyRecord ua")
	Integer getTotalNumberCompanyRecords();

	@Query("Select Count(ua) from Announcement ua")
	Integer getTotalNumberAnnouncements();

	//	@Query("Select Count(ua) from InvestorRecord ua")
	//	Integer getTotalNumberInvestorRecords();

	//	@Query("")
	//	Double getMinRewardActiveRequest();
	//
	//	@Query("")
	//	Double getMaxRewardActiveRequest();
	//
	//	@Query("")
	//	Double getAvgRewardActiveRequest();
	//
	//	@Query("")
	//	Double getDesvRewardActiveRequest();

	@Query("select min(o.reward.amount) from Offer o where current_date() between o.moment and o.deadline")
	Double getMinRewardActiveOffer();

	@Query("select max(o.reward.amount) from Offer o where current_date() between o.moment and o.deadline ")
	Double getMaxRewardActiveOffer();

	@Query("select avg(o.reward.amount) from Offer o where current_date() between o.moment and o.deadline ")
	Double getAvgRewardActiveOffer();

	@Query("select stddev(o.reward.amount) from Offer o where current_date() between o.moment and o.deadline ")
	Double getDesvRewardActiveOffer();

}
