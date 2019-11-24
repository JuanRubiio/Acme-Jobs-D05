
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

	@Query("Select Count(ua) from InvestorRecord ua")
	Integer getTotalNumberInvestorRecords();

	@Query("select min(o.reward.amount) from Request o where o.deadline > now()")
	Double getMinRewardActiveRequest();

	@Query("select max(o.reward.amount) from Request o where o.deadline > now()")
	Double getMaxRewardActiveRequest();

	@Query("select avg(o.reward.amount) from Request o where o.deadline > now()")
	Double getAvgRewardActiveRequest();

	@Query("select stddev(o.reward.amount) from Request o where o.deadline > now()")
	Double getDesvRewardActiveRequest();

	@Query("select min(o.reward.amount) from Offer o where o.deadline > now()")
	Double getMinRewardActiveOffer();

	@Query("select max(o.reward.amount) from Offer o where o.deadline > now()")
	Double getMaxRewardActiveOffer();

	@Query("select avg(o.reward.amount) from Offer o where o.deadline > now()")
	Double getAvgRewardActiveOffer();

	@Query("select stddev(o.reward.amount) from Offer o where o.deadline > now()")
	Double getDesvRewardActiveOffer();

	@Query("select avg(ua.jobs.size) from Employer ua")
	Double getavgNumberJobOEmployer();

}
