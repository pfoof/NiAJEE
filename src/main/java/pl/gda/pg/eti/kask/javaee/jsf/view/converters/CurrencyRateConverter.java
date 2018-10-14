package pl.gda.pg.eti.kask.javaee.jsf.view.converters;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.ExchangeService;
import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.KeypartsService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.CurrencyRate;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Keypart;

import javax.enterprise.context.Dependent;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = CurrencyRate.class, managed = true)
@Dependent
public class CurrencyRateConverter extends ExchangeEntityConverter<CurrencyRate> {

    public CurrencyRateConverter() {
        super(CurrencyRate::getId, ExchangeService::findRate);
    }
}
