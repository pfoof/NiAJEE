package pl.gda.pg.eti.kask.javaee.jsf.view.converters;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.KeypartsService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Owner;

import javax.enterprise.context.Dependent;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Owner.class, managed = true)
@Dependent
public class UserConverter extends AbstractEntityConverter<Owner> {

    public UserConverter() {
        super(Owner::getId, KeypartsService::findUser);
    }
}
