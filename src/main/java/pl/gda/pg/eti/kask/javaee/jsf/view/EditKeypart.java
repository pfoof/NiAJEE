package pl.gda.pg.eti.kask.javaee.jsf.view;

import lombok.Getter;
import lombok.Setter;
import pl.gda.pg.eti.kask.javaee.jsf.business.Currency;
import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.KeypartsService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.*;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@ViewScoped
public class EditKeypart implements Serializable {

    @Inject
    private KeypartsService keypartsService;

    @Getter
    @Setter
    private Keypart keyPart = new Keypart();

    public Collection<Owner> getAvailableUsers() {
        return keypartsService.findAllUsers();
    }
    
    public Currency[] getCurrencies() {
    	return Currency.values();
    }

    public String saveKeypart() {
        keypartsService.saveKeypart(keyPart);
        return "list_keyparts?faces-redirect=true";
    }
}
