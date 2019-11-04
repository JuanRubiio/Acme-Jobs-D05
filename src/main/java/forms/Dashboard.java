
package forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	private static final long	serialVersionUID	= 5643778293563775013L;

	Double						TotalNumberCompaniesGroupedBySector;
	Double						TotaNumbeInvestorGroupedBySector;

}
