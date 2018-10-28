package pl.gda.pg.eti.kask.javaee.jsf.business.entities;

import lombok.*;
import pl.gda.pg.eti.kask.javaee.jsf.business.Currency;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Keypart implements Serializable {

	@Getter
    public Integer id;
    
    private byte[] payload;
    
    private List<Owner> owner = new ArrayList<>();
    
    private Currency currency;
   
    private UUID walletUUID = UUID.randomUUID();

}

