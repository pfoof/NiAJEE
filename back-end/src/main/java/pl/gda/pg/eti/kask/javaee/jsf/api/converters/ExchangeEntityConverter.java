package pl.gda.pg.eti.kask.javaee.jsf.api.converters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.ExchangeService;

public abstract class ExchangeEntityConverter<V> implements ParamConverterProvider {

    @Inject
    ExchangeService exchangeService;

    Class<V> entityClass;

    private BiFunction<ExchangeService, Integer, V> retrieveFunction;

    private Function<V, Integer> idExtractor;

    ExchangeEntityConverter(Class<V> entityClass, Function<V, Integer> idExtractor, BiFunction<ExchangeService, Integer, V> retrieveFunction) {
        this.entityClass = entityClass;
        this.retrieveFunction = retrieveFunction;
        this.idExtractor = idExtractor;
    }

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (rawType != entityClass) {
            return null;
        }

        return (ParamConverter<T>) new ParamConverter<V>() {
            @Override
            public V fromString(String value) {
                V entity = retrieveFunction.apply(exchangeService, Integer.valueOf(value));

                if (entity == null) {
                    throw new NotFoundException();
                }

                return entity;
            }

            @Override
            public String toString(V entity) {
                return idExtractor.apply(entity).toString();
            }
        };
    }
}
