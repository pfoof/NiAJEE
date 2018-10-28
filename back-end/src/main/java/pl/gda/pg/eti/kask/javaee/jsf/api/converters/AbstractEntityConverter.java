package pl.gda.pg.eti.kask.javaee.jsf.api.converters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.KeypartsService;

public abstract class AbstractEntityConverter<V> implements ParamConverterProvider {

    @Inject
    KeypartsService keypartsService;

    Class<V> entityClass;

    private BiFunction<KeypartsService, Integer, V> retrieveFunction;

    private Function<V, Integer> idExtractor;

    AbstractEntityConverter(Class<V> entityClass, Function<V, Integer> idExtractor, BiFunction<KeypartsService, Integer, V> retrieveFunction) {
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
                V entity = retrieveFunction.apply(keypartsService, Integer.valueOf(value));

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
