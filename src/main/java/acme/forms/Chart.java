
package acme.forms;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chart implements Serializable {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 3003067640228080373L;

	private List<Integer>		totalNumberCompanySector;
	private List<String>		totalCompanySector;
	private List<Integer>		totalNumberInvestorSector;
	private List<String>		totalInvestorSector;

}
