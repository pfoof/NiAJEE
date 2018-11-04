package pl.gda.pg.eti.kask.javaee.jsf.business.entities;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Keypart implements Serializable {
	
    private Integer id;
    private UUID walletId = UUID.randomUUID();
    private Currency currency = Currency.DASH;
    private User owner;

}
