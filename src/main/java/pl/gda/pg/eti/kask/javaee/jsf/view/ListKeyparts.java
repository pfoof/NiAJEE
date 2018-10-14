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
public class ListKeyparts implements Serializable {

    @Inject
    private KeypartsService keypartsService;

    private Collection<Keypart> keyparts;

    public Collection<Keypart> getKeyparts() {
        return keyparts != null ? keyparts : (keyparts = keypartsService.findAllKeyparts());
    }

    public String removeKeypart(Keypart keypart) {
        keypartsService.removeKeypart(keypart);
        return "list_keyparts?faces-redirect=true";
    }
}
