package pl.gda.pg.eti.kask.javaee.jsf.view;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.KeypartsService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@RequestScoped
public class ListUsers implements Serializable {

    @Inject
    private KeypartsService keypartsService;

    private Collection<Owner> users;

    public Collection<Owner> getUsers() {
        return users != null ? users : (users = keypartsService.findAllUsers());
    }
}
