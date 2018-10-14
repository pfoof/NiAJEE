package pl.gda.pg.eti.kask.javaee.jsf.business.boundary;

import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Owner;
import pl.gda.pg.eti.kask.javaee.jsf.business.Currency;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.CurrencyRate;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Keypart;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import static java.util.Arrays.asList;
import static java.util.Calendar.FEBRUARY;
import static java.util.Calendar.OCTOBER;

@ApplicationScoped
public class ExchangeService implements Serializable {

    private final SortedMap<Integer, CurrencyRate> rates = new TreeMap<>();

    @PostConstruct
    public void init() {
    	
    	rates.put(Integer.valueOf(1), new CurrencyRate(Integer.valueOf(1), Currency.BITCOIN, Currency.DOGECOIN, 20.0f));
    	rates.put(Integer.valueOf(2), new CurrencyRate(Integer.valueOf(2), Currency.DASH, Currency.BITCOIN, 100.0f));
    	rates.put(Integer.valueOf(3), new CurrencyRate(Integer.valueOf(3), Currency.MONERO, Currency.RIPPLE, 50.13f));
    	
    }

    public Collection<CurrencyRate> findRates() {
    	return rates.values();
    }
    
    public CurrencyRate findRate(int id) {
    	return rates.get(id);
    }

    public void removeRate(CurrencyRate r) {
        rates.remove(r.getId());
    }

    public void saveRate(CurrencyRate r) {
        if (r.getId() == null) {
            r.setId(rates.lastKey() + 1);
        }

        rates.put(r.getId(), r);
    }

}
