package pl.gda.pg.eti.kask.javaee.jsf.api.converters;

import javax.enterprise.context.Dependent;
import javax.faces.convert.FacesConverter;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.ExchangeService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.CurrencyRate;

@FacesConverter(forClass = CurrencyRate.class, managed = true)
@Dependent
public class CurrencyRateConverter extends ExchangeEntityConverter<CurrencyRate> {

    public CurrencyRateConverter() {
        super(CurrencyRate.class, CurrencyRate::getId, ExchangeService::findRate);
    }
}
