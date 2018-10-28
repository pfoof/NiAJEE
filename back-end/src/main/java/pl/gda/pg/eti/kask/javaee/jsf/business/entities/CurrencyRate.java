package pl.gda.pg.eti.kask.javaee.jsf.business.entities;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.gda.pg.eti.kask.javaee.jsf.business.Currency;

@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrencyRate {
	Integer id;
	
	Currency from;
	
	Currency to;
	
	float ratio;
}
