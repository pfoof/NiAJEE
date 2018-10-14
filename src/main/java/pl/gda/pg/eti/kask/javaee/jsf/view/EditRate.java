package pl.gda.pg.eti.kask.javaee.jsf.view;

import lombok.Getter;
import lombok.Setter;
import pl.gda.pg.eti.kask.javaee.jsf.business.Currency;
import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.ExchangeService;
import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.KeypartsService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.*;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@ViewScoped
public class EditRate implements Serializable {

    @Inject
    private ExchangeService exchanageService;

    @Getter
    @Setter
    private CurrencyRate rate = new CurrencyRate();
    
    public Currency[] getCurrencies() {
    	return Currency.values();
    }

    public String saveRate() {
        exchanageService.saveRate(rate);
        return "list_rates?faces-redirect=true";
    }
}
