
package acme.entities.banners;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class NonCommercialBanner extends Banner {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 8300569459596372459L;

	private String				jingle;

}
