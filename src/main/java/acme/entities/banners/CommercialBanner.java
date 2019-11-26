
package acme.entities.banners;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CommercialBanner extends Banner {

	private static final long	serialVersionUID	= -7826252710121239089L;

	@NotBlank
	@CreditCardNumber
	private String				creditCard;

	//Metemos CVV, Mes y Año de caducidad

	@NotNull
	@Range(min = 1, max = 12)
	private int					monthExpired;

	@NotNull
	@Min(2019)
	private int					yearExpired;

	@NotNull
	@Range(min = 0, max = 999)
	private int					CVV;

}
