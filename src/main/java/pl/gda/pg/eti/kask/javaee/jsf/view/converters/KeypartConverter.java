package pl.gda.pg.eti.kask.javaee.jsf.view.converters;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.KeypartsService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Keypart;

import javax.enterprise.context.Dependent;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Keypart.class, managed = true)
@Dependent
public class KeypartConverter extends AbstractEntityConverter<Keypart> {

    public KeypartConverter() {
        super(Keypart::getId, KeypartsService::findKeypart);
    }
}
