package pl.gda.pg.eti.kask.javaee.jsf.view.converters;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.ExchangeService;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.function.BiFunction;
import java.util.function.Function;

abstract class ExchangeEntityConverter<T> implements Converter<T> {

    @Inject
    ExchangeService exchangeService;

    private BiFunction<ExchangeService, Integer, T> retrieveFunction;

    private Function<T, Integer> idExtractor;

    ExchangeEntityConverter(Function<T, Integer> idExtractor, BiFunction<ExchangeService, Integer, T> retrieveFunction) {
        this.retrieveFunction = retrieveFunction;
        this.idExtractor = idExtractor;
    }

    @Override
    public T getAsObject(FacesContext context, UIComponent component, String value) {
        T entity = retrieveFunction.apply(exchangeService, Integer.parseInt(value));

        if (entity == null) {
            context.getExternalContext().setResponseStatus(HttpServletResponse.SC_NOT_FOUND);
            context.responseComplete();
        }

        return entity;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, T value) {
        Integer id = idExtractor.apply(value);
        return id != null ? id.toString() : null;
    }
}
