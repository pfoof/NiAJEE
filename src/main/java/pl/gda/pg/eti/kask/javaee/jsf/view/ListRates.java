package pl.gda.pg.eti.kask.javaee.jsf.view;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.ExchangeService;
import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.KeypartsService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@RequestScoped
public class ListRates implements Serializable {

    @Inject
    private ExchangeService exchangeService;

    private Collection<CurrencyRate> rates;

    public Collection<CurrencyRate> getRates() {
        return rates != null ? rates : (rates = exchangeService.findRates());
    }

    public String removeRate(CurrencyRate rate) {
        exchangeService.removeRate(rate);
        return "list_rates?faces-redirect=true";
    }
}
